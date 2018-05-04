CREATE TABLE IF NOT EXISTS `internet_store_db`.`user` (
  `id` INT AUTO_INCREMENT NOT NULL ,
  `name` VARCHAR(255) NOT NULL,
  `lastname` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `birtdate` DATE NOT NULL,
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
