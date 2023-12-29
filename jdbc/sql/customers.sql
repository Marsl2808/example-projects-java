CREATE SEQUENCE hp_customer_seq start with 10000;

CREATE TABLE customer(
  customer_id bigint NOT NULL DEFAULT nextval('hp_customer_seq'),
  first_name varchar(50) DEFAULT NULL,
  last_name varchar(50) DEFAULT NULL,
  email varchar(50) DEFAULT NULL,
  phone varchar(50) DEFAULT NULL,
  address varchar(50) DEFAULT NULL,
  city varchar(50) DEFAULT NULL,
  state varchar(50) DEFAULT NULL,
  zipcode varchar(50) DEFAULT NULL,
  PRIMARY KEY (customer_id)
);

ALTER SEQUENCE hp_customer_seq OWNED BY customer.customer_id;

INSERT INTO customer (customer_id, first_name, last_name, email, phone, address, city, state, zipcode)
VALUES
(100, 'Carol', 'Shaw', 'cshaw@mlb.com', '(206)804-8771', '8157 Longview Court', 'Seattle', 'WA', '98121'),
(101, 'Elizabeth', 'Carr', 'ecarr@oracle.com', '(512)187-2507', '3934 Petterle Trail', 'Austin', 'TX', '78732'),
(102, 'Ernest', 'Ramos', 'eramos2@plataor.jp', '(816)540-4257', '8699 Clarendon Terrace', 'Kansas City', 'MO', '64199')

-- 1000
