CREATE TABLE CONTACTS (
  CONTACT_ID INT AUTO_INCREMENT  PRIMARY KEY,
  FIRST_NAME VARCHAR(250) NOT NULL,
  LAST_NAME VARCHAR(250) NOT NULL,
  EMAIL VARCHAR(250) DEFAULT NULL,
  PHONE VARCHAR(250) DEFAULT NULL
);

INSERT INTO CONTACTS (CONTACT_ID,FIRST_NAME, LAST_NAME, EMAIL,PHONE) VALUES
  ('1','Avijit', 'Kundu', 'k.avijit01@gmail.com','9051797711','Active');

  commit;