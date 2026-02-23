package kektor.innowise.trading.dto.trade;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.Instant;

public record TradeQuoteResponse(
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        Instant quoteTs,
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        Instant formattedTs,
        BigDecimal currentPrice,
        BigDecimal openPrice,
        BigDecimal highPrice,
        BigDecimal lowPrice,
        BigDecimal prevClose
) {
}
