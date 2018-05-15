CREATE TABLE IF NOT EXISTS `internet_store_db`.`user` (
  `id` INT AUTO_INCREMENT NOT NULL ,
  `name` VARCHAR(255) NOT NULL,
  `lastname` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `birthdate` DATE NOT NULL,
  `role` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC)
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `internet_store_db`.`goods` (
  `id` INT AUTO_INCREMENT NOT NULL ,
  `name` VARCHAR(64) NOT NULL,
  `price` INT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS internet_store_db.order (
  id INT AUTO_INCREMENT NOT NULL ,
  user_id INT NOT NULL,
  order_date date ,
  sum INT,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user(id)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS internet_store_db.cart (
  id INT AUTO_INCREMENT NOT NULL ,
  goods_id INT NOT NULL ,
  order_id INT NOT NULL ,
  count INT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (goods_id) REFERENCES goods(id),
  FOREIGN KEY (order_id) REFERENCES internet_store_db.order (id)
)
  ENGINE = InnoDB;






