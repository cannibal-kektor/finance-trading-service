package kektor.innowise.trading.dto.trade;

import java.util.List;

public record FinancialsCurrentYearResponse(
        String symbol,
        int year,
        List<FinancialReportResponse> reports
) {
}
