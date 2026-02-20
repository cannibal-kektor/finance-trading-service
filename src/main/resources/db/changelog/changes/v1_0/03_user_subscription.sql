CREATE TABLE trading.user_subscription
(
    id        uuid PRIMARY KEY,
    user_id   uuid        NOT NULL UNIQUE REFERENCES trading.users (id),
    plan      varchar(20) NOT NULL,
    status    varchar(20) NOT NULL,
    starts_at timestamptz NOT NULL,
    ends_at   timestamptz NOT NULL,

    CONSTRAINT valid_subscription_plan CHECK (plan IN ('BASIC', 'STANDARD', 'PREMIUM')),
    CONSTRAINT valid_subscription_status CHECK (status IN ('ACTIVE', 'INACTIVE'))
);

CREATE INDEX index_user_subscription_user_id ON trading.user_subscription (user_id);
CREATE INDEX index_user_subscription_status ON trading.user_subscription (status);
CREATE INDEX index_user_subscription_ends_at ON trading.user_subscription (ends_at);