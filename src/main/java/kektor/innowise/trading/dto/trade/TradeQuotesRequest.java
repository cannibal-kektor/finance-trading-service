package kektor.innowise.trading.dto.trade;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.Instant;

public record TradeQuotesRequest(
        @Pattern(regexp = "^[A-Z0-9.\\-]{1,20}$")
        String symbol,
        @NotNull
        Instant from,
        @NotNull
        Instant to
) {
}
