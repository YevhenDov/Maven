CREATE DATABASE IF NOT EXISTS developers_base;
USE developers_base;

CREATE TABLE IF NOT EXISTS developers
(
  developer_id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  developer_name VARCHAR(30),
  age            INT,
  gender         VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS skills
(
  skills_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  skill     VARCHAR(30),
  skill_lvl VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS projects
(
  project_id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  project_name VARCHAR(30),
  dead_line    VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS companies
(
  company_id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  company_name VARCHAR(30),
  address      VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS customers
(
  customer_id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  customer_name     VARCHAR(30),
  customer_location varchar(30)
);

CREATE TABLE IF NOT EXISTS developers_skills
(
  id           INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  developer_id INT,
  skills_id    INT,
  FOREIGN KEY (developer_id) REFERENCES developers (developer_id),
  FOREIGN KEY (skills_id) REFERENCES skills (skills_id)
);

CREATE TABLE IF NOT EXISTS developers_projects
(
  id           INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  developer_id INT,
  project_id   INT,
  FOREIGN KEY (developer_id) REFERENCES developers (developer_id),
  FOREIGN KEY (project_id) REFERENCES projects (project_id)
);

CREATE TABLE IF NOT EXISTS companies_project
(
  id         INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  company_id INT,
  project_id INT,
  FOREIGN KEY (company_id) REFERENCES companies (company_id),
  FOREIGN KEY (project_id) REFERENCES projects (project_id)
);

CREATE TABLE IF NOT EXISTS customers_project
(
  id          INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  customer_id INT,
  project_id  INT,
  FOREIGN KEY (customer_id) REFERENCES customers (customer_id),
  FOREIGN KEY (project_id) REFERENCES projects (project_id)
);

INSERT INTO developers(developer_name, age, gender)
VALUES ('Tim Cook', 21, 'm'),
       ('Bob Jones', 18, 'm'),
       ('Bob Camel', 22, 'f'),
       ('Anabel Charon', 20, 'f'),
       ('Tony Douglas', 27, 'm'),
       ('James Hadron', 25, 'm');

INSERT INTO skills(skill, skill_lvl)
VALUES ('Java', 'Junior'),
       ('Java', 'Middle'),
       ('Java', 'Senior'),
       ('C++', 'Junior'),
       ('C++', 'Middle'),
       ('C++', 'Senior'),
       ('C#', 'Junior'),
       ('C#', 'Middle'),
       ('C#', 'Senior'),
       ('JS', 'Junior'),
       ('JS', 'Middle'),
       ('JS', 'Senior');

INSERT INTO projects(project_name, dead_line)
VALUES ('PhoneApp', '10.10.2019'),
       ('DeskTopApp', '15.12.2019');

INSERT INTO companies(company_name, address)
VALUES ('Apple', 'USA'),
       ('Google', 'USA');

INSERT INTO customers(customer_name, customer_location)
VALUES ('Jim', 'USA'),
       ('Jenny', 'Canada');

INSERT INTO developers_skills(developer_id, skills_id)
VALUES (1, 1),
       (1, 5),
       (2, 4),
       (3, 8),
       (3, 11),
       (4, 5),
       (5, 3),
       (5, 5),
       (6, 9),
       (6, 12);

INSERT INTO companies_project(company_id, project_id)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (2, 2);

INSERT INTO customers_project(customer_id, project_id)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (2, 2);

INSERT INTO developers_projects(developer_id, project_id)
VALUES (1, 1), (2, 1), (3, 1),
       (4, 2), (5, 2), (6, 2);