package kektor.innowise.trading.dto.trade;

import java.util.List;

public record CompaniesResponse(
        String exchange,
        int count,
        List<CompanyResponse> items
) {
}
