package kektor.innowise.trading.dto.trade;

import java.math.BigDecimal;
import java.time.Instant;

public record TradeQuoteResponse(
        Instant quoteTs,
        BigDecimal currentPrice,
        BigDecimal openPrice,
        BigDecimal highPrice,
        BigDecimal lowPrice,
        BigDecimal prevClose
) {
}
