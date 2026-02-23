package kektor.innowise.trading.client.conf;

import feign.Response;
import feign.codec.ErrorDecoder;
import kektor.innowise.trading.client.ex.FinnhubAuthException;
import kektor.innowise.trading.client.ex.FinnhubClientException;
import kektor.innowise.trading.client.ex.FinnhubErrorContext;
import kektor.innowise.trading.client.ex.FinnhubServerException;

public class FinnhubErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        var errorContext = buildContext(methodKey, response);
        Integer status = response.status();
        return switch (status) {
            case 401, 403 -> new FinnhubAuthException(errorContext);
            case Integer _ when status >= 400 && status < 500 -> new FinnhubClientException(errorContext);
            case Integer _ when status >= 500 -> new FinnhubServerException(errorContext);
            default -> defaultDecoder.decode(methodKey, response);
        };
    }

    private FinnhubErrorContext buildContext(String methodKey, Response resp) {
        var req = resp.request();
        return new FinnhubErrorContext(
                methodKey,
                resp.status(),
                req.httpMethod().name(),
                req.headers(),
                resp.headers()
        );
    }

}
