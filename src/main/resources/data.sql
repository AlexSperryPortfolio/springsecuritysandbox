
INSERT INTO users(user_id, username, password, enabled) VALUES
(1, 'admin','admin', true),
(2, 'user','password', true);

INSERT INTO authority(authority_id, authority_name) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

INSERT INTO user_authority(user_authority_id, user_id, authority_id) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 2);