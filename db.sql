CREATE SCHEMA IF NOT EXISTS payment DEFAULT CHARACTER SET utf8;
USE payment;

CREATE TABLE payment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    valor DOUBLE,
    payment_status enum('BEFORE', 'CURRENT')
    data LocalDateTime;
);


