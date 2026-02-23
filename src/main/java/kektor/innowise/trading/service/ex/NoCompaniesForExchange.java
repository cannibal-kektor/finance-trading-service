package kektor.innowise.trading.service.ex;

public class NoCompaniesForExchange extends RuntimeException {

    private static final String NOT_FOUND = "No companies found for exchange: %s";

    public NoCompaniesForExchange(String symbol) {
        super(NOT_FOUND.formatted(symbol));
    }

}
