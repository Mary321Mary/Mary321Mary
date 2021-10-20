use [master]
go
drop proc �������������
go
drop proc �����������
go
drop proc �������������
go
drop view ������
go
drop view ����_������
go
drop view ����_�����
go
drop view ������
go
drop view �����
go
drop view ���������
go
drop view ��������
go
drop view ������
go
ALTER TABLE �����_��_������  
	DROP CONSTRAINT CK_����_����������;  
GO
ALTER TABLE ����_���������
	DROP CONSTRAINT UQ_����_���������;  
GO
ALTER TABLE ������������
	DROP CONSTRAINT FK_������������_����������;  
GO
ALTER TABLE ����
	DROP CONSTRAINT FK_����_����������;  
GO
ALTER TABLE �����_��_������
	DROP CONSTRAINT FK_�����_��_������_����������;  
GO
ALTER TABLE �����_��_������
	DROP CONSTRAINT FK_�����_��_������_���������;  
GO
ALTER TABLE �����_��_������
	DROP CONSTRAINT FK_�����_��_������_������;  
GO
ALTER TABLE �������_����������
	DROP CONSTRAINT FK_�������_����������_����_����������;  
GO
ALTER TABLE �������_����������
	DROP CONSTRAINT FK_�������_����������_�����_��_������;  
GO
ALTER TABLE �������_���������
	DROP CONSTRAINT FK_�������_���������_����_���������;  
GO
ALTER TABLE �������_���������
	DROP CONSTRAINT FK_�������_���������_�����_��_������;  
GO
ALTER TABLE ������
	DROP CONSTRAINT FK_������_�����_��_������;  
GO
ALTER TABLE ����������
	DROP CONSTRAINT FK_����������_����_����������;  
GO
ALTER TABLE ����������
	DROP CONSTRAINT FK_����������_������;  
GO
ALTER TABLE ���������
	DROP CONSTRAINT FK_���������_����_���������;  
GO
ALTER TABLE ���������
	DROP CONSTRAINT FK_���������_������;  
GO
DROP TABLE ������������
GO
DROP TABLE ����_����������
GO
DROP TABLE ����_���������
GO
DROP TABLE ����
GO
DROP TABLE ���������
GO
DROP TABLE ����������
GO
DROP TABLE ������
GO
DROP TABLE �����_��_������
GO
DROP TABLE ����������
GO
DROP TABLE ������
GO
DROP TABLE �������_����������
GO
DROP TABLE �������_���������
GO
DROP TABLE ���������
GO
CREATE TABLE ����_����������
(
	ID int PRIMARY KEY IDENTITY
	, ������������ varchar(20) UNIQUE NOT NULL
) 
GO
CREATE TABLE ����_���������
(
	ID int PRIMARY KEY IDENTITY
	, ������������ varchar(20) NOT NULL
) 
GO
CREATE TABLE ����
(
	ID int PRIMARY KEY IDENTITY
	, ��� varchar(255) NOT NULL
	, ID_���� int NOT NULL
	, ����_�������� date NOT NULL
) 
GO
CREATE TABLE ���������
(
	ID int PRIMARY KEY IDENTITY
	, ������������ varchar(20) NOT NULL
) 
GO
CREATE TABLE ����������
(
	ID int PRIMARY KEY IDENTITY
	, ID_����� int NOT NULL
	, ID_������ int NOT NULL
	, ����_���������� date DEFAULT GETDATE() NOT NULL
	, ����� money NOT NULL
) 
GO
CREATE TABLE ������
(
	ID int PRIMARY KEY IDENTITY
	, ������������ varchar(20) NOT NULL
) 
GO
CREATE TABLE �����_��_������
(
	ID int PRIMARY KEY IDENTITY
	, ID_���� int NOT NULL
	, ID_����� int NOT NULL
	, ID_������ int NOT NULL
	, ������ real DEFAULT 1 NOT NULL
	, ����_������ date DEFAULT GETDATE() NOT NULL
	, ����_���������� date
) 
GO
CREATE TABLE ����������
(
	ID int PRIMARY KEY IDENTITY
	, ��� varchar(255) NOT NULL
	, ����� varchar(255) NOT NULL
	, ����_�������� date NOT NULL
) 
GO
CREATE TABLE ������
(
	ID int PRIMARY KEY IDENTITY
	, ID_������ int NOT NULL
	, ���� date DEFAULT GETDATE() NOT NULL
	, ���_���_���� int DEFAULT 0 CHECK(���_���_���� >= 0) NOT NULL
	, ���_����_������� int DEFAULT 0 CHECK(���_����_������� >= 0) NOT NULL
	, ���_����_�� int DEFAULT 0 CHECK(���_����_�� >= 0) NOT NULL
) 
GO
CREATE TABLE �������_����������
(
	ID int PRIMARY KEY IDENTITY
	, ID_����� int NOT NULL
	, ID_������ int NOT NULL
	, ����_���������� date DEFAULT GETDATE() NOT NULL
	, ����_������ date
	, ����� money NOT NULL
) 
GO
CREATE TABLE �������_���������
(
	ID int PRIMARY KEY IDENTITY
	, ID_����� int NOT NULL
	, ID_������ int NOT NULL
	, ����_���������� date DEFAULT GETDATE() NOT NULL
	, ����_������ date
	, ����� money NOT NULL
) 
GO
CREATE TABLE ���������
(
	ID int PRIMARY KEY IDENTITY
	, ID_����� int NOT NULL
	, ID_������ int NOT NULL
	, ����_��������� date DEFAULT GETDATE() NOT NULL
	, ����� money NOT NULL
) 
GO
CREATE TABLE ������������
(
	ID int PRIMARY KEY IDENTITY
	, ����� varchar(20) NOT NULL
	, ������ varchar(20) NOT NULL
	, ���� varchar(20) NOT NULL
	, ID_���� int
) 
GO
ALTER TABLE ����_���������
	ADD CONSTRAINT UQ_����_��������� UNIQUE (������������);
