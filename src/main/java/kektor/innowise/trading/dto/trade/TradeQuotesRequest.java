package kektor.innowise.trading.dto.trade;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;

public record TradeQuotesRequest(
        @Pattern(regexp = "^[A-Z0-9.\\-]{1,20}$")
        String symbol,
        @NotNull
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        Instant from,
        @NotNull
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        Instant to
) {
}
