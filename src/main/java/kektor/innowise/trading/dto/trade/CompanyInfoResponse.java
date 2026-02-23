package kektor.innowise.trading.dto.trade;

public record CompanyInfoResponse(
        String name,
        String symbol,
        String currency,
        String mic,
        String type
) {
}
