package kektor.innowise.trading.mapper;

import kektor.innowise.trading.dto.trade.CompanyFinancialStatementItemResponse;
import kektor.innowise.trading.dto.trade.CompanyFinancialStatementsResponse;
import kektor.innowise.trading.dto.trade.CompanyFinancialsReportResponse;
import kektor.innowise.trading.dto.trade.CompanyInfoResponse;
import kektor.innowise.trading.dto.trade.Stock52WeekMetricsResponse;
import kektor.innowise.trading.dto.trade.TradeQuoteResponse;
import kektor.innowise.trading.dto.trade.finnhub.FinnhubFinancialStatementItemResponse;
import kektor.innowise.trading.dto.trade.finnhub.FinnhubFinancialStatementsResponse;
import kektor.innowise.trading.dto.trade.finnhub.FinnhubFinancialsReportResponse;
import kektor.innowise.trading.dto.trade.finnhub.FinnhubMetricResponse;
import kektor.innowise.trading.dto.trade.finnhub.FinnhubQuoteResponse;
import kektor.innowise.trading.dto.trade.finnhub.FinnhubStockSymbolResponse;
import kektor.innowise.trading.model.trade.TradeQuote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;

@Mapper(config = MapConfig.class)
public interface DtoMapper {

    @Mapping(target = "name", source = "description")
    CompanyInfoResponse toCompanyInfoResponse(FinnhubStockSymbolResponse finnhubStockSymbolResponse);

    @Mapping(target = ".", source = "finnhubMetricResponse.metric")
    Stock52WeekMetricsResponse toStock52WeekMetricsResponse(FinnhubMetricResponse finnhubMetricResponse);

    @Mapping(target = "currentPrice", source = "c")
    @Mapping(target = "openPrice", source = "o")
    @Mapping(target = "highPrice", source = "h")
    @Mapping(target = "lowPrice", source = "l")
    @Mapping(target = "prevClose", source = "pc")
    @Mapping(target = "quoteTs", source = "t")
    @Mapping(target = "formattedTs", source = "t")
    TradeQuoteResponse toTradeQuoteResponse(FinnhubQuoteResponse quote);

    @Mapping(target = "formattedTs", source = "quoteTs")
    TradeQuoteResponse toTradeQuoteResponse(TradeQuote tradeQuote);

    @Mapping(target = "symbol", source = "symbol")
    CompanyFinancialsReportResponse toCompanyFinancialsReportResponse(FinnhubFinancialsReportResponse report, String symbol);

    CompanyFinancialStatementItemResponse toCompanyFinancialStatementItemResponse(FinnhubFinancialStatementItemResponse reportItem);

    CompanyFinancialStatementsResponse toCompanyFinancialStatementsResponse(FinnhubFinancialStatementsResponse finnhubFinancialStatementsResponse);

    default Instant toInstant(long epochSeconds) {
        return Instant.ofEpochSecond(epochSeconds);
    }
}