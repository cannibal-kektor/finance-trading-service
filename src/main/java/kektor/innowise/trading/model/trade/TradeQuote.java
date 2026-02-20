package kektor.innowise.trading.model.trade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(schema = "trading", name = "trade_quote")
public class TradeQuote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "symbol", nullable = false, length = 20)
    String symbol;

    @Column(name = "quote_ts", nullable = false)
    Instant quoteTs;

    @Column(name = "current_price", nullable = false, precision = 19, scale = 6)
    BigDecimal currentPrice;

    @Column(name = "open_price", precision = 19, scale = 6)
    BigDecimal openPrice;

    @Column(name = "high_price", precision = 19, scale = 6)
    BigDecimal highPrice;

    @Column(name = "low_price", precision = 19, scale = 6)
    BigDecimal lowPrice;

    @Column(name = "prev_close", precision = 19, scale = 6)
    BigDecimal prevClose;

}
