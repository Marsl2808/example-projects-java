CREATE SEQUENCE hp_salesperson_seq start with 10000;

CREATE TABLE salesperson(
  salesperson_id bigint NOT NULL DEFAULT nextval('hp_salesperson_seq'),
  first_name varchar(50) DEFAULT NULL,
  last_name varchar(50) DEFAULT NULL,
  email varchar(50) DEFAULT NULL,
  phone varchar(50) DEFAULT NULL,
  address varchar(50) DEFAULT NULL,
  city varchar(50) DEFAULT NULL,
  state varchar(50) DEFAULT NULL,
  zipcode varchar(50) DEFAULT NULL,
  PRIMARY KEY (salesperson_id)
);

ALTER SEQUENCE hp_salesperson_seq OWNED BY salesperson.salesperson_id;

INSERT INTO salesperson (salesperson_id, first_name, last_name, email, phone, address, city, state, zipcode)
VALUES
(100, 'Jack', 'Powell', 'jpowell@hplussport.com', '(434)951-5046', '5 Jennifer Crossing', 'Lynchburg', 'Virginia', '24515'),
(101, 'Emily', 'Garcia', 'egarcia@hplussport.com', '(603)489-3196', '97 Vidon Alley', 'Manchester', 'New Hampshire', '3105')

-- 50