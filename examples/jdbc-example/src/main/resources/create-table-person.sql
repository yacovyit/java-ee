CREATE TABLE public.person (
    id int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    first_name varchar(255),
    last_name varchar(255),
    city varchar(255),
    phone_number varchar(12)
);