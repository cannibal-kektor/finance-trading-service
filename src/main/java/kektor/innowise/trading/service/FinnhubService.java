package kektor.innowise.trading.service;

import kektor.innowise.trading.client.FinnhubClient;
import kektor.innowise.trading.dto.trade.CompaniesInfoResponse;
import kektor.innowise.trading.dto.trade.CompanyFinancialsReportResponse;
import kektor.innowise.trading.dto.trade.Stock52WeekMetricsResponse;
import kektor.innowise.trading.dto.trade.TradeQuoteResponse;
import kektor.innowise.trading.dto.trade.TradeQuotesPeriodResponse;
import kektor.innowise.trading.dto.trade.finnhub.FinnhubFinancialsReportsResponse;
import kektor.innowise.trading.mapper.DtoMapper;
import kektor.innowise.trading.repository.TradeQuoteRepository;
import kektor.innowise.trading.service.ex.CompanyFinancialsNotFound;
import kektor.innowise.trading.service.ex.NoCompaniesForExchange;
import kektor.innowise.trading.service.ex.NoMetricsForSymbol;
import kektor.innowise.trading.service.ex.NoTradeQuoteForSymbol;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.Year;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FinnhubService {

    FinnhubClient finnhub;
    TradeQuoteRepository repo;
    DtoMapper mapper;

    public CompaniesInfoResponse getCompaniesInfo(String exchange) {
        return finnhub.getSymbols(exchange)
                .map(resp -> resp.stream()
                        .map(mapper::toCompanyInfoResponse)
                        .toList())
                .map(items -> CompaniesInfoResponse.builder()
                        .exchange(exchange)
                        .count(items.size())
                        .items(items)
                        .build())
                .orElseThrow(() -> new NoCompaniesForExchange(exchange));
    }

    public TradeQuoteResponse getTradeQuote(String symbol) {
        return finnhub.getQuote(symbol)
                .filter(resp -> resp.c().compareTo(BigDecimal.ZERO) != 0)
                .map(mapper::toTradeQuoteResponse)
                .orElseThrow(() -> new NoTradeQuoteForSymbol(symbol));
    }

    public Stock52WeekMetricsResponse getCompanyMetric(String symbol) {
        return finnhub.getMetric(symbol, "all")
                .filter(resp -> !Objects.isNull(resp.metric().week52High()))
                .map(mapper::toStock52WeekMetricsResponse)
                .orElseThrow(() -> new NoMetricsForSymbol(symbol));
    }

    @Transactional(readOnly = true)
    public TradeQuotesPeriodResponse getTradesForPeriod(String symbol, Instant from, Instant to) {
        List<TradeQuoteResponse> items = repo
                .findBySymbolAndQuoteTsBetweenOrderByQuoteTsAsc(symbol, from, to)
                .stream()
                .map(mapper::toTradeQuoteResponse)
                .toList();
        return TradeQuotesPeriodResponse.builder()
                .symbol(symbol)
                .from(from)
                .to(to)
                .items(items)
                .build();
    }

    public CompanyFinancialsReportResponse getCompanyFinancials(String symbol) {
        int currentYear = Year.now(ZoneOffset.UTC).minusYears(1).getValue();
        return finnhub.getFinancialsReported(symbol)
                .map(FinnhubFinancialsReportsResponse::reports)
                .flatMap(reports -> reports.stream()
                        .filter(report -> report.year() == currentYear)
                        .findFirst())
                .map(report -> mapper.toCompanyFinancialsReportResponse(report, symbol))
                .orElseThrow(() -> new CompanyFinancialsNotFound(symbol, currentYear));
    }

}
