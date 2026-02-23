package kektor.innowise.trading.dto.trade.finnhub;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FinnhubMetricResponse(
        String symbol,
        FinnhubStock52WeekMetricsResponse metric
) {
}
