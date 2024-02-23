CREATE TABLE IF NOT EXISTS REGISTRATION (
    id BIGINT not null,
    registration_date DATE,
    amount INTEGER,
    member_type VARCHAR(10),
    PRIMARY KEY (id)

);
CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 1;