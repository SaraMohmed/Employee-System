DROP DATABASE IF EXISTS employees;
CREATE DATABASE employees;
USE employees;
CREATE TABLE employee
(
   id INT(15) PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(256),
   gender BOOLEAN,
   birth_date DATE,
   salary REAL
);

