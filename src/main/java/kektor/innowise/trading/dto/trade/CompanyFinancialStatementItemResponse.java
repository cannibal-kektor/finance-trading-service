package kektor.innowise.trading.dto.trade;

import java.math.BigDecimal;

public record CompanyFinancialStatementItemResponse(
        String concept,
        String label,
        String unit,
        BigDecimal value
) {
}
