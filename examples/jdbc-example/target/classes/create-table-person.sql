CREATE TABLE person(
    id SERIAL NOT NULL,
    first_name varchar(255),
    last_name varchar(255),
    city varchar(255),
    phone_number varchar(12),
    PRIMARY KEY(id)
);