package kektor.innowise.trading.dto.auth;


public record TokenResponse(
        String accessToken,
        String refreshToken
) {
}
