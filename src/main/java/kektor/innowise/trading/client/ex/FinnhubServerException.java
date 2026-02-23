package kektor.innowise.trading.client.ex;

public final class FinnhubServerException extends FinnhubException {

    private static final String DEFAULT_SERVER_ERROR_MESSAGE = "Finnhub server error (%d) for %s";

    public FinnhubServerException(FinnhubErrorContext context) {
        super(DEFAULT_SERVER_ERROR_MESSAGE.formatted(context.status(), context.methodKey()), context);
    }
}
