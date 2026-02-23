package kektor.innowise.trading.client.conf;


import feign.RequestInterceptor;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class FinnhubFeignConfig {

    @Bean
    public RequestInterceptor finnhubTokenInterceptor(@Value("${finnhub.token}") String token) {
        return template -> template.query("token", token);
    }

    @Bean
    public ErrorDecoder finnhubErrorDecoder() {
        return new FinnhubErrorDecoder();
    }

    @Bean
    public Retryer finnhubRetryer() {
        return new Retryer.Default(400, 400, 2);
    }
}