go
ALTER TABLE �����_��_������
	ADD CONSTRAINT CK_����_���������� CHECK (����_���������� > ����_������);
go
alter table ������������
	add constraint FK_������������_����������
		foreign key (ID_����) references ����������
go
alter table ����
	add constraint FK_����_����������
		foreign key (ID_����) references ����������
go
alter table �����_��_������
	add constraint FK_�����_��_������_����������
		foreign key (ID_����) references ����������
go
alter table �����_��_������
	add constraint FK_�����_��_������_���������
		foreign key (ID_�����) references ���������
go
alter table �����_��_������
	add constraint FK_�����_��_������_������
		foreign key (ID_������) references ������
go
alter table �������_����������
	add constraint FK_�������_����������_����_����������
		foreign key (ID_�����) references ����_����������
go
alter table �������_����������
	add constraint FK_�������_����������_�����_��_������
		foreign key (ID_������) references �����_��_������
go
alter table �������_���������
	add constraint FK_�������_���������_����_���������
		foreign key (ID_�����) references ����_���������
go
alter table �������_���������
	add constraint FK_�������_���������_�����_��_������
		foreign key (ID_������) references �����_��_������
go
alter table ������
	add constraint FK_������_�����_��_������
		foreign key (ID_������) references �����_��_������
go
alter table ����������
	add constraint FK_����������_����_����������
		foreign key (ID_�����) references ����_����������
go
alter table ����������
	add constraint FK_����������_������
		foreign key (ID_������) references ������
go
alter table ���������
	add constraint FK_���������_����_���������
		foreign key (ID_�����) references ����_���������
go
alter table ���������
	add constraint FK_���������_������
		foreign key (ID_������) references ������
go
insert into ����_���������� values ('�����'), ('�����������'), ('������')
go
insert into ����_��������� values ('�����'), ('��������')
go
insert into ���������� values ('������ ���� ��������', '��. ������� �.1', '1980-05-11'),
	('������� ������ ���������', '��. �������� �.1', '1980-05-11')
