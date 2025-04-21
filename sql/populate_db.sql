INSERT INTO worker (name , birthday, level, salary) VALUES
('Taras Bulba','1999-04-01','junior', 500),
('ivan hrehorovych','2004-01-01','senior', 10000),
('Marie Kacy','1997-11-28','trainee', 5000),
('Taras Mychajlovich','2001-12-15','middle', 15000),
('Petro Ivanjuk','2005-07-25','junior', 900),
('Kateryna Pelikan','2010-07-21','middle', 25000),
('Diana Kravets','1997-04-01','senior', 99000),
('Kim Kardashian','1999-09-01','junior', 1000),
('Bohdan Ivanchenko','1999-12-06','middle', 8500),
('Max Barskich','1909-04-01','senior', 70000);

INSERT INTO client (name) VALUES
('Apple'),
('Microsoft'),
('Amazon'),
('Samsung'),
('DJI');

INSERT INTO project (client_id , start_date , finish_date) VALUES
(1, '2023-01-01', '2023-06-01'),
(2, '2023-03-15', '2024-02-15'),
(3, '2024-05-01', '2025-01-01'),
(4, '2022-11-01', '2023-09-01'),
(5, '2023-07-01', '2024-03-01'),
(1, '2022-06-15', '2023-02-15'),
(2, '2024-07-01', '2025-05-01'),
(3, '2023-10-01', '2024-09-01'),
(4, '2024-02-01', '2024-08-01'),
(5, '2023-04-15', '2024-06-01');

INSERT INTO project_worker (project_id,worker_id) VALUES
(1, 1), (1, 2), (1, 3),
(2, 4), (2, 5),
(3, 6), (3, 7),
(4, 8), (4, 9),
(5, 10), (5, 1),
(6, 2), (6, 3),
(7, 4), (7, 5),
(8, 6), (8, 7),
(9, 8), (9, 9),
(10, 10), (10, 1);
