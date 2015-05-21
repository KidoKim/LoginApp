CREATE DATABASE login_app;
USE login_app;

CREATE TABLE IF NOT EXISTS users(
  username varchar(45) NOT NULL,
  enabled bit(1) NOT NULL,
  password varchar(60) NOT NULL,
  PRIMARY KEY (username)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

INSERT INTO users(username, enabled, password) VALUES
('admin', b'1', 'admin@123'),
('user', b'1', 'user@123');

#SHA encoded password for test
#('user', b'1', '68c9fc4c03dff5d734aab9787b5ea01d7d88aa85'),
#('admin', b'1', '23d42f5f3f66498b2c8ff4c20b8c5ac826e47146'); 

CREATE TABLE IF NOT EXISTS user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  role varchar(45) NOT NULL,
  username varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  KEY FK_9ry105icat2dux14oyixybw9l (username),
  CONSTRAINT FK_9ry105icat2dux14oyixybw9l FOREIGN KEY (username) REFERENCES users (username)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


INSERT INTO user_roles (user_role_id, role, username) VALUES
(1, 'ROLE_ADMIN', 'admin'), 
(2, 'ROLE_USER', 'user'),
(3, 'ROLE_USER', 'admin');
