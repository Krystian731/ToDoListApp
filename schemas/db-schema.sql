CREATE DATABASE todo
    CHARACTER SET = 'utf8'
    COLLATE = 'utf8_polish_ci';


use todo;


CREATE TABLE users
(
user_id INT(6) NOT NULL PRIMARY KEY,
username VARCHAR(30)
);

CREATE TABLE tasks
(
task_id INT(6) NOT NULL PRIMARY KEY,
user_id INT(6) NOT NULL,
task_text VARCHAR(80) NOT NULL,
task_completion BIT
);