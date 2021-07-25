CREATE DATABASE todo
    CHARACTER SET = 'utf8'
    COLLATE = 'utf8_polish_ci';


use todo;


CREATE TABLE "user"
(
user_id INT(6) NOT NULL PRIMARY KEY,
username CHAR(25)
);

CREATE TABLE tasks
(
task_id INT(6) NOT NULL PRIMARY KEY,
user_id INT(6) NOT NULL,
task_text CHAR(80) NOT NULL,
task_completion BIT
);