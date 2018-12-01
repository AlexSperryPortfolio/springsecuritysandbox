CREATE  TABLE users (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (user_ID),
  UNIQUE KEY uni_username (username)
);

CREATE TABLE authority (
    authority_id int(11) NOT NULL AUTO_INCREMENT,
    authority_name varchar(45) NOT NULL,
    PRIMARY KEY (authority_id)
);

CREATE TABLE user_authority (
  user_authority_id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) NOT NULL,
  authority_id int(11) NOT NULL,
  PRIMARY KEY (user_authority_id),
  CONSTRAINT fk_user_authority_user_id FOREIGN KEY (user_id) REFERENCES users (user_id),
  CONSTRAINT fk_user_authority_authority_id FOREIGN KEY (authority_id) REFERENCES authority (authority_id)
);
