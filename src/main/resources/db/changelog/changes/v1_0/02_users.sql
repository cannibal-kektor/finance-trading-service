CREATE TABLE trading.users
(
    id            uuid PRIMARY KEY,
    username      varchar(30)  NOT NULL UNIQUE,
    email         varchar(255) NOT NULL UNIQUE,
    password_hash varchar(255) NOT NULL,
    role          varchar(20)  NOT NULL,
    status        varchar(20)  NOT NULL,
    created_at    timestamptz  NOT NULL DEFAULT now(),

    CONSTRAINT valid_email CHECK (email ~* '^[a-z0-9._-]+@[a-z0-9.-]+\.[a-z]{2,}$'),
    CONSTRAINT valid_username CHECK (username ~* '^[a-z0-9_-]{3,30}$'),
    CONSTRAINT valid_status CHECK (status IN ('ACTIVE','BANNED','DELETED'))
);

CREATE INDEX index_users_username ON trading.users (username);
CREATE INDEX index_users_email ON trading.users (email);
CREATE INDEX index_users_status ON trading.users (status);