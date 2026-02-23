package kektor.innowise.trading.dto.trade.finnhub;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FinnhubFinancialStatementsResponse(
        @JsonProperty("ic")
        List<FinnhubFinancialStatementItemResponse> incomeStatement,
        @JsonProperty("bs")
        List<FinnhubFinancialStatementItemResponse> balanceSheet,
        @JsonProperty("cf")
        List<FinnhubFinancialStatementItemResponse> cashFlow
) {
}
