INSERT INTO Dealers(address, city, email, name , open_hours, phone)
VALUES ('Żelazna 10','Warszawa','cylinder-warszawa@wp.pl', 'Cylinder','8-18','101 000 000'),
       ('Miedziana 20', 'Kraków', 'hp@wp.pl', 'Horse Power', '9-17', '202 000 000'),
       ('Srebrna 30', 'Szczecin', 'drifters@wp.pl', 'Drifters', '10-18', '303 000 000'),
       ('Tytanowa 40', 'Poznań', 'hotrod@wp.pl', 'Hot Rod', '9-17', '404 000 000');

INSERT INTO Cars(dealer_id, brand, model, engine, year , mileage, colour, price)
VALUES
       (1, 'Audi', 'A4', '2.0 TDI', '2015', '125 0000', 'Red Metallic', '49 900'),
       (1, 'Audi', 'A3', '1.4 FSI', '2008', '130 0000', 'White Pearl', '25 700'),
       (1, 'BMW', 'M50', '4.4 ', '2017', '33 0000','White Pearl', '247 000'),
       (2, 'Ford', 'Kuga', '1.5 ', '2019','1','Blue Metallic', '97 300'),
       (2, 'Mitsubishi ', 'ASX', '2.0', '2015 ','123 0000','White', '56 900'),
       (2, 'Hyundai ', 'Elantra', '1.6', '2019','6','Black', '77 300'),
       (3, 'Audi', 'Q5', '2.5 TDI', '2013','83 0000','Solver Metallic', '84 900'),
       (3, 'Audi', 'A8', '3.0 Diesel', '2018','41 000','Silver', '250 000'),
       (4, 'Ford ', 'Mustang', '5.8', '1972','65 000','Blue', '147 000'),
       (4, 'Chevrolet', 'Corvette', '7.0', '1968','11 100','Black', '225 000');

INSERT INTO USER (user_name, password, role)
VALUES
        ('User', 'User', 'USER'),
        ('Admin', 'Admin', 'ADMIN');
