package kektor.innowise.trading.client.ex;

public final class FinnhubAuthException extends FinnhubException {

    private static final String DEFAULT_AUTH_ERROR_MESSAGE = "Finnhub auth error (%d) for %s";

    public FinnhubAuthException(FinnhubErrorContext context) {
        super(DEFAULT_AUTH_ERROR_MESSAGE.formatted(context.status(), context.methodKey()), context);
    }

}
