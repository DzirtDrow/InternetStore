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

create table  IF NOT EXISTS `internet_store_db`.`user_address`
(
  id int auto_increment
    primary key,
  user_id int not null,
  address varchar(255) null,
  coordinates varchar(255) null,
  constraint user_address_user_id_uindex
  unique (user_id),
  constraint user_address_user_id_fk
  foreign key (user_id) references user (id)
    on update cascade on delete cascade
)
  engine=InnoDB
;

create table IF NOT EXISTS `internet_store_db`.`goods`
(
  id int auto_increment
    primary key,
  name varchar(64) not null,
  price int null,
  description varchar(255) null,
  left_count int null,
  category_id int null,
  constraint goods_category_id_fk
  foreign key (category_id) references category (id)
)
  engine=InnoDB
;

create index  goods_category_id_fk
  on goods (category_id)
;

create table if NOT EXISTS `internet_store_db`.`category`
(
  id int auto_increment
    primary key,
  name varchar(64) null
)
  engine=InnoDB
;



CREATE TABLE IF NOT EXISTS `internet_store_db`.`order` (
  id INT AUTO_INCREMENT NOT NULL ,
  user_id INT NOT NULL,
  order_date date ,
  sum INT,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user(id)
)
  ENGINE = InnoDB;

create table IF NOT EXISTS `internet_store_db`.`cart_item`
(
  id int auto_increment
    primary key,
  goods_id int null,
  count int null,
  cart_id int null,
  order_id int null,
  type enum('type_cart', 'type_order') null,
  constraint cart_item_goods_id_fk
  foreign key (goods_id) references goods (id),
  constraint cart_item_cart_id_fk
  foreign key (cart_id) references cart (id),
  constraint cart_item_order_id_fk
  foreign key (order_id) references `order` (id)
)
  engine=InnoDB
;


create index cart_item_goods_id_fk
  on cart_item (goods_id)
;

create index cart_item_cart_id_fk
  on cart_item (cart_id)
;

create index cart_item_order_id_fk
  on cart_item (order_id)
;



create index cart_item_goods_id_fk
  on cart_item (goods_id)
;

create index cart_item_cart_id_fk
  on cart_item (cart_id)
;


create table IF NOT EXISTS `internet_store_db`.`cart`
(
  id int auto_increment
    primary key,
  sum int null,
  user_id int null,
  constraint cart_user_id_fk
  foreign key (user_id) references user (id)
)
  engine=InnoDB
;

create index cart_user_id_fk
  on cart (user_id)
;

create table IF NOT EXISTS `internet_store_db`.`persistent_logins`
(
  id int auto_increment
    primary key,
  username varchar(64) not null,
  token varchar(64) not null,
  last_used datetime null,
  constraint persistent_logins_username_uindex
  unique (username),
  constraint persistent_logins_token_uindex
  unique (token)
)
  engine=InnoDB
;








