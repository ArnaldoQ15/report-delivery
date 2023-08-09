-- db/migration/V2__create_delivery

CREATE TABLE delivery (
  id                    BIGINT NOT NULL AUTO_INCREMENT,
  id_receiver           BIGINT NOT NULL,
  status                VARCHAR(20) NOT NULL,
  product               VARCHAR(100) NOT NULL,
  quantity              INT NOT NULL,
  unit_price            DECIMAL(10, 2) NOT NULL,
  total_price           DECIMAL(10, 2) NOT NULL,
  delivery_fee          DECIMAL(10, 2) NOT NULL,
  weight                DECIMAL(10, 2) NOT NULL,
  delivery_date         DATE NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_delivery_01 FOREIGN KEY (id_receiver) REFERENCES receiver (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;