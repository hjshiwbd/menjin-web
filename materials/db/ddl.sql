DROP TABLE system_config;

CREATE TABLE system_config (
	confcode VARCHAR (50) PRIMARY KEY,
	confname VARCHAR (50),
	confgroup VARCHAR (50),
	confvalue VARCHAR (200),
	confdesc VARCHAR (200),
	servicecode VARCHAR (20),
	confstatus VARCHAR (5)
);
------------------------------------------------------------
