package kektor.innowise.trading.client.ex;

import java.util.Collection;
import java.util.Map;

public record FinnhubErrorContext(
        String methodKey,
        int status,
        String httpMethod,
        Map<String, Collection<String>> requestHeaders,
        Map<String, Collection<String>> responseHeaders
) {
}
