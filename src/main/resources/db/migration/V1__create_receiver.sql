-- db/migration/V1__create_receiver

CREATE TABLE receiver (
  id                    BIGINT NOT NULL AUTO_INCREMENT,
  name                  VARCHAR(100) NOT NULL,
  email                 VARCHAR(255) NOT NULL,
  address               VARCHAR(100) NOT NULL,
  phone                 VARCHAR(15) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;