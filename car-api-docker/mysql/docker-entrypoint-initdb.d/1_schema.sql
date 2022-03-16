-- CREATE TABLE test (
-- 	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT
-- );
CREATE DATABASE IF NOT EXISTS cars_db;
USE cars_db;
DROP TABLE IF EXISTS car CASCADE;
CREATE TABLE IF NOT EXISTS car (
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	year INT NOT NULL,
	make VARCHAR(50) NULL,
	model VARCHAR(50) NOT NULL
    );