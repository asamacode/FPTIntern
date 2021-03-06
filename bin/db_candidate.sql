USE [master]
GO
/****** Object:  Database [db_candidate]    Script Date: 03/20/2020 10:45:21 ******/
CREATE DATABASE [db_candidate] ON  PRIMARY 
( NAME = N'db_candidate', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10.SQLEXPRESS\MSSQL\DATA\db_candidate.mdf' , SIZE = 2304KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'db_candidate_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10.SQLEXPRESS\MSSQL\DATA\db_candidate_log.LDF' , SIZE = 504KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [db_candidate] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [db_candidate].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [db_candidate] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [db_candidate] SET ANSI_NULLS OFF
GO
ALTER DATABASE [db_candidate] SET ANSI_PADDING OFF
GO
ALTER DATABASE [db_candidate] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [db_candidate] SET ARITHABORT OFF
GO
ALTER DATABASE [db_candidate] SET AUTO_CLOSE ON
GO
ALTER DATABASE [db_candidate] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [db_candidate] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [db_candidate] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [db_candidate] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [db_candidate] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [db_candidate] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [db_candidate] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [db_candidate] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [db_candidate] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [db_candidate] SET  ENABLE_BROKER
GO
ALTER DATABASE [db_candidate] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [db_candidate] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [db_candidate] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [db_candidate] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [db_candidate] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [db_candidate] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [db_candidate] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [db_candidate] SET  READ_WRITE
GO
ALTER DATABASE [db_candidate] SET RECOVERY SIMPLE
GO
ALTER DATABASE [db_candidate] SET  MULTI_USER
GO
ALTER DATABASE [db_candidate] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [db_candidate] SET DB_CHAINING OFF
GO
USE [db_candidate]
GO
/****** Object:  Table [dbo].[candidates]    Script Date: 03/20/2020 10:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[candidates](
	[idCandidates] [int] IDENTITY(1,1) NOT NULL,
	[fullName] [varchar](80) NULL,
	[birthday] [varchar](45) NULL,
	[phone] [varchar](45) NULL,
	[email] [varchar](45) NULL,
	[candidateType] [int] NULL,
	[expInYear] [int] NULL,
	[proSkill] [varchar](45) NULL,
	[graduationDate] [varchar](45) NULL,
	[graduationRank] [varchar](45) NULL,
	[education] [varchar](45) NULL,
	[major] [varchar](45) NULL,
	[universityName] [varchar](45) NULL,
	[semester] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idCandidates] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[certificated]    Script Date: 03/20/2020 10:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[certificated](
	[idCertificated] [int] IDENTITY(1,1) NOT NULL,
	[certificatedName] [nvarchar](50) NULL,
	[certificatedRank] [nvarchar](50) NULL,
	[certificatedDate] [nchar](10) NULL,
	[idCandidates] [int] NOT NULL,
 CONSTRAINT [PK_certificated] PRIMARY KEY CLUSTERED 
(
	[idCertificated] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Default [DF__candidate__fullN__014935CB]    Script Date: 03/20/2020 10:45:22 ******/
ALTER TABLE [dbo].[candidates] ADD  DEFAULT (NULL) FOR [fullName]
GO
/****** Object:  Default [DF__candidate__birth__023D5A04]    Script Date: 03/20/2020 10:45:22 ******/
ALTER TABLE [dbo].[candidates] ADD  DEFAULT (NULL) FOR [birthday]
GO
/****** Object:  Default [DF__candidate__phone__03317E3D]    Script Date: 03/20/2020 10:45:22 ******/
ALTER TABLE [dbo].[candidates] ADD  DEFAULT (NULL) FOR [phone]
GO
/****** Object:  Default [DF__candidate__email__0425A276]    Script Date: 03/20/2020 10:45:22 ******/
ALTER TABLE [dbo].[candidates] ADD  DEFAULT (NULL) FOR [email]
GO
/****** Object:  Default [DF__candidate__candi__0519C6AF]    Script Date: 03/20/2020 10:45:22 ******/
ALTER TABLE [dbo].[candidates] ADD  DEFAULT (NULL) FOR [candidateType]
GO
/****** Object:  Default [DF__candidate__expIn__060DEAE8]    Script Date: 03/20/2020 10:45:22 ******/
ALTER TABLE [dbo].[candidates] ADD  DEFAULT (NULL) FOR [expInYear]
GO
/****** Object:  Default [DF__candidate__proSk__07020F21]    Script Date: 03/20/2020 10:45:22 ******/
ALTER TABLE [dbo].[candidates] ADD  DEFAULT (NULL) FOR [proSkill]
GO
/****** Object:  Default [DF__candidate__gradu__07F6335A]    Script Date: 03/20/2020 10:45:22 ******/
ALTER TABLE [dbo].[candidates] ADD  DEFAULT (NULL) FOR [graduationDate]
GO
/****** Object:  Default [DF__candidate__gradu__08EA5793]    Script Date: 03/20/2020 10:45:22 ******/
ALTER TABLE [dbo].[candidates] ADD  DEFAULT (NULL) FOR [graduationRank]
GO
/****** Object:  Default [DF__candidate__educa__09DE7BCC]    Script Date: 03/20/2020 10:45:22 ******/
ALTER TABLE [dbo].[candidates] ADD  DEFAULT (NULL) FOR [education]
GO
/****** Object:  Default [DF__candidate__major__0AD2A005]    Script Date: 03/20/2020 10:45:22 ******/
ALTER TABLE [dbo].[candidates] ADD  DEFAULT (NULL) FOR [major]
GO
/****** Object:  Default [DF__candidate__unive__0BC6C43E]    Script Date: 03/20/2020 10:45:22 ******/
ALTER TABLE [dbo].[candidates] ADD  DEFAULT (NULL) FOR [universityName]
GO
/****** Object:  Default [DF__candidate__semes__0CBAE877]    Script Date: 03/20/2020 10:45:22 ******/
ALTER TABLE [dbo].[candidates] ADD  DEFAULT (NULL) FOR [semester]
GO
/****** Object:  ForeignKey [FK_certificated_candiadate]    Script Date: 03/20/2020 10:45:22 ******/
ALTER TABLE [dbo].[certificated]  WITH CHECK ADD  CONSTRAINT [FK_certificated_candiadate] FOREIGN KEY([idCandidates])
REFERENCES [dbo].[candidates] ([idCandidates])
GO
ALTER TABLE [dbo].[certificated] CHECK CONSTRAINT [FK_certificated_candiadate]
GO
