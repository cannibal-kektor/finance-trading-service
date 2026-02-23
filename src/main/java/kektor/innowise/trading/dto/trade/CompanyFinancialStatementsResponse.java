package kektor.innowise.trading.dto.trade;

import java.util.List;

public record CompanyFinancialStatementsResponse(

        List<CompanyFinancialStatementItemResponse> incomeStatement,

        List<CompanyFinancialStatementItemResponse> balanceSheet,

        List<CompanyFinancialStatementItemResponse> cashFlow

) {
}
