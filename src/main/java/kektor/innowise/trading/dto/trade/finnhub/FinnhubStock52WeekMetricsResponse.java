package kektor.innowise.trading.dto.trade.finnhub;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FinnhubStock52WeekMetricsResponse(
        @JsonProperty("52WeekHigh")
        BigDecimal week52High,
        @JsonProperty("52WeekHighDate")
        LocalDate week52HighDate,
        @JsonProperty("52WeekLow")
        BigDecimal week52Low,
        @JsonProperty("52WeekLowDate")
        LocalDate week52LowDate,
        @JsonProperty("52WeekPriceReturnDaily")
        BigDecimal week52PriceReturnDaily
) {
}