go
insert into ���� values ('������� ������� ��������', 1, '2004-01-31'), ('������ ������ ��������', 1, '2011-05-08'),
	('�������� ���� ���������', 2, '2005-11-08')
go
insert into ��������� values ('��������'), ('���������')
go
insert into ������ values ('����������������'), ('�����������')
go
insert into �����_��_������ values (1, 1, 1, 1, '2000-12-08', '2005-11-08'), (2, 2, 2, 2, '2020-10-18', null), (1, 1, 1, 1, '2005-12-18', null)
go
insert into ������ values (1, '2020-10-01', 22, 0, 0), (2, '2020-11-01', 21, 1, 0), (3, '2020-12-01', 21, 0, 1), (1, '2020-11-01', 20, 1, 1)
go
insert into ���������� values (2, 4, '2020-12-01', 80), (2, 2, '2020-11-01', 100), (1, 2, '2020-01-01', 110), (2, 3, '2020-10-01', 90),
	(1, 1, '2020-10-01', 110)
go
insert into ��������� values (1, 1, '2020-11-01', 100), (2, 1, '2020-11-01', 10), (1, 2, '2020-10-01', 100), (2, 3, '2020-10-01', 10),
	(2, 4, '2020-12-01', 10)
go
insert into �������_���������� values (1, 1, '2020-11-01', '2020-11-09', 100), (1, 2, '2020-11-01', null, 100), (2, 3, '2020-11-08', null, 10), 
	(2, 1, '2020-11-01', null, 10)
go
insert into �������_��������� values (1, 1, '2020-11-01', '2020-11-09', 100), (1, 2, '2020-11-08', null, 100), (2, 3, '2020-11-01', null, 10), 
	(2, 1, '2020-11-01', null, 10)
go


create view ������ as
	select ������.ID as ID, �����_��_������.ID as ID_�����, ���, ����, ���_���_����, ���_����_�������, ���_����_��
	from ������, �����_��_������, ����������
	where ����������.ID = ID_���� and �����_��_������.ID = ID_������
go
create trigger trg������I on ������ instead of insert
as
declare @priem int = (select max(p.ID) from �����_��_������ p, inserted i
	where ID_���� = (select s.ID from ���������� s where s.��� = i.���))
if @priem not in (select ID from �����_��_������) or @priem is null
begin
	raiserror('������� ������ ���������', 16, 2)
	rollback tran
	return
end
insert into ������(ID_������, ����, ���_���_����, ���_����_�������, ���_����_��)
	select @priem, ����, ���_���_����, ���_����_�������, ���_����_�� from inserted i
go
/*
select * from ������
go
insert into ������(ID_�����, ����, ���_���_����, ���_����_�������, ���_����_��) values (1, '2021-01-01', 0, 0, 0)
go															
select * from ������									--'������ ���� ��������'	'�����������'
go
insert into ������(ID_������, ����, ���_���_����, ���_����_�������, ���_����_��)
	select �����_��_������.ID, '2020-10-01', 0, 0, 0
	from ����������, �����_��_������
	where ����������.ID = ID_���� and ��� = '������ ���� ��������'
go
*/
create trigger trg������U on ������ instead of update
as
declare @priem int = (select max(p.ID) from �����_��_������ p, inserted i
	where ID_���� = (select s.ID from ���������� s where s.��� = i.���))
if @priem not in (select ID from �����_��_������) or @priem is null
begin
	raiserror('������� ������ ���������', 16, 2)
	rollback tran
	return
end
update ������ set ID_������ = @priem, ���� = i.����, ���_���_���� = i.���_���_����, ���_����_������� = i.���_����_�������,
	���_����_�� = i.���_����_�� from inserted i
go
create trigger trg������D on ������ instead of delete
as
if exists(select * from ���������� where ID_������ in (select ID from deleted))
begin
	raiserror('������ ������� ������, � ������� ������ ����������', 16, 2)
	rollback tran
	return
end
if exists(select * from ��������� where ID_������ in (select ID from deleted))
begin
	raiserror('������ ������� ������, � ������� ������ ����������', 16, 2)
	rollback tran
