CREATE SCHEMA IF NOT EXISTS socialmedia DEFAULT CHARACTER SET utf8;
USE socialmedia;

CREATE TABLE usuario (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE posts (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    content TEXT,
    author VARCHAR(255),
    createDateTime DATETIME
);

CREATE TABLE comments (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    message VARCHAR(1000),
    author VARCHAR(255),
    createDateTime DATETIME
);
CREATE TABLE PaymentClient (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    valor DOUBLE,
    author VARCHAR(255),
    createDateTime DATETIME
);
CREATE TABLE payment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    valor DOUBLE,
    snCurrentValue VARCHAR(255),
    data LocalDateTime;
);
CREATE TABLE tb_email (
    emailId CHAR(36) PRIMARY KEY,
    ownerRef VARCHAR(255),
    emailFrom VARCHAR(255),
    emailTo VARCHAR(255),
    subject VARCHAR(255),
    text TEXT,
    sendDateEmail DATETIME,
    statusEmail VARCHAR(50)
);


