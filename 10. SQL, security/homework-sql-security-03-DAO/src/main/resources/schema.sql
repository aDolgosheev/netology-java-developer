create schema if not exists dolgosheev;

create table if not exists dolgosheev.customers (
                                         id serial primary key,
                                         name varchar(255),
                                         surname varchar(255),
                                         age int,
                                         phone_number varchar(20)
);

create table if not exists dolgosheev.orders (
                                      id serial primary key,
                                      date timestamp not null default now(),
                                      customer_id int references dolgosheev.customers (id),
                                      product_name varchar(255),
                                      amount int
);