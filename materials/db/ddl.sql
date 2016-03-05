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
CONSTRAINT [PK__mjsq_qqr__3213E83F0A351835] PRIMARY KEY ([id])
)
ON [PRIMARY]
TEXTIMAGE_ON [PRIMARY]
GO

CREATE UNIQUE INDEX [idx_mjsq_qqrz_id] ON [dbo].[mjsq_qqrz]
([id] ASC) 
WITH (IGNORE_DUP_KEY = ON)
ON [PRIMARY]
GO

CREATE INDEX [idx_mjsq_qqrz_qqsj] ON [dbo].[mjsq_qqrz]
([qqsj] ASC) 
ON [PRIMARY]
GO

CREATE INDEX [idx_mjsq_qqrz_rybh] ON [dbo].[mjsq_qqrz]
([rybh] ASC) 
ON [PRIMARY]
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
CREATE TABLE [dbo].[mjsq_user_resource] (
[id] int NOT NULL identity(1,1) ,
[user_id] nvarchar(10) COLLATE Chinese_PRC_CI_AS NULL ,
[resource_id] nvarchar(50) COLLATE Chinese_PRC_CI_AS NULL ,
[resource_type] nvarchar(50) COLLATE Chinese_PRC_CI_AS NULL ,
CONSTRAINT [PK__mjsq_use__3213E83F50C790AF] PRIMARY KEY ([id])
)
ON [PRIMARY]
GO
------------------------------------------------------------
CREATE TABLE [dbo].[mjsq_emp_card] (
[id] int NOT NULL IDENTITY(1,1) ,
[empno] varchar(80) COLLATE Chinese_PRC_CI_AS NULL ,
[cardno] varchar(80) COLLATE Chinese_PRC_CI_AS NULL ,
CONSTRAINT [PK__mjsq_emp__3213E83F2C8A3039] PRIMARY KEY ([id])
)
ON [PRIMARY]
GO
------------------------------------------------------------
CREATE TABLE [dbo].[mjsq_card_accode] (
[id] int NOT NULL IDENTITY(1,1) ,
[cardno] varchar(80) COLLATE Chinese_PRC_CI_AS NULL ,
[accodeid] varchar(80) COLLATE Chinese_PRC_CI_AS NULL ,
CONSTRAINT [PK__mjsq_car__3213E83F28B99F55] PRIMARY KEY ([id])
)
ON [PRIMARY]
GO

------------------------------------------------------------
CREATE TABLE [dbo].[mjsq_hw_eventlog] (
[id] int NOT NULL IDENTITY(1,1) ,
[logdevdescrp] varchar(255) COLLATE Chinese_PRC_CI_AS NULL ,
[logdevtypedesc] varchar(255) COLLATE Chinese_PRC_CI_AS NULL ,
[rec_dat] varchar(255) COLLATE Chinese_PRC_CI_AS NULL ,
[evnt_dat] varchar(255) COLLATE Chinese_PRC_CI_AS NULL ,
[evnt_descrp] varchar(255) COLLATE Chinese_PRC_CI_AS NULL ,
[descrp] varchar(255) COLLATE Chinese_PRC_CI_AS NULL ,
[location] varchar(255) COLLATE Chinese_PRC_CI_AS NULL ,
[cardno] varchar(255) COLLATE Chinese_PRC_CI_AS NULL ,
[lname] varchar(255) COLLATE Chinese_PRC_CI_AS NULL ,
[fname] varchar(255) COLLATE Chinese_PRC_CI_AS NULL ,
[stat_cod] varchar(255) COLLATE Chinese_PRC_CI_AS NULL ,
[comp_name] varchar(255) COLLATE Chinese_PRC_CI_AS NULL ,
[threat_lev] varchar(255) COLLATE Chinese_PRC_CI_AS NULL ,
CONSTRAINT [PK__mjsq_hw___3213E83F305AC11D] PRIMARY KEY ([id])
)
ON [PRIMARY]
GO

------------------------------------------------------------
------------------------------------------------------------
------------------------------------------------------------
------------------------------------------------------------
------------------------------------------------------------
------------------------------------------------------------
------------------------------------------------------------
------------------------------------------------------------
