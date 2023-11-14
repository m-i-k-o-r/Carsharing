CREATE TABLE IF NOT EXISTS history
(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    client_id BIGINT REFERENCES client(id) ON DELETE CASCADE NOT NULL,
    car_id BIGINT REFERENCES car(id) ON DELETE CASCADE NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP
);