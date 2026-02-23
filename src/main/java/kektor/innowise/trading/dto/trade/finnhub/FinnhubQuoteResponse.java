package kektor.innowise.trading.dto.trade.finnhub;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FinnhubQuoteResponse(
        BigDecimal c,
        BigDecimal h,
        BigDecimal l,
        BigDecimal o,
        BigDecimal pc,
        long t
) {
}
