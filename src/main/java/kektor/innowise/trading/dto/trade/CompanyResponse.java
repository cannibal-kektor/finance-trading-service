package kektor.innowise.trading.dto.trade;

public record CompanyResponse(
        String symbol,
        String name,
        String currency,
        String mic,
        String type
) {
}
