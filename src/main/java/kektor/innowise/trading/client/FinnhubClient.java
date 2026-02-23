package kektor.innowise.trading.client;

import kektor.innowise.trading.client.conf.FinnhubFeignConfig;
import kektor.innowise.trading.dto.trade.finnhub.FinnhubFinancialsReportsResponse;
import kektor.innowise.trading.dto.trade.finnhub.FinnhubMetricResponse;
import kektor.innowise.trading.dto.trade.finnhub.FinnhubQuoteResponse;
import kektor.innowise.trading.dto.trade.finnhub.FinnhubStockSymbolResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient(
        name = "finnhubClient",
        url = "${finnhub.base-url}",
        configuration = FinnhubFeignConfig.class
)
public interface FinnhubClient {

    @GetMapping("/stock/symbol")
    Optional<List<FinnhubStockSymbolResponse>> getSymbols(@RequestParam("exchange") String exchange);

    @GetMapping("/quote")
    Optional<FinnhubQuoteResponse> getQuote(@RequestParam("symbol") String symbol);

    @GetMapping("/stock/metric")
    Optional<FinnhubMetricResponse> getMetric(@RequestParam("symbol") String symbol,
                                              @RequestParam("metric") String metric);

    @GetMapping("/stock/financials-reported")
    Optional<FinnhubFinancialsReportsResponse> getFinancialsReported(@RequestParam("symbol") String symbol);

}
