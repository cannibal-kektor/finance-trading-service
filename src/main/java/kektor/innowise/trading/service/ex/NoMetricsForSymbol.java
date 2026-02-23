package kektor.innowise.trading.service.ex;

public class NoMetricsForSymbol extends RuntimeException {

    private static final String NOT_FOUND = "No metrics found for symbol: ( %s ) " ;

    public NoMetricsForSymbol(String symbol) {
        super(NOT_FOUND.formatted(symbol));
    }

}
