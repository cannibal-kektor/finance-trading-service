package kektor.innowise.trading.dto.trade.finnhub;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FinnhubFinancialsReportsResponse(
        String symbol,
        @JsonProperty("data")
        List<FinnhubFinancialsReportResponse> reports
) {
}
