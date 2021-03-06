USE [ip_addresses]
GO
/****** Object:  Table [dbo].[city]    Script Date: 11/20/2013 12:26:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[city](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[city_name] [varchar](255) NULL,
	[country] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[country]    Script Date: 11/20/2013 12:26:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[country](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[country_code] [varchar](255) NULL,
	[country_name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ip_addresses]    Script Date: 11/20/2013 12:26:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ip_addresses](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[address] [varchar](255) NOT NULL,
	[date_added] [datetime] NULL,
	[status] [bit] NULL,
	[city] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ipv4_addresses]    Script Date: 11/20/2013 12:26:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ipv4_addresses](
	[id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ipv6_addresses]    Script Date: 11/20/2013 12:26:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ipv6_addresses](
	[id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[not_valid_ip]    Script Date: 11/20/2013 12:26:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[not_valid_ip](
	[id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[roles]    Script Date: 11/20/2013 12:26:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[roles](
	[role_id] [int] NOT NULL,
	[role] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[settings_for_pagination]    Script Date: 11/20/2013 12:26:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[settings_for_pagination](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ips_per_page] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[sources]    Script Date: 11/20/2013 12:26:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[sources](
	[source_id] [int] IDENTITY(1,1) NOT NULL,
	[dirname] [varchar](255) NULL,
	[list_type] [varchar](255) NOT NULL,
	[parser] [varchar](255) NULL,
	[rank] [float] NOT NULL,
	[source_date_added] [datetime] NOT NULL,
	[source_name] [varchar](255) NOT NULL,
	[updated] [datetime] NULL,
	[url] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[source_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[sources_to_addresses]    Script Date: 11/20/2013 12:26:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sources_to_addresses](
	[ip_id] [int] NOT NULL,
	[source_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ip_id] ASC,
	[source_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[user_roles]    Script Date: 11/20/2013 12:26:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_roles](
	[user_id] [int] NOT NULL,
	[role_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC,
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[users]    Script Date: 11/20/2013 12:26:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ctime] [datetime] NULL,
	[email] [nvarchar](50) NOT NULL,
	[firstname] [nvarchar](50) NULL,
	[lastname] [nvarchar](50) NULL,
	[ltime] [datetime] NULL,
	[password] [nvarchar](50) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK__users__3213E83FE1DB1C12] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[city] ON 

INSERT [dbo].[city] ([id], [city_name], [country]) VALUES (1, N'Lviv', 1)
SET IDENTITY_INSERT [dbo].[city] OFF
SET IDENTITY_INSERT [dbo].[country] ON 

INSERT [dbo].[country] ([id], [country_code], [country_name]) VALUES (1, N'UA', N'Ukraine')
SET IDENTITY_INSERT [dbo].[country] OFF
SET IDENTITY_INSERT [dbo].[ip_addresses] ON 

INSERT [dbo].[ip_addresses] ([id], [address], [date_added], [status], [city]) VALUES (1, N'127.0.0.1', CAST(0x0000A270000D0FF7 AS DateTime), 0, 1)
INSERT [dbo].[ip_addresses] ([id], [address], [date_added], [status], [city]) VALUES (3, N'127.0.0.3', CAST(0x0000A270000D0FF7 AS DateTime), 0, 1)
INSERT [dbo].[ip_addresses] ([id], [address], [date_added], [status], [city]) VALUES (5, N'0127:0000:0000:0001', CAST(0x0000A270000D0FF7 AS DateTime), 0, NULL)
INSERT [dbo].[ip_addresses] ([id], [address], [date_added], [status], [city]) VALUES (6, N'0127:0000:0000:0002', CAST(0x0000A270000D0FF7 AS DateTime), 0, NULL)
INSERT [dbo].[ip_addresses] ([id], [address], [date_added], [status], [city]) VALUES (7, N'0127:0000:0000:0003', CAST(0x0000A270000D0FF7 AS DateTime), 0, NULL)
INSERT [dbo].[ip_addresses] ([id], [address], [date_added], [status], [city]) VALUES (8, N'0127:0000:0000:0004', CAST(0x0000A270000D0FF7 AS DateTime), 0, NULL)
INSERT [dbo].[ip_addresses] ([id], [address], [date_added], [status], [city]) VALUES (9, N'0127:0000:0m00:0001', CAST(0x0000A270000D0FF7 AS DateTime), NULL, NULL)
INSERT [dbo].[ip_addresses] ([id], [address], [date_added], [status], [city]) VALUES (10, N'x127:0000:0000:0001', CAST(0x0000A270000D0FF7 AS DateTime), NULL, NULL)
INSERT [dbo].[ip_addresses] ([id], [address], [date_added], [status], [city]) VALUES (11, N'0127:0000:0000:0z01', CAST(0x0000A270000D0FF7 AS DateTime), NULL, NULL)
INSERT [dbo].[ip_addresses] ([id], [address], [date_added], [status], [city]) VALUES (12, N'0127:0000:000z:0001', CAST(0x0000A270000D0FF7 AS DateTime), NULL, NULL)
INSERT [dbo].[ip_addresses] ([id], [address], [date_added], [status], [city]) VALUES (13, N'13.13.13.13', CAST(0x0000A27B011D92BD AS DateTime), 0, NULL)
INSERT [dbo].[ip_addresses] ([id], [address], [date_added], [status], [city]) VALUES (14, N'192.168.0.175', CAST(0x0000A27B0121D731 AS DateTime), NULL, NULL)
INSERT [dbo].[ip_addresses] ([id], [address], [date_added], [status], [city]) VALUES (16, N'192.168.0.176', CAST(0x0000A27B0123094C AS DateTime), NULL, NULL)
SET IDENTITY_INSERT [dbo].[ip_addresses] OFF
INSERT [dbo].[ipv4_addresses] ([id]) VALUES (1)
INSERT [dbo].[ipv4_addresses] ([id]) VALUES (3)
INSERT [dbo].[ipv4_addresses] ([id]) VALUES (13)
INSERT [dbo].[ipv4_addresses] ([id]) VALUES (14)
INSERT [dbo].[ipv4_addresses] ([id]) VALUES (16)
INSERT [dbo].[ipv6_addresses] ([id]) VALUES (5)
INSERT [dbo].[ipv6_addresses] ([id]) VALUES (6)
INSERT [dbo].[ipv6_addresses] ([id]) VALUES (7)
INSERT [dbo].[ipv6_addresses] ([id]) VALUES (8)
INSERT [dbo].[not_valid_ip] ([id]) VALUES (9)
INSERT [dbo].[not_valid_ip] ([id]) VALUES (10)
INSERT [dbo].[not_valid_ip] ([id]) VALUES (11)
INSERT [dbo].[not_valid_ip] ([id]) VALUES (12)
INSERT [dbo].[roles] ([role_id], [role]) VALUES (1, N'ROLE_ADMIN')
INSERT [dbo].[roles] ([role_id], [role]) VALUES (2, N'ROLE_USER')
SET IDENTITY_INSERT [dbo].[settings_for_pagination] ON 

INSERT [dbo].[settings_for_pagination] ([id], [ips_per_page]) VALUES (1, 10)
INSERT [dbo].[settings_for_pagination] ([id], [ips_per_page]) VALUES (2, 20)
INSERT [dbo].[settings_for_pagination] ([id], [ips_per_page]) VALUES (3, 30)
INSERT [dbo].[settings_for_pagination] ([id], [ips_per_page]) VALUES (4, 40)
SET IDENTITY_INSERT [dbo].[settings_for_pagination] OFF
SET IDENTITY_INSERT [dbo].[sources] ON 

INSERT [dbo].[sources] ([source_id], [dirname], [list_type], [parser], [rank], [source_date_added], [source_name], [updated], [url]) VALUES (1, N'/src/main/resources/sources/openbsd/', N'blacklist', N'tc.lv.utils.ParserOpenBSD', 0.7, CAST(0x0000A12500000000 AS DateTime), N'OpenBSD traplist', NULL, N'http://www.openbsd.org/spamd/traplist.gz')
INSERT [dbo].[sources] ([source_id], [dirname], [list_type], [parser], [rank], [source_date_added], [source_name], [updated], [url]) VALUES (2, N'/src/main/resources/sources/nixspam/', N'blacklist', N'tc.lv.utils.ParserUceprotect', 0.6, CAST(0x0000A12500000000 AS DateTime), N'Nixspam list', NULL, N'http://www.dnsbl.manitu.net/download/nixspam-ip.dump.gz')
INSERT [dbo].[sources] ([source_id], [dirname], [list_type], [parser], [rank], [source_date_added], [source_name], [updated], [url]) VALUES (3, N'/src/main/resources/sources/chaosreigns/', N'whitelist', N'tc.lv.utils.ParserChaosreignsWL', 0.1, CAST(0x0000A12500000000 AS DateTime), N'Chaosreigns Whitelist', NULL, N'http://www.chaosreigns.com/iprep/iprep.txt')
INSERT [dbo].[sources] ([source_id], [dirname], [list_type], [parser], [rank], [source_date_added], [source_name], [updated], [url]) VALUES (4, NULL, N'whitelist', NULL, 0.6, CAST(0x0000A12500000000 AS DateTime), N'Admin Whitelist', NULL, NULL)
INSERT [dbo].[sources] ([source_id], [dirname], [list_type], [parser], [rank], [source_date_added], [source_name], [updated], [url]) VALUES (5, NULL, N'blacklist', NULL, 0.4, CAST(0x0000A12500000000 AS DateTime), N'Admin Blacklist', NULL, NULL)
SET IDENTITY_INSERT [dbo].[sources] OFF
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (1, 1)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (1, 3)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (3, 1)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (3, 3)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (5, 1)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (5, 3)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (6, 1)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (6, 3)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (7, 1)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (7, 3)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (8, 1)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (8, 3)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (9, 1)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (9, 3)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (10, 1)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (10, 3)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (11, 1)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (11, 3)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (12, 1)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (12, 3)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (13, 4)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (13, 5)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (14, 1)
INSERT [dbo].[sources_to_addresses] ([ip_id], [source_id]) VALUES (16, 1)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (1, 1)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (1, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (2, 2)
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([id], [ctime], [email], [firstname], [lastname], [ltime], [password], [username]) VALUES (1, NULL, N'mailadmin', NULL, NULL, NULL, N'admin', N'admin')
INSERT [dbo].[users] ([id], [ctime], [email], [firstname], [lastname], [ltime], [password], [username]) VALUES (2, NULL, N'usermain', NULL, NULL, NULL, N'user', N'user')
SET IDENTITY_INSERT [dbo].[users] OFF
SET ANSI_PADDING ON

GO
/****** Object:  Index [UNQ_Address]    Script Date: 11/20/2013 12:26:34 PM ******/
ALTER TABLE [dbo].[ip_addresses] ADD  CONSTRAINT [UNQ_Address] UNIQUE NONCLUSTERED 
(
	[address] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UNQ_Username]    Script Date: 11/20/2013 12:26:34 PM ******/
