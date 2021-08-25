CREATE DATABASE todo
    CHARACTER SET = 'utf8'
    COLLATE = 'utf8_polish_ci';

use todo;


CREATE TABLE users
(
user_id INT(6) NOT NULL AUTO_INCREMENT,
username VARCHAR(30),
CONSTRAINT user_id_primary_key PRIMARY KEY (user_id)
);

CREATE TABLE tasks
(
task_id INT(6) NOT NULL AUTO_INCREMENT,
user_id INT(6) NOT NULL,
task_text VARCHAR(80) NOT NULL,
task_date DATETIME,
task_completion_date DATETIME NULL DEFAULT NULL,
CONSTRAINT task_id_primary_key PRIMARY KEY (task_id),
CONSTRAINT task_id_foreign_key FOREIGN KEY (user_id) REFERENCES users(user_id)
);