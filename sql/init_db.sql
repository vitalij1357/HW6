 CREATE TABLE worker (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(1000) NOT NULL,
 birthday DATE NOT NULL CHECK(YEAR (birthday)>1900),
 level VARCHAR(100) NOT NULL,
 salary INT CHECK (salary BETWEEN 100 AND 100000));

 CREATE TABLE client (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(1000) NOT NULL);

 CREATE TABLE project(
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 client_id BIGINT,
 start_date DATE NOT NULL,
 finish_date DATE NOT NULL);

 CREATE TABLE project_worker(
 project_id BIGINT,
 worker_id BIGINT,
 PRIMARY KEY(project_id,worker_id),
 FOREIGN KEY (project_id) REFERENCES project(id),
 FOREIGN KEY (worker_id) REFERENCES worker(id)
 );


 ALTER TABLE project
 ADD CONSTRAINT client_id_fk FOREIGN KEY (client_id)
 REFERENCES client(id);

 ALTER TABLE worker
 ADD CONSTRAINT posible_lvls
 CHECK(level IN ('trainee','junior','middle','senior'));