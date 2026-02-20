package kektor.innowise.trading.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RefreshRequest(
        @NotBlank
        @Size(min = 16, max = 36)
        String refreshToken
) {
}