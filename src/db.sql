CREATE DATABASE bookstore CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE bookstore.Student
(
  id INT NOT NULL,
  name VARCHAR(255),
  age INT NOT NULL,
  PRIMARY KEY ( id )
);

CREATE TABLE bookstore.Test
(
  tid INT(10) NOT NULL,
  tname VARCHAR(100),
  age INT NOT NULL,
  PRIMARY KEY (tid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE bookstore.Statistics
(
  stid INT(10) NOT NULL,
  id INT(10) NOT NULL,
  tid INT(10) NOT NULL,
  PRIMARY KEY (stid),
  FOREIGN KEY (id) REFERENCES Student(id),
  FOREIGN KEY (tid) REFERENCES Test(tid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
