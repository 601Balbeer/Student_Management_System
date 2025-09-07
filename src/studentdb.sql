CREATE DATABASE StudentDB;
USE StudentDB;

CREATE TABLE Students (
    usn      VARCHAR(20) PRIMARY KEY,
    name     VARCHAR(100) NOT NULL,
    branch   VARCHAR(50) NOT NULL,
    semester INT NOT NULL
);
SELECT * FROM Students;


