INSERT INTO ROLE (ROLE_ID, ROLE_NAME , AUTHORITY) VALUES
  (1, 'Users', 'ROLE_USER'),
  (2, 'Administrators', 'ROLE_ADMIN');
INSERT INTO USER (USER_ID, USERNAME, PASSWORD) VALUES
  (1, 'admin', '$2a$10$ks.dpu2YDc5BrpoZwR6T2e.l5EScUuSuyYDoxtuCx3nVU2YVCVlA.');

INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES
  (1, 1),
  (1, 2);