CREATE TABLE product_catalog
(
id BIGSERIAL PRIMARY KEY,
type VARCHAR(255),
name VARCHAR(255),
price DOUBLE PRECISION,
quantity BOOLEAN,
description TEXT
);