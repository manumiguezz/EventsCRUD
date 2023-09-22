USE `event_directory`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users` 
VALUES 
('javipucheta','{bcrypt}$2a$10$2M/kSQpAtz9Q6O25a2s8fO0I4mY8VsLLjvlmChEpAyN1s1eSSRKJq',1),
('biancalauria','{bcrypt}$2a$10$2pDST4f78vq9L/Wm9dnP0u2pSshm9/jsh6hJQuLCokvNkezhZyI2K',1),
('manumiguezz','{bcrypt}$2a$10$QUie/5fqBam6TJxDEPmolOCgdcrw/m/a54t1n5IkCpw3uqsNCENwC',1);

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `authorities` 
VALUES 
('javipucheta','ROLE_PUBLIC'),
('biancalauria','ROLE_PUBLIC'),
('biancalauria','ROLE_WORKER'),
('manumiguezz','ROLE_PUBLIC'),
('manumiguezz','ROLE_WORKER'),
('manumiguezz','ROLE_DEV');