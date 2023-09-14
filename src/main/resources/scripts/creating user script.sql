DROP USER if exists 'eventname'@'localhost';

CREATE USER 'eventname'@'localhost' IDENTIFIED BY 'eventname';

GRANT ALL PRIVILEGES ON * . * TO 'eventname'@'localhost';