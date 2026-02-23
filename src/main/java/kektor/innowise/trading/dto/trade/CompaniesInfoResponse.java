package kektor.innowise.trading.dto.trade;

import lombok.Builder;

import java.util.List;

@Builder
public record CompaniesInfoResponse(
        String exchange,
        int count,
        List<CompanyInfoResponse> items
) {
}
