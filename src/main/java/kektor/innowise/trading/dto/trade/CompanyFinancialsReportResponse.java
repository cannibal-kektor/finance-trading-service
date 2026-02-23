package kektor.innowise.trading.dto.trade;

import java.time.LocalDateTime;

public record CompanyFinancialsReportResponse(
        String symbol,
        Integer year,
        Integer quarter,
        String form,
        LocalDateTime startDate,
        LocalDateTime endDate,
        LocalDateTime filedDate,
        LocalDateTime acceptedDate,
        CompanyFinancialStatementsResponse statements
) {
}
