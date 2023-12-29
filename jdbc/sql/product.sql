CREATE SEQUENCE hp_product_seq start with 10000;

CREATE TABLE product(
  product_id bigint NOT NULL DEFAULT nextval('hp_product_seq'),
  code varchar(50) DEFAULT NULL,
  name varchar(50) DEFAULT NULL,
  size int DEFAULT NULL,
  variety varchar(50) DEFAULT NULL,
  price numeric(10,2) DEFAULT NULL,
  status varchar(50) DEFAULT NULL,
  PRIMARY KEY (product_id)
);

ALTER SEQUENCE hp_product_seq OWNED BY product.product_id;

INSERT INTO product (product_id, code, name, size, variety, price, status)
VALUES
(1, 'MWBLU20', 'Mineral Water', 20, 'Blueberry', 1.79, 'ACTIVE'),
(2, 'MWBLU32', 'Mineral Water', 32, 'Blueberry', 3.69, 'ACTIVE'),
(3, 'MWCRA20', 'Mineral Water', 20, 'Cranberry', 1.79, 'DISCONTINUED')

-- 16