ALTER TABLE [dbo].[users] ADD  CONSTRAINT [UNQ_Username] UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[city]  WITH CHECK ADD  CONSTRAINT [FK_19n44pdeel8yfme7nl4vw8csq] FOREIGN KEY([country])
REFERENCES [dbo].[country] ([id])
GO
ALTER TABLE [dbo].[city] CHECK CONSTRAINT [FK_19n44pdeel8yfme7nl4vw8csq]
GO
ALTER TABLE [dbo].[ip_addresses]  WITH CHECK ADD  CONSTRAINT [FK_59um4ttvkji8ef13k0y2by1lc] FOREIGN KEY([city])
REFERENCES [dbo].[city] ([id])
GO
ALTER TABLE [dbo].[ip_addresses] CHECK CONSTRAINT [FK_59um4ttvkji8ef13k0y2by1lc]
GO
ALTER TABLE [dbo].[ipv4_addresses]  WITH CHECK ADD  CONSTRAINT [FK_kyqn24svikl9hb2ie3aymjtak] FOREIGN KEY([id])
REFERENCES [dbo].[ip_addresses] ([id])
GO
ALTER TABLE [dbo].[ipv4_addresses] CHECK CONSTRAINT [FK_kyqn24svikl9hb2ie3aymjtak]
GO
ALTER TABLE [dbo].[ipv6_addresses]  WITH CHECK ADD  CONSTRAINT [FK_99ng96sgl8q5mboj0pnlcrjdg] FOREIGN KEY([id])
REFERENCES [dbo].[ip_addresses] ([id])
GO
ALTER TABLE [dbo].[ipv6_addresses] CHECK CONSTRAINT [FK_99ng96sgl8q5mboj0pnlcrjdg]
GO
ALTER TABLE [dbo].[not_valid_ip]  WITH CHECK ADD  CONSTRAINT [FK_mlk5l6njavd84jhobdoepeji6] FOREIGN KEY([id])
REFERENCES [dbo].[ip_addresses] ([id])
GO
ALTER TABLE [dbo].[not_valid_ip] CHECK CONSTRAINT [FK_mlk5l6njavd84jhobdoepeji6]
GO
ALTER TABLE [dbo].[sources_to_addresses]  WITH CHECK ADD  CONSTRAINT [FK_7jlnhjjfxoayexgyqfilbd4vl] FOREIGN KEY([source_id])
REFERENCES [dbo].[sources] ([source_id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[sources_to_addresses] CHECK CONSTRAINT [FK_7jlnhjjfxoayexgyqfilbd4vl]
GO
ALTER TABLE [dbo].[sources_to_addresses]  WITH CHECK ADD  CONSTRAINT [FK_yqfxrjwylog99c3091ws7k0s] FOREIGN KEY([ip_id])
REFERENCES [dbo].[ip_addresses] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[sources_to_addresses] CHECK CONSTRAINT [FK_yqfxrjwylog99c3091ws7k0s]
GO
ALTER TABLE [dbo].[user_roles]  WITH CHECK ADD  CONSTRAINT [FK_5q4rc4fh1on6567qk69uesvyf] FOREIGN KEY([role_id])
REFERENCES [dbo].[roles] ([role_id])
GO
ALTER TABLE [dbo].[user_roles] CHECK CONSTRAINT [FK_5q4rc4fh1on6567qk69uesvyf]
GO
ALTER TABLE [dbo].[user_roles]  WITH CHECK ADD  CONSTRAINT [FK_g1uebn6mqk9qiaw45vnacmyo2] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[user_roles] CHECK CONSTRAINT [FK_g1uebn6mqk9qiaw45vnacmyo2]
GO
