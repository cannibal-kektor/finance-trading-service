package kektor.innowise.trading.service.ex;

public class CompanyFinancialsNotFound extends RuntimeException {

    private static final String NOT_FOUND = "No company (%s) financials found for year: (%d)";

    public CompanyFinancialsNotFound(String symbol, Integer year) {
        super(NOT_FOUND.formatted(symbol, year));
    }

}