end
delete from ������ where ID in (select ID from deleted)
go


create view ����_������ as
	select �������_����������.ID as ID, �����_��_������.ID as ID_�����, ����_����������.������������ as ���, ���, ����_����������, ����_������, �����
	from �������_����������, ����_����������, �����_��_������, ����������
	where ����������.ID = ID_���� and �����_��_������.ID = ID_������ and ����_����������.ID = ID_�����
go
create trigger trg����_������I on ����_������ instead of insert
as
declare @priem int = (select max(p.ID) from �����_��_������ p, inserted i
	where ID_���� = (select s.ID from ���������� s where s.��� = i.���))
if @priem is null
begin
	raiserror('������� ������ ���������', 16, 2)
	rollback tran
	return
end
declare @vid int = (select v.ID from ����_���������� v, inserted i where v.������������ = i.���)
if @vid is null
begin
	raiserror('������� ������ ���', 16, 2)
	rollback tran
	return
end
insert into �������_����������(ID_�����, ID_������, ����_����������, ����_������, �����)
	select @vid, @priem, ����_����������, ����_������, ����� from inserted i
go
create trigger trg����_������U on ����_������ instead of update
as
declare @priem int = (select max(p.ID) from �����_��_������ p, inserted i
	where ID_���� = (select s.ID from ���������� s where s.��� = i.���))
if @priem is null
begin
	raiserror('������� ������ ���������', 16, 2)
	rollback tran
	return
end
declare @vid int = (select v.ID from ����_���������� v, inserted i
	where v.������������ = i.���)
if @vid is null
begin
	raiserror('������� ������ ���', 16, 2)
	rollback tran
	return
end
update �������_���������� set ID_������ = @priem, ID_����� = @vid, ����_���������� = i.����_����������, ����_������ = i.����_������,
	����� = i.����� from �������_���������� t, inserted i where t.ID = i.ID
go
create trigger trg����_������D on ����_������ instead of delete
as
delete from �������_���������� where ID in (select ID from deleted)
go


create view ����_����� as
	select �������_���������.ID as ID, �����_��_������.ID as ID_�����, ����_���������.������������ as ���, ���, ����_����������, ����_������, �����
	from �������_���������, ����_���������, �����_��_������, ����������
	where ����������.ID = ID_���� and �����_��_������.ID = ID_������ and ����_���������.ID = ID_�����
go
create trigger trg����_�����I on ����_����� instead of insert
as
declare @priem int = (select max(p.ID) from �����_��_������ p, inserted i
	where ID_���� = (select s.ID from ���������� s where s.��� = i.���))
if @priem is null
begin
	raiserror('������� ������ ���������', 16, 2)
	rollback tran
	return
end
declare @vid int = (select v.ID from ����_��������� v, inserted i where v.������������ = i.���)
if @vid is null
begin
	raiserror('������� ������ ���', 16, 2)
	rollback tran
	return
end
insert into �������_���������(ID_�����, ID_������, ����_����������, ����_������, �����)
	select @vid, @priem, ����_����������, ����_������, ����� from inserted i
go
create trigger trg����_�����U on ����_����� instead of update
as
declare @priem int = (select max(p.ID) from �����_��_������ p, inserted i
	where ID_���� = (select s.ID from ���������� s where s.��� = i.���))
if @priem is null
begin
	raiserror('������� ������ ���������', 16, 2)
	rollback tran
	return
end
declare @vid int = (select v.ID from ����_��������� v, inserted i where v.������������ = i.���)
if @vid is null
begin
	raiserror('������� ������ ���', 16, 2)
	rollback tran
	return
end
update �������_��������� set ID_������ = @priem, ID_����� = @vid, ����_���������� = i.����_����������, ����_������ = i.����_������,
	����� = i.����� from �������_��������� t, inserted i where t.ID = i.ID
go
create trigger trg����_�����D on ����_����� instead of delete
as
delete from �������_��������� where ID in (select ID from deleted)
go


