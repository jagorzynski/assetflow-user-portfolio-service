CREATE SEQUENCE user_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE users (
    user_id BIGINT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    birthday TIMESTAMP
);

CREATE SEQUENCE portfolio_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE portfolios (
    portfolio_id BIGINT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    asset_type VARCHAR(255) NOT NULL,
    asset_name VARCHAR(255) NOT NULL,
    currency VARCHAR(255) NOT NULL,
    quantity NUMERIC NOT NULL,
    purchase_price NUMERIC NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE INDEX idx_user_id ON portfolios(user_id);
