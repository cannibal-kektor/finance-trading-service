package kektor.innowise.trading.client.ex;


import lombok.Getter;

@Getter
public sealed class FinnhubException extends RuntimeException
        permits FinnhubAuthException, FinnhubClientException, FinnhubServerException {

    private final FinnhubErrorContext context;

    protected FinnhubException(String message, FinnhubErrorContext context) {
        super(message);
        this.context = context;
    }

}
