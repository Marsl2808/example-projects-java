CREATE SEQUENCE hp_order_seq start with 10000;
CREATE SEQUENCE hp_orderline_seq start with 10000;

CREATE TABLE orders(
  order_id bigint NOT NULL DEFAULT nextval('hp_order_seq'),
  creation_date timestamp DEFAULT NULL,
  total_due numeric(10,2) DEFAULT NULL,
  status varchar(50) DEFAULT NULL,
  customer_id bigint NOT NULL,
  salesperson_id bigint NOT NULL,
  PRIMARY KEY (order_id),
  FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
  FOREIGN KEY (salesperson_id) REFERENCES salesperson(salesperson_id)
);

CREATE TABLE order_item(
  order_item_id bigint NOT NULL DEFAULT nextval('hp_orderline_seq'),
  order_id bigint NOT NULL,
  product_id bigint NOT NULL,
  quantity int DEFAULT NULL,
  PRIMARY KEY (order_item_id),
  FOREIGN KEY (order_id) REFERENCES orders(order_id),
  FOREIGN KEY (product_id) REFERENCES product(product_id)
);

ALTER SEQUENCE hp_order_seq OWNED BY orders.order_id;
ALTER SEQUENCE hp_orderline_seq OWNED BY order_item.order_item_id;

INSERT INTO orders (order_id, creation_date, total_due, status, customer_id, salesperson_id)
VALUES
(1000, '2016-05-14 00:00:00', 118.22, 'paid', 100, 100),
(1001, '2016-07-31 00:00:00', 211.22, 'returned', 101, 101);

INSERT INTO order_item (order_item_id, order_id, product_id, quantity)
VALUES
(1000, 1000, 1, 46),
(1001, 1001, 2, 31);
