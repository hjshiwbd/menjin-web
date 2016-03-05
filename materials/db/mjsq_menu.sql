/*
Navicat SQL Server Data Transfer

Source Server         : 10.157.4.11
Source Server Version : 105000
Source Host           : 10.157.4.11:1433
Source Database       : AIO20160129213806
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 105000
File Encoding         : 65001

Date: 2016-03-05 10:03:50
*/


-- ----------------------------
-- Table structure for mjsq_menu
-- ----------------------------
DROP TABLE [dbo].[mjsq_menu]
GO
CREATE TABLE [dbo].[mjsq_menu] (
[id] varchar(50) NOT NULL ,
[name] varchar(50) NULL ,
[url] varchar(50) NULL ,
[opentype] varchar(50) NULL ,
[pid] varchar(50) NULL ,
[css] varchar(50) NULL ,
[sortorder] int NULL ,
[status] varchar(5) NULL 
)


GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'mjsq_menu', 
'COLUMN', N'id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'menuid'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'mjsq_menu'
, @level2type = 'COLUMN', @level2name = N'id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'menuid'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'mjsq_menu'
, @level2type = 'COLUMN', @level2name = N'id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'mjsq_menu', 
'COLUMN', N'name')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'菜单名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'mjsq_menu'
, @level2type = 'COLUMN', @level2name = N'name'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'菜单名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'mjsq_menu'
, @level2type = 'COLUMN', @level2name = N'name'
GO

-- ----------------------------
-- Records of mjsq_menu
-- ----------------------------
INSERT INTO [dbo].[mjsq_menu] ([id], [name], [url], [opentype], [pid], [css], [sortorder], [status]) VALUES (N'emp', N'人员管理', null, N'0', N'root', N'fa-credit-card', N'2', N'1')
GO
GO
INSERT INTO [dbo].[mjsq_menu] ([id], [name], [url], [opentype], [pid], [css], [sortorder], [status]) VALUES (N'emp_guanli', N'人员管理', N'/emp/guanli.html', N'0', N'emp', null, N'2', N'0')
GO
GO
INSERT INTO [dbo].[mjsq_menu] ([id], [name], [url], [opentype], [pid], [css], [sortorder], [status]) VALUES (N'emp_xinzeng', N'人员新增', N'/emp/xinzeng.html', N'0', N'emp', null, N'1', N'1')
GO
GO
INSERT INTO [dbo].[mjsq_menu] ([id], [name], [url], [opentype], [pid], [css], [sortorder], [status]) VALUES (N'geren', N'个人信息', null, N'0', N'root', N'fa-user', N'4', N'1')
GO
GO
INSERT INTO [dbo].[mjsq_menu] ([id], [name], [url], [opentype], [pid], [css], [sortorder], [status]) VALUES (N'geren_mima', N'密码修改', N'/user/mima.html', N'0', N'geren', null, N'1', N'1')
GO
GO
INSERT INTO [dbo].[mjsq_menu] ([id], [name], [url], [opentype], [pid], [css], [sortorder], [status]) VALUES (N'menjin', N'门禁管理', null, N'0', N'root', N'fa-cogs', N'1', N'1')
GO
GO
INSERT INTO [dbo].[mjsq_menu] ([id], [name], [url], [opentype], [pid], [css], [sortorder], [status]) VALUES (N'menjin_event', N'门禁事件', N'/menjin/event.html', N'0', N'menjin', null, N'4', N'1')
GO
GO
INSERT INTO [dbo].[mjsq_menu] ([id], [name], [url], [opentype], [pid], [css], [sortorder], [status]) VALUES (N'menjin_shezhi', N'门禁设置', N'/menjin/shezhi.html', N'0', N'menjin', null, N'1', N'1')
GO
GO
INSERT INTO [dbo].[mjsq_menu] ([id], [name], [url], [opentype], [pid], [css], [sortorder], [status]) VALUES (N'menjin_shouquan', N'门禁授权', N'/menjin/shouquan.html', N'0', N'menjin', null, N'2', N'1')
GO
GO
INSERT INTO [dbo].[mjsq_menu] ([id], [name], [url], [opentype], [pid], [css], [sortorder], [status]) VALUES (N'menjin_yuanchengkongzhi', N'远程控制', N'/menjin/yckz.html', N'0', N'menjin', null, N'3', N'1')
GO
GO
INSERT INTO [dbo].[mjsq_menu] ([id], [name], [url], [opentype], [pid], [css], [sortorder], [status]) VALUES (N'xitong', N'系统控制', null, N'0', N'root', N'fa-wrench', N'3', N'1')
GO
GO
INSERT INTO [dbo].[mjsq_menu] ([id], [name], [url], [opentype], [pid], [css], [sortorder], [status]) VALUES (N'xitong_bumen', N'部门管理', N'/dpt/list.html', N'0', N'xitong', null, N'3', N'0')
GO
GO
INSERT INTO [dbo].[mjsq_menu] ([id], [name], [url], [opentype], [pid], [css], [sortorder], [status]) VALUES (N'xitong_canshu', N'系统参数', N'/xtkz/xtcs.html', N'0', N'xitong', null, N'1', N'0')
GO
GO
INSERT INTO [dbo].[mjsq_menu] ([id], [name], [url], [opentype], [pid], [css], [sortorder], [status]) VALUES (N'xitong_chaxun', N'综合查询', N'/xtkz/zhcx.html', N'0', N'xitong', null, N'2', N'0')
GO
GO
INSERT INTO [dbo].[mjsq_menu] ([id], [name], [url], [opentype], [pid], [css], [sortorder], [status]) VALUES (N'xitong_user', N'用户管理', N'/user/list.html', N'0', N'xitong', null, N'4', N'1')
GO
GO

-- ----------------------------
-- Indexes structure for table mjsq_menu
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table mjsq_menu
-- ----------------------------
ALTER TABLE [dbo].[mjsq_menu] ADD PRIMARY KEY ([id])
GO
