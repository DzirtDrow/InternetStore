CREATE TABLE IF NOT EXISTS `internet_store_db`.`user` (
  `id`        INT AUTO_INCREMENT NOT NULL,
  `name`      VARCHAR(255)       NOT NULL,
  `lastname`  VARCHAR(255)       NULL,
  `email`     VARCHAR(255)       NOT NULL,
  `password`  VARCHAR(255)       NOT NULL,
  `birthdate` DATE               NULL,
  `role`      VARCHAR(255)       NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `internet_store_db`.`user_address`
(
  id          INT AUTO_INCREMENT
    PRIMARY KEY,
  user_id     INT          NOT NULL,
  address     VARCHAR(255) NULL,
  coordinates VARCHAR(255) NULL,
  CONSTRAINT user_address_user_id_uindex
  UNIQUE (user_id),
  CONSTRAINT user_address_user_id_fk
  FOREIGN KEY (user_id) REFERENCES user (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `internet_store_db`.`category`
(
  id   INT AUTO_INCREMENT
    PRIMARY KEY,
  name VARCHAR(64) NULL
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `internet_store_db`.`goods`
(
  id          INT AUTO_INCREMENT
    PRIMARY KEY,
  name        VARCHAR(64)  NOT NULL,
  price       INT          NULL,
  description VARCHAR(255) NULL,
  left_count  INT          NULL,
  category_id INT          NULL,
  CONSTRAINT goods_category_id_fk
  FOREIGN KEY (category_id) REFERENCES category (id)
)
  ENGINE = InnoDB;

CREATE INDEX goods_category_id_fk
  ON `internet_store_db`.`goods` (category_id);


CREATE TABLE IF NOT EXISTS `internet_store_db`.`order` (
  id         INT AUTO_INCREMENT NOT NULL,
  user_id    INT                NOT NULL,
  order_date DATE,
  sum        INT,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user (id)
)
  ENGINE = InnoDB;

ALTER TABLE `internet_store_db`.`order`
RENAME TO `internet_store_db`.`orders`;

CREATE TABLE IF NOT EXISTS `internet_store_db`.`cart`
(
  id      INT AUTO_INCREMENT
    PRIMARY KEY,
  sum     INT NULL,
  user_id INT NULL,
  CONSTRAINT cart_user_id_fk
  FOREIGN KEY (user_id) REFERENCES user (id)
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `internet_store_db`.`cart_item`
(
  id       INT AUTO_INCREMENT
    PRIMARY KEY,
  goods_id INT                              NULL,
  count    INT                              NULL,
  cart_id  INT                              NULL,
  order_id INT                              NULL,
  type     ENUM ('type_cart', 'type_order') NULL,
  CONSTRAINT cart_item_goods_id_fk
  FOREIGN KEY (goods_id) REFERENCES goods (id),
  CONSTRAINT cart_item_cart_id_fk
  FOREIGN KEY (cart_id) REFERENCES cart (id),
  CONSTRAINT cart_item_order_id_fk
  FOREIGN KEY (order_id) REFERENCES `order` (id)
)
  ENGINE = InnoDB;


CREATE INDEX cart_item_goods_id_fk
  ON `internet_store_db`.`cart_item` (goods_id);

CREATE INDEX cart_item_cart_id_fk
  ON `internet_store_db`.`cart_item` (cart_id);

CREATE INDEX cart_item_order_id_fk
  ON `internet_store_db`.`cart_item` (order_id);


CREATE INDEX cart_item_goods_id_fk
  ON `internet_store_db`.`cart_item` (goods_id);

CREATE INDEX cart_item_cart_id_fk
  ON `internet_store_db`.`cart_item` (cart_id);


CREATE INDEX cart_user_id_fk
  ON `internet_store_db`.`cart` (user_id);

CREATE TABLE IF NOT EXISTS `internet_store_db`.`persistent_logins`
(
  id        INT AUTO_INCREMENT
    PRIMARY KEY,
  username  VARCHAR(64) NOT NULL,
  token     VARCHAR(64) NOT NULL,
  last_used DATETIME    NULL,
  CONSTRAINT persistent_logins_username_uindex
  UNIQUE (username),
  CONSTRAINT persistent_logins_token_uindex
  UNIQUE (token)
)
  ENGINE = InnoDB;


ALTER TABLE `internet_store_db`.`orders`
  ADD status
  ENUM ('PROCESSING', 'PENDING_PAYMENT', 'PENDING_SHIPPING', 'SHIPPED', 'DELIVERED') DEFAULT 'PROCESSING' NOT NULL;


CREATE TABLE IF NOT EXISTS `internet_store_db`.`parameter`
(
  id          INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name        VARCHAR(64)     NOT NULL,
  description VARCHAR(255),
  param_type  ENUM ('param_num', 'param_string')
);
CREATE UNIQUE INDEX parameter_name_uindex
  ON `internet_store_db`.`parameter` (name);


CREATE TABLE IF NOT EXISTS `internet_store_db`.`category_parameter`
(
  category_id  INT NOT NULL,
  parameter_id INT NOT NULL,
  CONSTRAINT category_parameter_category_id_fk FOREIGN KEY (category_id) REFERENCES category (id),
  CONSTRAINT category_parameter_parameter_id_fk FOREIGN KEY (parameter_id) REFERENCES parameter (id)
);


CREATE TABLE IF NOT EXISTS `internet_store_db`.`goods_parameter`
(
  id           INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  num_value    INT,
  goods_id     INT             NULL,
  parameter_id INT             NULL,
  string_value VARCHAR(128)
);


ALTER TABLE `internet_store_db`.`goods_parameter`
  ADD CONSTRAINT goods_parameter_goods_id_fk
FOREIGN KEY (goods_id) REFERENCES goods (id);
ALTER TABLE `internet_store_db`.`goods_parameter`
  ADD CONSTRAINT goods_parameter_parameter_id_fk
FOREIGN KEY (parameter_id) REFERENCES parameter (id);


CREATE TABLE IF NOT EXISTS `internet_store_db`.`promotion`
(
  id          INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name        VARCHAR(255)    NOT NULL,
  description VARCHAR(255)    NULL
)
  ENGINE = InnoDB;

ALTER TABLE `internet_store_db`.`goods` ADD sales_count INT NULL;