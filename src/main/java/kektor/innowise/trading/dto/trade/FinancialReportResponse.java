package kektor.innowise.trading.dto.trade;

import java.time.LocalDate;

public record FinancialReportResponse(
        int year,
        Integer quarter,
        String form,
        LocalDate startDate,
        LocalDate endDate,
        LocalDate filedDate,
        FinancialStatementsResponse statements
) {
}