create view ������ as
	select ����������.ID as ID, ������.ID as ID_����, ����_����������.������������ as ���, ���, ����_����������, �����
	from ����������, ����_����������, ������, �����_��_������, ���������� where ����������.ID = ID_���� and �����_��_������.ID = ID_������ 
		and ID_������ = ������.ID and ����_����������.ID = ID_�����
go
create trigger trg������I on ������ instead of insert
as
declare @tabl int = (select max(t.ID) from ������ t, inserted i
	where ID_������ = (select max(p.ID) from �����_��_������ p where ID_���� = (select s.ID from ���������� s where s.��� = i.���)))
if @tabl is null
begin
	raiserror('������� ������ ���������', 16, 2)
	rollback tran
	return
end
declare @vid int = (select v.ID from ����_���������� v, inserted i where v.������������ = i.���)
if @vid is null
begin
	raiserror('������� ������ ���', 16, 2)
	rollback tran
	return
end
insert into ����������(ID_�����, ID_������, ����_����������, �����)
	select @vid, @tabl, ����_����������, ����� from inserted i
go
create trigger trg������U on ������ instead of update
as
declare @tabl int = (select max(t.ID) from ������ t, inserted i
	where ID_������ = (select max(p.ID) from �����_��_������ p where ID_���� = (select s.ID from ���������� s where s.��� = i.���)))
if @tabl is null
begin
	raiserror('������� ������ ���������', 16, 2)
	rollback tran
	return
end
declare @vid int = (select v.ID from ����_���������� v, inserted i where v.������������ = i.���)
if @vid is null
begin
	raiserror('������� ������ ���', 16, 2)
	rollback tran
	return
end
update ���������� set ID_������ = @tabl, ID_����� = @vid, ����_���������� = i.����_����������, ����� = i.�����
	from ���������� n, inserted i where n.ID = i.ID
go
create trigger trg������D on ������ instead of delete
as
delete from ���������� where ID in (select ID from deleted)
go


create view ����� as
	select ���������.ID as ID, ������.ID as ID_����, ����_���������.������������ as ���, ���, ����_���������, �����
	from ���������, ����_���������, ������, �����_��_������, ���������� where ����������.ID = ID_���� and �����_��_������.ID = ID_������ 
		and ID_������ = ������.ID and ����_���������.ID = ID_�����
go
create trigger trg�����I on ����� instead of insert
as
declare @tabl int = (select max(t.ID) from ������ t, inserted i
	where ID_������ = (select max(p.ID) from �����_��_������ p where ID_���� = (select s.ID from ���������� s where s.��� = i.���)))
if @tabl is null
begin
	raiserror('������� ������ ���������', 16, 2)
	rollback tran
	return
end
declare @vid int = (select v.ID from ����_��������� v, inserted i where v.������������ = i.���)
if @vid is null
begin
	raiserror('������� ������ ���', 16, 2)
	rollback tran
	return
end
insert into ���������(ID_�����, ID_������, ����_���������, �����)
	select @vid, @tabl, ����_���������, ����� from inserted i
go
create trigger trg�����U on ����� instead of update
as
declare @tabl int = (select max(t.ID) from ������ t, inserted i
	where ID_������ = (select max(p.ID) from �����_��_������ p where ID_���� = (select s.ID from ���������� s where s.��� = i.���)))
if @tabl is null
begin
	raiserror('������� ������ ���������', 16, 2)
	rollback tran
	return
end
declare @vid int = (select v.ID from ����_��������� v, inserted i where v.������������ = i.���)
if @vid is null
begin
	raiserror('������� ������ ���', 16, 2)
	rollback tran
	return
end
update ��������� set ID_������ = @tabl, ID_����� = @vid, ����_��������� = i.����_���������, ����� = i.�����
	from ��������� n, inserted i where n.ID = i.ID
go
create trigger trg�����D on ����� instead of delete
as
delete from ��������� where ID in (select ID from deleted)
go


create proc ������������� @id_sotr int, @dataTabelyMonth int, @dataTabelyYaer int
as
declare @FIO varchar(255) = (select ��� from ���������� where ID = @id_sotr)
select @FIO ���, DATENAME(m, ����) �����, ���_���_����, ���_����_�������, ���_����_��, sum(����������.�����) ���������,
	sum(���������.�����) ��������, sum(����������.�����) - sum(���������.�����) �����
