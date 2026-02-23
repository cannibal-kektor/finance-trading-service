package kektor.innowise.trading.service.ex;

public class NoTradeQuoteForSymbol extends RuntimeException {

    private static final String NOT_FOUND = "No trade quote for symbol: ( %s ) ";

    public NoTradeQuoteForSymbol(String symbol) {
        super(NOT_FOUND.formatted(symbol));
    }

}
