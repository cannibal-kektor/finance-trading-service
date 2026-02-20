package kektor.innowise.trading.dto.trade;

import java.util.List;

public record FinancialStatementsResponse(

        List<FinancialStatementItemResponse> incomeStatement,

        List<FinancialStatementItemResponse> balanceSheet,

        List<FinancialStatementItemResponse> cashFlow

) {
}