from ������, �����_��_������, ����������, ���������
where ID_���� = @id_sotr and �����_��_������.ID = ID_������ and ������.ID = ����������.ID_������ and
	������.ID = ���������.ID_������ and Month(����) = @dataTabelyMonth and Year(����) = @dataTabelyYaer
group by ����, ���_���_����, ���_����_�������, ���_����_��
go


create proc ����������� @dataTabelyMonth int, @dataTabelyYaer int
as
select ������������, sum(����������.�����) ���������, sum(���������.�����) ��������, sum(����������.�����) - sum(���������.�����) �����
from ������, �����_��_������, ������, ����������, ���������
where ������.ID = ID_������ and �����_��_������.ID = ID_������ and ������.ID = ����������.ID_������ and ������.ID = ���������.ID_������ and
	Month(����) = @dataTabelyMonth and Year(����) = @dataTabelyYaer
group by ������������
go


create proc ������������� @year int
as
SELECT S.������������, �����, ���������, ��������, �����
FROM (SELECT DISTINCT ������������, DATENAME(m, ����) �����, Sum(����������.�����) ���������, Sum(���������.�����) ��������,
		sum(����������.�����) - sum(���������.�����) �����,
			0 as sort1,	0 as sort2, 0 as sort3
	FROM (((������ INNER JOIN �����_��_������ ON ������.ID = �����_��_������.ID_������) INNER JOIN ������
		ON �����_��_������.ID = ������.ID_������) INNER JOIN ���������� ON ������.ID = ����������.ID_������)
		INNER JOIN ��������� ON ������.ID = ���������.ID_������
	WHERE Year(����) = @year
	GROUP BY ������������, DATENAME(m, ����), Year(����) * 12 + DatePart(m, ����) - 1
	union all
	select '�� �����', DATENAME(m, ����) AS �����, Sum(����������.�����) ���������, Sum(���������.�����) ��������,
		sum(����������.�����) - sum(���������.�����) �����,
			0, 0, 1
	from (((������ INNER JOIN �����_��_������ ON ������.ID = �����_��_������.ID_������) INNER JOIN ������
		ON �����_��_������.ID = ������.ID_������) INNER JOIN ���������� ON ������.ID = ����������.ID_������)
		INNER JOIN ��������� ON ������.ID = ���������.ID_������
	WHERE Year(����) = @year
	GROUP BY DATENAME(m, ����), Year(����) * 12 + DatePart(m, ����) - 1
	union all
	SELECT '�����', null, Sum(����������.�����) ���������, Sum(���������.�����) ��������,
		sum(����������.�����) - sum(���������.�����) �����,
			1, 1, 0
	FROM (((������ INNER JOIN �����_��_������ ON ������.ID = �����_��_������.ID_����) INNER JOIN ������
		ON �����_��_������.ID = ������.ID_������) INNER JOIN ���������� ON ������.ID = ����������.ID_������)
		INNER JOIN ��������� ON ������.ID = ���������.ID_������
	WHERE Year(����) = @year
) S
ORDER BY sort1, �����, sort2, sort3;
go

insert into ������������(����, �����, ������, ID_����) select 'user', 'user', 'user', 1
go
insert into ������������(����, �����, ������) select 'admin', 'admin', 'admin'
go
insert into ������������(����, �����, ������, ID_����) select 'accountant', 'accountant', 'accountant', 2
go
select * from ������������
go


create view ��������� as
	select ������������.ID, ���, ����, �����, ������
	from ������������ left join ���������� on ����������.ID = ID_����
go
create trigger trg���������I on ��������� instead of insert
as
declare @sotr int = (select s.ID from ���������� s, inserted i where s.��� = i.���)
if @sotr is null
begin
	raiserror('������� ������ ���������', 16, 2)
	rollback tran
	return
end
insert into ������������(����, �����, ������, ID_����)
	select ����, �����, ������, @sotr from inserted i
