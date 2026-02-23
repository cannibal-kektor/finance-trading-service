package kektor.innowise.trading.client.ex;

public final class FinnhubClientException extends FinnhubException {

    private static final String DEFAULT_CLIENT_ERROR_MESSAGE = "Finnhub client error (%d) for %s";

    public FinnhubClientException(FinnhubErrorContext context) {
        super(DEFAULT_CLIENT_ERROR_MESSAGE.formatted(context.status(), context.methodKey()), context);
    }

}
