package kektor.innowise.trading.dto.trade.finnhub;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FinnhubStockSymbolResponse(
        String symbol,
        String currency,
        String description,
        String displaySymbol,
        String figi,
        String isin,
        String mic,
        String shareClassFIGI,
        String symbol2,
        String type
) {
}
