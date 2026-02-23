package kektor.innowise.trading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FinanceTradingApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceTradingApplication.class, args);
    }

}
