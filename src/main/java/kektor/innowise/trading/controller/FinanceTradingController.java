package kektor.innowise.trading.controller;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import kektor.innowise.trading.dto.trade.CompaniesInfoResponse;
import kektor.innowise.trading.dto.trade.CompanyFinancialsReportResponse;
import kektor.innowise.trading.dto.trade.Stock52WeekMetricsResponse;
import kektor.innowise.trading.dto.trade.TradeQuoteResponse;
import kektor.innowise.trading.dto.trade.TradeQuotesPeriodResponse;
import kektor.innowise.trading.service.FinnhubService;
import kektor.innowise.trading.validation.ValidTradeRange;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@Validated
@RestController
@RequestMapping("/api/market")
@RequiredArgsConstructor
public class FinanceTradingController {

    private final FinnhubService finnhubService;

    @GetMapping("/companies")
    public ResponseEntity<CompaniesInfoResponse> getCompanies(@RequestParam(defaultValue = "US") String exchange) {
        return ResponseEntity.ok()
                .body(finnhubService.getCompaniesInfo(exchange));
    }

    @GetMapping("/quote/{symbol}")
    public ResponseEntity<TradeQuoteResponse> getTradeQuote(@PathVariable String symbol) {
        return ResponseEntity.ok()
                .body(finnhubService.getTradeQuote(symbol));
    }

    @GetMapping("/metrics/52w/{symbol}")
    public ResponseEntity<Stock52WeekMetricsResponse> get52w(@PathVariable String symbol) {
        return ResponseEntity.ok()
                .body(finnhubService.getCompanyMetric(symbol));
    }

    @GetMapping("/trades/{symbol}")
    @ValidTradeRange(fromIndex = 1, toIndex = 2, maxDays = 31)
    public ResponseEntity<TradeQuotesPeriodResponse> getTradesQuotesForPeriod(
            @PathVariable @Pattern(regexp = "^[A-Z0-9.\\-]{1,20}$") String symbol,
            @RequestParam @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant from,
            @RequestParam @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant to) {
        return ResponseEntity.ok()
                .body(finnhubService.getTradesForPeriod(symbol, from, to));
    }

    @GetMapping("/financials/{symbol}")
    public ResponseEntity<CompanyFinancialsReportResponse> getFinancialsCurrentYear(@PathVariable String symbol) {
        return ResponseEntity.ok()
                .body(finnhubService.getCompanyFinancials(symbol));
    }

}
