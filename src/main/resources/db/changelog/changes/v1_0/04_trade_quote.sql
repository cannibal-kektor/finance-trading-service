CREATE TABLE trading.trade_quote
(
    id            bigserial PRIMARY KEY,
    symbol        varchar(20)    NOT NULL,
    quote_ts      timestamptz    NOT NULL,
    current_price numeric(19, 6) NOT NULL,
    open_price    numeric(19, 6),
    high_price    numeric(19, 6),
    low_price     numeric(19, 6),
    prev_close    numeric(19, 6)
);

CREATE UNIQUE INDEX unique_trade_quote_symbol_quote_ts ON trading.trade_quote (symbol, quote_ts);