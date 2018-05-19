INSERT INTO `internet_store_db`.`user` ( name, lastname, email, password, birthdate, role) VALUES
  ("admin", "admin", "admin@admin.ru", "$2a$10$23pqbny5gsxIIae1aSi.1uzyDJViFnlpr.zYtBp8fRwdqHZFBc0Du", "1990-12-12","admin");


INSERT INTO `internet_store_db`.`category` (name) VALUES ("SSD");

INSERT INTO `internet_store_db`.`goods` (name, price, description, left_count, category_id)
    VALUES ("500 Gb SSD", 150, "500 Gb SSD", 15, (SELECT id FROM category WHERE category.name = "SSD"));


INSERT INTO `internet_store_db`.`goods` (name, price, description, left_count, category_id)
VALUES ("1000 Gb SSD", 350, "1000 Gb SSD", 15, (SELECT id FROM category WHERE category.name = "SSD"));