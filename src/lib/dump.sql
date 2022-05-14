/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */

/**
 * 
 * Created: 14 de mai de 2022
 */

CREATE TABLE contact(
    id        INTEGER PRIMARY KEY AUTOINCREMENT,
    name      VARCHAR(40),
    email     VARCHAR(40),
    address   VARCHAR(40),
    birthDate DATE
);

INSERT INTO 
    contact(name, email, address, birthDate) 
VALUES 
    ("test1", "test1@test.com", "street 1", "1652560645659"),
    ("test2", "test2@test.com", "street 2", "1652560645659"),
    ("test3", "test3@test.com", "street 3", "1652560645659"),
    ("test4", "test4@test.com", "street 4", "1652560645659");