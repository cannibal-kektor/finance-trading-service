CREATE TABLE trading.refresh_tokens
(
    id         bigserial PRIMARY KEY,
    token_hash varchar(64) NOT NULL,
    user_id    uuid        NOT NULL REFERENCES trading.users (id),
    expires_at timestamptz NOT NULL
);

CREATE UNIQUE INDEX unique_refresh_tokens_token_hash ON trading.refresh_tokens (token_hash);
CREATE INDEX index_refresh_tokens_user_id ON trading.refresh_tokens (user_id);
CREATE INDEX index_refresh_tokens_expires_at ON trading.refresh_tokens (expires_at);