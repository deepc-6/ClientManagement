
CREATE TABLE DB2ADMIN.CLIENT
	(ID SMALLINT NOT NULL GENERATED ALWAYS AS IDENTITY 
	(START WITH 1, INCREMENT BY 1), 
	BUSINESSNAME VARCHAR(100),
	INTERLOCUTER VARCHAR(100),
	ADDRESS VARCHAR(100),
	ZIPCODE VARCHAR(100),
	CITY VARCHAR(100),
	PHONE VARCHAR(100),
	EMAIL VARCHAR(100),
	COMMENT VARCHAR(100)
	);
	
INSERT INTO 
	DB2ADMIN.CLIENT (BUSINESSNAME, INTERLOCUTER, ADDRESS, ZIPCODE, CITY, PHONE, EMAIL, COMMENT)
    VALUES ('BusinessName1', 'Interlocuter1', '78 rue de summer', '75001', 'Paris', '1234567890', 'asd@asd.com', 'Comment1');
    
GRANT SELECT ON DB2ADMIN.CLIENT TO DB2ADMIN;
GRANT INSERT ON DB2ADMIN.CLIENT TO DB2ADMIN;
GRANT UPDATE ON DB2ADMIN.CLIENT TO DB2ADMIN;
GRANT DELETE ON DB2ADMIN.CLIENT TO DB2ADMIN;