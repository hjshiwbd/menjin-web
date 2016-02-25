10.157.4.11
sa/Das123


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
drop table mjsq_menu;
create table mjsq_menu (
	id varchar(20) primary key,
	name varchar(50),
	url varchar(50),
	opentype varchar(50),
	pid varchar(50)
);
------------------------------------------------------------
CREATE TABLE [dbo].[mjsq_qqrz] (
[id] int NOT NULL IDENTITY(1,1) ,
[rybh] varchar(50) COLLATE Chinese_PRC_CI_AS NULL ,
[lm] varchar(50) COLLATE Chinese_PRC_CI_AS NULL ,
[ffm] varchar(50) COLLATE Chinese_PRC_CI_AS NULL ,
[qqdz] varchar(50) COLLATE Chinese_PRC_CI_AS NULL ,
[qqcs] text COLLATE Chinese_PRC_CI_AS NULL ,
[qqbh] varchar(50) COLLATE Chinese_PRC_CI_AS NULL ,
[qqmc] varchar(50) COLLATE Chinese_PRC_CI_AS NULL ,
[qqms] text COLLATE Chinese_PRC_CI_AS NULL ,
[ip] varchar(50) COLLATE Chinese_PRC_CI_AS NULL ,
[qqsj] varchar(50) COLLATE Chinese_PRC_CI_AS NULL ,
[sessionid] varchar(50) COLLATE Chinese_PRC_CI_AS NULL ,
[header] text COLLATE Chinese_PRC_CI_AS NULL ,
CONSTRAINT [PK__mjsq_qqr__3213E83F25869641] PRIMARY KEY ([id])
)
ON [PRIMARY]
TEXTIMAGE_ON [PRIMARY]
GO
------------------------------------------------------------
create table mjsq_user (
id int primary key identity(1,1),
username varchar(50) not null unique,
password varchar(150) not null
)
------------------------------------------------------------
alter table ndr2_door add hwacid nvarchar(100)
------------------------------------------------------------
------------------------------------------------------------
------------------------------------------------------------
------------------------------------------------------------
------------------------------------------------------------
------------------------------------------------------------
------------------------------------------------------------
------------------------------------------------------------
------------------------------------------------------------
------------------------------------------------------------
------------------------------------------------------------
------------------------------------------------------------
