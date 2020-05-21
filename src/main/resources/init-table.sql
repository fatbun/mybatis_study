CREATE TABLE t_employee
(
  id INT PRIMARY KEY NOT NULL,
  name VARCHAR(20),
  phone VARCHAR(20),
  identity VARCHAR(20),
  department_id INT
);
CREATE UNIQUE INDEX t_employee_id_uindex ON t_employee (id);

CREATE TABLE t_department
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  dname VARCHAR(20)
);
CREATE UNIQUE INDEX t_department_id_uindex ON t_department (id);