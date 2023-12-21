CREATE TABLE IF NOT EXISTS car
(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(55) NOT NULL,
    year_of_production INTEGER NOT NULL,
    number_plate VARCHAR(9) NOT NULL,
    color VARCHAR(16) NOT NULL,
    rental_price DECIMAL(8, 2) NOT NULL,
    location_id BIGINT REFERENCES location(id) ON DELETE CASCADE
);
