CREATE TABLE MEMBER (
    id BIGINT not null,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    username VARCHAR(50),
    email VARCHAR(50),
    password VARCHAR(50),
    member_type VARCHAR(10),
    PRIMARY KEY (id)

);
CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 1;