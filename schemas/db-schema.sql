CREATE DATABASE todo
    CHARACTER SET = 'utf8'
    COLLATE = 'utf8_polish_ci';
    
    
use todo;

CREATE TABLE string
(
string_id INT(6) NOT NULL PRIMARY KEY,
string_text CHAR(20) NOT NULL
);