package kektor.innowise.trading.dto.trade;

import java.time.Instant;
import java.util.List;

public record TradeQuotesPeriodResponse(
        String symbol,
        Instant from,
        Instant to,
        List<TradeQuoteResponse> items
) {
}
