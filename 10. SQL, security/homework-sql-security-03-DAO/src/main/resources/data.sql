insert into dolgosheev.customers(name, surname, age, phone_number)
values ('Aleksandr', 'Dolgosheev', 34, '+79045555555'),
       ('Pavel', 'Petrov', 35, '+79216668877'),
       ('Alex', 'Brown', 27, '+14568978965'),
       ('Kristina', 'Sidorova', 22, '+79117771122');

insert into dolgosheev.orders(customer_id, product_name, amount)
values (1, 'milk', 2),
       (2, 'bread', 1),
       (3, 'apples', 5),
       (4, 'bananas', 4),
       (5, 'sugar', 1),
       (6, 'water', 2),
       (7, 'beef', 1);