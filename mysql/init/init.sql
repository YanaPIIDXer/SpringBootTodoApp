CREATE DATABASE todo_app CHARACTER SET utf8;
GRANT ALL ON todo_app.* TO develop@'%' IDENTIFIED BY 'develop';

CREATE TABLE users(id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, name VARCHAR(64) NOT NULL UNIQUE, password VARCHAR(64));
CREATE TABLE todos(id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, user_id INT, title VARCHAR(64) NOT NULL, body TEXT NOT NULL, priority INT);
