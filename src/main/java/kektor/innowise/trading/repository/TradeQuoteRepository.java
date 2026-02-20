package kektor.innowise.trading.repository;

import kektor.innowise.trading.model.trade.TradeQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeQuoteRepository extends JpaRepository<TradeQuote, Long> {
}
