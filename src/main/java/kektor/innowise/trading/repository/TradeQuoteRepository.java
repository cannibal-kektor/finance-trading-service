package kektor.innowise.trading.repository;

import kektor.innowise.trading.model.trade.TradeQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface TradeQuoteRepository extends JpaRepository<TradeQuote, Long> {
    List<TradeQuote> findBySymbolAndQuoteTsBetweenOrderByQuoteTsAsc(String symbol, Instant from, Instant to);
}
