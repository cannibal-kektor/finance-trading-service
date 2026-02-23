package kektor.innowise.trading.dto.trade;

import lombok.Builder;

import java.time.Instant;
import java.util.List;

@Builder
public record TradeQuotesPeriodResponse(
        String symbol,
        Instant from,
        Instant to,
        List<TradeQuoteResponse> items
) {
}
