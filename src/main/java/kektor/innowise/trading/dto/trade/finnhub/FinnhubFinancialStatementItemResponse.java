package kektor.innowise.trading.dto.trade.finnhub;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FinnhubFinancialStatementItemResponse(
        String concept,
        String label,
        String unit,
        BigDecimal value
) {
}