go
create trigger trg���������U on ��������� instead of update
as
declare @sotr int = (select s.ID from ���������� s, inserted i where s.��� = i.���)
if @sotr is null
begin
	raiserror('������� ������ ���������', 16, 2)
	rollback tran
	return
end
update ������������ set ���� = i.����, ����� = i.�����, ������ = i.������, ID_���� = @sotr
	from inserted i, ������������ p where p.ID = i.ID
go
create trigger trg���������D on ��������� instead of delete
as
delete from ������������ where ID in (select ID from deleted)
go


create view �������� as
	select ����.ID ID, ����.��� ���, ����������.��� ��������, ����.����_�������� ����_��������
	from ����, ���������� where ����������.ID = ID_����
go
create trigger trg��������I on �������� instead of insert
as
declare @sotr int = (select s.ID from ���������� s, inserted i where s.��� = i.���)
if @sotr is null
begin
	raiserror('������� ������ ���������', 16, 2)
	rollback tran
	return
end
insert into ����(���, ID_����, ����_��������)
	select ���, @sotr, ����_�������� from inserted i
go
create trigger trg��������U on �������� instead of update
as
declare @sotr int = (select s.ID from ���������� s, inserted i where s.��� = i.���)
if @sotr is null
begin
	raiserror('������� ������ ���������', 16, 2)
	rollback tran
	return
end
update ���� set ��� = i.���, ����_�������� = i.����_��������, ID_���� = @sotr
	from inserted i, ���� d where d.ID = i.ID
go
create trigger trg��������D on �������� instead of delete
as
delete from ���� where ID in (select ID from deleted)
go


create view ������ as
	select �����_��_������.ID as ID, ���, ���������.������������ as ���������, ������.������������ as �����, ������, ����_������, ����_����������
	from �����_��_������, ����������, ���������, ������ where ����������.ID = ID_���� and ���������.ID = ID_����� and ������.ID = ID_������
go
create trigger trg������I on ������ instead of insert
as
declare @sotr int = (select s.ID from ���������� s, inserted i where s.��� = i.���)
if @sotr is null
begin
	raiserror('������� ������ ���������', 16, 2)
	rollback tran
	return
end
declare @otdel int = (select o.ID from ������ o, inserted i where o.������������ = i.�����)
if @otdel is null
begin
	raiserror('������� ������ �����', 16, 2)
	rollback tran
	return
end
declare @doljn int = (select d.ID from ��������� d, inserted i where d.������������ = i.���������)
if @doljn is null
begin
	raiserror('������� ������� ���������', 16, 2)
	rollback tran
	return
end
insert into �����_��_������(ID_����, ID_�����, ID_������, ������, ����_������, ����_����������)
	select @sotr, @doljn, @otdel, ������, ����_������, ����_���������� from inserted i
go
create trigger trg������U on ������ instead of update
as
declare @sotr int = (select s.ID from ���������� s, inserted i where s.��� = i.���)
if @sotr is null
begin
	raiserror('������� ������ ���������', 16, 2)
	rollback tran
	return
end
declare @otdel int = (select o.ID from ������ o, inserted i where o.������������ = i.�����)
if @otdel is null
begin
	raiserror('������� ������ �����', 16, 2)
	rollback tran
	return
end
declare @doljn int = (select d.ID from ��������� d, inserted i where d.������������ = i.���������)
if @doljn is null
begin
	raiserror('������� ������� ���������', 16, 2)
	rollback tran
	return
end
update �����_��_������ set ID_���� = @sotr, ID_����� = @doljn, ID_������ = @otdel, ������ = i.������, ����_������ = i.����_������,
	����_���������� = i.����_���������� from inserted i, �����_��_������ p where p.ID = i.ID
go
create trigger trg������D on ������ instead of delete
as
if exists(select * from ������ where ID_������ in (select ID from deleted))
begin
	raiserror('������ ������� �����, � �������� ���� ������', 16, 2)
	rollback tran
end
delete from �����_��_������ where ID in (select ID from deleted)
go
;