use [master]
go
drop proc ИтоговыйОтчет
go
drop proc ТабеляМесяц
go
drop proc ТабеляСотрудн
go
drop view Табеля
go
drop view Табл_начисл
go
drop view Табл_удерж
go
drop view Начисл
go
drop view Удерж
go
drop view Пользоват
go
drop view ДетиСотр
go
drop view Приемы
go
ALTER TABLE Прием_на_работу  
	DROP CONSTRAINT CK_Дата_увольнения;  
GO
ALTER TABLE Виды_удержаний
	DROP CONSTRAINT UQ_Виды_удержаний;  
GO
ALTER TABLE Пользователи
	DROP CONSTRAINT FK_Пользователи_Сотрудники;  
GO
ALTER TABLE Дети
	DROP CONSTRAINT FK_Дети_Сотрудники;  
GO
ALTER TABLE Прием_на_работу
	DROP CONSTRAINT FK_Прием_на_работу_Сотрудники;  
GO
ALTER TABLE Прием_на_работу
	DROP CONSTRAINT FK_Прием_на_работу_Должности;  
GO
ALTER TABLE Прием_на_работу
	DROP CONSTRAINT FK_Прием_на_работу_Отделы;  
GO
ALTER TABLE Таблица_начислений
	DROP CONSTRAINT FK_Таблица_начислений_Виды_начислений;  
GO
ALTER TABLE Таблица_начислений
	DROP CONSTRAINT FK_Таблица_начислений_Прием_на_работу;  
GO
ALTER TABLE Таблица_удержаний
	DROP CONSTRAINT FK_Таблица_удержаний_Виды_удержаний;  
GO
ALTER TABLE Таблица_удержаний
	DROP CONSTRAINT FK_Таблица_удержаний_Прием_на_работу;  
GO
ALTER TABLE Табель
	DROP CONSTRAINT FK_Табель_Прием_на_работу;  
GO
ALTER TABLE Начисления
	DROP CONSTRAINT FK_Начисления_Виды_начислений;  
GO
ALTER TABLE Начисления
	DROP CONSTRAINT FK_Начисления_Табель;  
GO
ALTER TABLE Удержания
	DROP CONSTRAINT FK_Удержания_Виды_удержаний;  
GO
ALTER TABLE Удержания
	DROP CONSTRAINT FK_Удержания_Табель;  
GO
DROP TABLE Пользователи
GO
DROP TABLE Виды_начислений
GO
DROP TABLE Виды_удержаний
GO
DROP TABLE Дети
GO
DROP TABLE Должности
GO
DROP TABLE Начисления
GO
DROP TABLE Отделы
GO
DROP TABLE Прием_на_работу
GO
DROP TABLE Сотрудники
GO
DROP TABLE Табель
GO
DROP TABLE Таблица_начислений
GO
DROP TABLE Таблица_удержаний
GO
DROP TABLE Удержания
GO
CREATE TABLE Виды_начислений
(
	ID int PRIMARY KEY IDENTITY
	, Наименование varchar(20) UNIQUE NOT NULL
) 
GO
CREATE TABLE Виды_удержаний
(
	ID int PRIMARY KEY IDENTITY
	, Наименование varchar(20) NOT NULL
) 
GO
CREATE TABLE Дети
(
	ID int PRIMARY KEY IDENTITY
	, ФИО varchar(255) NOT NULL
	, ID_сотр int NOT NULL
	, Дата_рождения date NOT NULL
) 
GO
CREATE TABLE Должности
(
	ID int PRIMARY KEY IDENTITY
	, Наименование varchar(20) NOT NULL
) 
GO
CREATE TABLE Начисления
(
	ID int PRIMARY KEY IDENTITY
	, ID_видаН int NOT NULL
	, ID_табеля int NOT NULL
	, Дата_начисления date DEFAULT GETDATE() NOT NULL
	, Сумма money NOT NULL
) 
GO
CREATE TABLE Отделы
(
	ID int PRIMARY KEY IDENTITY
	, Наименование varchar(20) NOT NULL
) 
GO
CREATE TABLE Прием_на_работу
(
	ID int PRIMARY KEY IDENTITY
	, ID_сотр int NOT NULL
	, ID_должн int NOT NULL
	, ID_отдела int NOT NULL
	, Ставка real DEFAULT 1 NOT NULL
	, Дата_приема date DEFAULT GETDATE() NOT NULL
	, Дата_увольнения date
) 
GO
CREATE TABLE Сотрудники
(
	ID int PRIMARY KEY IDENTITY
	, ФИО varchar(255) NOT NULL
	, Адрес varchar(255) NOT NULL
	, Дата_рождения date NOT NULL
) 
GO
CREATE TABLE Табель
(
	ID int PRIMARY KEY IDENTITY
	, ID_приема int NOT NULL
	, Дата date DEFAULT GETDATE() NOT NULL
	, Кол_раб_дней int DEFAULT 0 CHECK(Кол_раб_дней >= 0) NOT NULL
	, Кол_дней_отпуска int DEFAULT 0 CHECK(Кол_дней_отпуска >= 0) NOT NULL
	, Кол_дней_бл int DEFAULT 0 CHECK(Кол_дней_бл >= 0) NOT NULL
) 
GO
CREATE TABLE Таблица_начислений
(
	ID int PRIMARY KEY IDENTITY
	, ID_видаН int NOT NULL
	, ID_приема int NOT NULL
	, Дата_назначения date DEFAULT GETDATE() NOT NULL
	, Дата_отмены date
	, Сумма money NOT NULL
) 
GO
CREATE TABLE Таблица_удержаний
(
	ID int PRIMARY KEY IDENTITY
	, ID_видаУ int NOT NULL
	, ID_приема int NOT NULL
	, Дата_назначения date DEFAULT GETDATE() NOT NULL
	, Дата_отмены date
	, Сумма money NOT NULL
) 
GO
CREATE TABLE Удержания
(
	ID int PRIMARY KEY IDENTITY
	, ID_видаУ int NOT NULL
	, ID_табеля int NOT NULL
	, Дата_удержания date DEFAULT GETDATE() NOT NULL
	, Сумма money NOT NULL
) 
GO
CREATE TABLE Пользователи
(
	ID int PRIMARY KEY IDENTITY
	, Логин varchar(20) NOT NULL
	, Пароль varchar(20) NOT NULL
	, Роль varchar(20) NOT NULL
	, ID_сотр int
) 
GO
ALTER TABLE Виды_удержаний
	ADD CONSTRAINT UQ_Виды_удержаний UNIQUE (Наименование);
go
ALTER TABLE Прием_на_работу
	ADD CONSTRAINT CK_Дата_увольнения CHECK (Дата_увольнения > Дата_приема);
go
alter table Пользователи
	add constraint FK_Пользователи_Сотрудники
		foreign key (ID_сотр) references Сотрудники
go
alter table Дети
	add constraint FK_Дети_Сотрудники
		foreign key (ID_сотр) references Сотрудники
go
alter table Прием_на_работу
	add constraint FK_Прием_на_работу_Сотрудники
		foreign key (ID_сотр) references Сотрудники
go
alter table Прием_на_работу
	add constraint FK_Прием_на_работу_Должности
		foreign key (ID_должн) references Должности
go
alter table Прием_на_работу
	add constraint FK_Прием_на_работу_Отделы
		foreign key (ID_отдела) references Отделы
go
alter table Таблица_начислений
	add constraint FK_Таблица_начислений_Виды_начислений
		foreign key (ID_видаН) references Виды_начислений
go
alter table Таблица_начислений
	add constraint FK_Таблица_начислений_Прием_на_работу
		foreign key (ID_приема) references Прием_на_работу
go
alter table Таблица_удержаний
	add constraint FK_Таблица_удержаний_Виды_удержаний
		foreign key (ID_видаУ) references Виды_удержаний
go
alter table Таблица_удержаний
	add constraint FK_Таблица_удержаний_Прием_на_работу
		foreign key (ID_приема) references Прием_на_работу
go
alter table Табель
	add constraint FK_Табель_Прием_на_работу
		foreign key (ID_приема) references Прием_на_работу
go
alter table Начисления
	add constraint FK_Начисления_Виды_начислений
		foreign key (ID_видаН) references Виды_начислений
go
alter table Начисления
	add constraint FK_Начисления_Табель
		foreign key (ID_табеля) references Табель
go
alter table Удержания
	add constraint FK_Удержания_Виды_удержаний
		foreign key (ID_видаУ) references Виды_удержаний
go
alter table Удержания
	add constraint FK_Удержания_Табель
		foreign key (ID_табеля) references Табель
go
insert into Виды_начислений values ('Оклад'), ('Контрактные'), ('Ночные')
go
insert into Виды_удержаний values ('Аванс'), ('Алименты')
go
insert into Сотрудники values ('Иванов Иван Иванович', 'ул. Иванова д.1', '1980-05-11'),
	('Сидоров Сергей Сергеевич', 'ул. Сидорова д.1', '1980-05-11')
go
insert into Дети values ('Иванова Наталья Ивановна', 1, '2004-01-31'), ('Иванов Сергей Иванович', 1, '2011-05-08'),
	('Сидорова Кира Сергеевна', 2, '2005-11-08')
go
insert into Должности values ('директор'), ('бухгалтер')
go
insert into Отделы values ('Производственный'), ('Юридический')
go
insert into Прием_на_работу values (1, 1, 1, 1, '2000-12-08', '2005-11-08'), (2, 2, 2, 2, '2020-10-18', null), (1, 1, 1, 1, '2005-12-18', null)
go
insert into Табель values (1, '2020-10-01', 22, 0, 0), (2, '2020-11-01', 21, 1, 0), (3, '2020-12-01', 21, 0, 1), (1, '2020-11-01', 20, 1, 1)
go
insert into Начисления values (2, 4, '2020-12-01', 80), (2, 2, '2020-11-01', 100), (1, 2, '2020-01-01', 110), (2, 3, '2020-10-01', 90),
	(1, 1, '2020-10-01', 110)
go
insert into Удержания values (1, 1, '2020-11-01', 100), (2, 1, '2020-11-01', 10), (1, 2, '2020-10-01', 100), (2, 3, '2020-10-01', 10),
	(2, 4, '2020-12-01', 10)
go
insert into Таблица_начислений values (1, 1, '2020-11-01', '2020-11-09', 100), (1, 2, '2020-11-01', null, 100), (2, 3, '2020-11-08', null, 10), 
	(2, 1, '2020-11-01', null, 10)
go
insert into Таблица_удержаний values (1, 1, '2020-11-01', '2020-11-09', 100), (1, 2, '2020-11-08', null, 100), (2, 3, '2020-11-01', null, 10), 
	(2, 1, '2020-11-01', null, 10)
go


create view Табеля as
	select Табель.ID as ID, Прием_на_работу.ID as ID_прием, ФИО, Дата, Кол_раб_дней, Кол_дней_отпуска, Кол_дней_бл
	from Табель, Прием_на_работу, Сотрудники
	where Сотрудники.ID = ID_сотр and Прием_на_работу.ID = ID_приема
go
create trigger trgТабеляI on Табеля instead of insert
as
declare @priem int = (select max(p.ID) from Прием_на_работу p, inserted i
	where ID_сотр = (select s.ID from Сотрудники s where s.ФИО = i.ФИО))
if @priem not in (select ID from Прием_на_работу) or @priem is null
begin
	raiserror('Неверно указан сотрудник', 16, 2)
	rollback tran
	return
end
insert into Табель(ID_приема, Дата, Кол_раб_дней, Кол_дней_отпуска, Кол_дней_бл)
	select @priem, Дата, Кол_раб_дней, Кол_дней_отпуска, Кол_дней_бл from inserted i
go
/*
select * from Табеля
go
insert into Табеля(ID_прием, Дата, Кол_раб_дней, Кол_дней_отпуска, Кол_дней_бл) values (1, '2021-01-01', 0, 0, 0)
go															
select * from Табеля									--'Иванов Иван Иванович'	'Контрактные'
go
insert into Табель(ID_приема, Дата, Кол_раб_дней, Кол_дней_отпуска, Кол_дней_бл)
	select Прием_на_работу.ID, '2020-10-01', 0, 0, 0
	from Сотрудники, Прием_на_работу
	where Сотрудники.ID = ID_сотр and ФИО = 'Иванов Иван Иванович'
go
*/
create trigger trgТабеляU on Табеля instead of update
as
declare @priem int = (select max(p.ID) from Прием_на_работу p, inserted i
	where ID_сотр = (select s.ID from Сотрудники s where s.ФИО = i.ФИО))
if @priem not in (select ID from Прием_на_работу) or @priem is null
begin
	raiserror('Неверно указан сотрудник', 16, 2)
	rollback tran
	return
end
update Табель set ID_приема = @priem, Дата = i.Дата, Кол_раб_дней = i.Кол_раб_дней, Кол_дней_отпуска = i.Кол_дней_отпуска,
	Кол_дней_бл = i.Кол_дней_бл from inserted i
go
create trigger trgТабеляD on Табеля instead of delete
as
if exists(select * from Начисления where ID_табеля in (select ID from deleted))
begin
	raiserror('Нельзя удалить табель, в который входят начисления', 16, 2)
	rollback tran
	return
end
if exists(select * from Удержания where ID_табеля in (select ID from deleted))
begin
	raiserror('Нельзя удалить табель, в который входят начисления', 16, 2)
	rollback tran
end
delete from Табель where ID in (select ID from deleted)
go


create view Табл_начисл as
	select Таблица_начислений.ID as ID, Прием_на_работу.ID as ID_прием, Виды_начислений.Наименование as вид, ФИО, Дата_назначения, Дата_отмены, Сумма
	from Таблица_начислений, Виды_начислений, Прием_на_работу, Сотрудники
	where Сотрудники.ID = ID_сотр and Прием_на_работу.ID = ID_приема and Виды_начислений.ID = ID_видаН
go
create trigger trgТабл_начислI on Табл_начисл instead of insert
as
declare @priem int = (select max(p.ID) from Прием_на_работу p, inserted i
	where ID_сотр = (select s.ID from Сотрудники s where s.ФИО = i.ФИО))
if @priem is null
begin
	raiserror('Неверно указан сотрудник', 16, 2)
	rollback tran
	return
end
declare @vid int = (select v.ID from Виды_начислений v, inserted i where v.Наименование = i.вид)
if @vid is null
begin
	raiserror('Неверно указан вид', 16, 2)
	rollback tran
	return
end
insert into Таблица_начислений(ID_видаН, ID_приема, Дата_назначения, Дата_отмены, Сумма)
	select @vid, @priem, Дата_назначения, Дата_отмены, Сумма from inserted i
go
create trigger trgТабл_начислU on Табл_начисл instead of update
as
declare @priem int = (select max(p.ID) from Прием_на_работу p, inserted i
	where ID_сотр = (select s.ID from Сотрудники s where s.ФИО = i.ФИО))
if @priem is null
begin
	raiserror('Неверно указан сотрудник', 16, 2)
	rollback tran
	return
end
declare @vid int = (select v.ID from Виды_начислений v, inserted i
	where v.Наименование = i.вид)
if @vid is null
begin
	raiserror('Неверно указан вид', 16, 2)
	rollback tran
	return
end
update Таблица_начислений set ID_приема = @priem, ID_видаН = @vid, Дата_назначения = i.Дата_назначения, Дата_отмены = i.Дата_отмены,
	Сумма = i.Сумма from Таблица_начислений t, inserted i where t.ID = i.ID
go
create trigger trgТабл_начислD on Табл_начисл instead of delete
as
delete from Таблица_начислений where ID in (select ID from deleted)
go


create view Табл_удерж as
	select Таблица_удержаний.ID as ID, Прием_на_работу.ID as ID_прием, Виды_удержаний.Наименование as вид, ФИО, Дата_назначения, Дата_отмены, Сумма
	from Таблица_удержаний, Виды_удержаний, Прием_на_работу, Сотрудники
	where Сотрудники.ID = ID_сотр and Прием_на_работу.ID = ID_приема and Виды_удержаний.ID = ID_видаУ
go
create trigger trgТабл_удержI on Табл_удерж instead of insert
as
declare @priem int = (select max(p.ID) from Прием_на_работу p, inserted i
	where ID_сотр = (select s.ID from Сотрудники s where s.ФИО = i.ФИО))
if @priem is null
begin
	raiserror('Неверно указан сотрудник', 16, 2)
	rollback tran
	return
end
declare @vid int = (select v.ID from Виды_удержаний v, inserted i where v.Наименование = i.вид)
if @vid is null
begin
	raiserror('Неверно указан вид', 16, 2)
	rollback tran
	return
end
insert into Таблица_удержаний(ID_видаУ, ID_приема, Дата_назначения, Дата_отмены, Сумма)
	select @vid, @priem, Дата_назначения, Дата_отмены, Сумма from inserted i
go
create trigger trgТабл_удержU on Табл_удерж instead of update
as
declare @priem int = (select max(p.ID) from Прием_на_работу p, inserted i
	where ID_сотр = (select s.ID from Сотрудники s where s.ФИО = i.ФИО))
if @priem is null
begin
	raiserror('Неверно указан сотрудник', 16, 2)
	rollback tran
	return
end
declare @vid int = (select v.ID from Виды_удержаний v, inserted i where v.Наименование = i.вид)
if @vid is null
begin
	raiserror('Неверно указан вид', 16, 2)
	rollback tran
	return
end
update Таблица_удержаний set ID_приема = @priem, ID_видаУ = @vid, Дата_назначения = i.Дата_назначения, Дата_отмены = i.Дата_отмены,
	Сумма = i.Сумма from Таблица_удержаний t, inserted i where t.ID = i.ID
go
create trigger trgТабл_удержD on Табл_удерж instead of delete
as
delete from Таблица_удержаний where ID in (select ID from deleted)
go


create view Начисл as
	select Начисления.ID as ID, Табель.ID as ID_табл, Виды_начислений.Наименование as вид, ФИО, Дата_начисления, Сумма
	from Начисления, Виды_начислений, Табель, Прием_на_работу, Сотрудники where Сотрудники.ID = ID_сотр and Прием_на_работу.ID = ID_приема 
		and ID_табеля = Табель.ID and Виды_начислений.ID = ID_видаН
go
create trigger trgНачислI on Начисл instead of insert
as
declare @tabl int = (select max(t.ID) from Табель t, inserted i
	where ID_приема = (select max(p.ID) from Прием_на_работу p where ID_сотр = (select s.ID from Сотрудники s where s.ФИО = i.ФИО)))
if @tabl is null
begin
	raiserror('Неверно указан сотрудник', 16, 2)
	rollback tran
	return
end
declare @vid int = (select v.ID from Виды_начислений v, inserted i where v.Наименование = i.вид)
if @vid is null
begin
	raiserror('Неверно указан вид', 16, 2)
	rollback tran
	return
end
insert into Начисления(ID_видаН, ID_табеля, Дата_начисления, Сумма)
	select @vid, @tabl, Дата_начисления, Сумма from inserted i
go
create trigger trgНачислU on Начисл instead of update
as
declare @tabl int = (select max(t.ID) from Табель t, inserted i
	where ID_приема = (select max(p.ID) from Прием_на_работу p where ID_сотр = (select s.ID from Сотрудники s where s.ФИО = i.ФИО)))
if @tabl is null
begin
	raiserror('Неверно указан сотрудник', 16, 2)
	rollback tran
	return
end
declare @vid int = (select v.ID from Виды_начислений v, inserted i where v.Наименование = i.вид)
if @vid is null
begin
	raiserror('Неверно указан вид', 16, 2)
	rollback tran
	return
end
update Начисления set ID_табеля = @tabl, ID_видаН = @vid, Дата_начисления = i.Дата_начисления, Сумма = i.Сумма
	from Начисления n, inserted i where n.ID = i.ID
go
create trigger trgНачислD on Начисл instead of delete
as
delete from Начисления where ID in (select ID from deleted)
go


create view Удерж as
	select Удержания.ID as ID, Табель.ID as ID_табл, Виды_удержаний.Наименование as вид, ФИО, Дата_удержания, Сумма
	from Удержания, Виды_удержаний, Табель, Прием_на_работу, Сотрудники where Сотрудники.ID = ID_сотр and Прием_на_работу.ID = ID_приема 
		and ID_табеля = Табель.ID and Виды_удержаний.ID = ID_видаУ
go
create trigger trgУдержI on Удерж instead of insert
as
declare @tabl int = (select max(t.ID) from Табель t, inserted i
	where ID_приема = (select max(p.ID) from Прием_на_работу p where ID_сотр = (select s.ID from Сотрудники s where s.ФИО = i.ФИО)))
if @tabl is null
begin
	raiserror('Неверно указан сотрудник', 16, 2)
	rollback tran
	return
end
declare @vid int = (select v.ID from Виды_удержаний v, inserted i where v.Наименование = i.вид)
if @vid is null
begin
	raiserror('Неверно указан вид', 16, 2)
	rollback tran
	return
end
insert into Удержания(ID_видаУ, ID_табеля, Дата_удержания, Сумма)
	select @vid, @tabl, Дата_удержания, Сумма from inserted i
go
create trigger trgУдержU on Удерж instead of update
as
declare @tabl int = (select max(t.ID) from Табель t, inserted i
	where ID_приема = (select max(p.ID) from Прием_на_работу p where ID_сотр = (select s.ID from Сотрудники s where s.ФИО = i.ФИО)))
if @tabl is null
begin
	raiserror('Неверно указан сотрудник', 16, 2)
	rollback tran
	return
end
declare @vid int = (select v.ID from Виды_удержаний v, inserted i where v.Наименование = i.вид)
if @vid is null
begin
	raiserror('Неверно указан вид', 16, 2)
	rollback tran
	return
end
update Удержания set ID_табеля = @tabl, ID_видаУ = @vid, Дата_удержания = i.Дата_удержания, Сумма = i.Сумма
	from Удержания n, inserted i where n.ID = i.ID
go
create trigger trgУдержD on Удерж instead of delete
as
delete from Удержания where ID in (select ID from deleted)
go


create proc ТабеляСотрудн @id_sotr int, @dataTabelyMonth int, @dataTabelyYaer int
as
declare @FIO varchar(255) = (select ФИО from Сотрудники where ID = @id_sotr)
select @FIO ФИО, DATENAME(m, Дата) Месяц, Кол_раб_дней, Кол_дней_отпуска, Кол_дней_бл, sum(Начисления.Сумма) Начислено,
	sum(Удержания.Сумма) Удержано, sum(Начисления.Сумма) - sum(Удержания.Сумма) Итого
from Табель, Прием_на_работу, Начисления, Удержания
where ID_сотр = @id_sotr and Прием_на_работу.ID = ID_приема and Табель.ID = Начисления.ID_табеля and
	Табель.ID = Удержания.ID_табеля and Month(Дата) = @dataTabelyMonth and Year(Дата) = @dataTabelyYaer
group by Дата, Кол_раб_дней, Кол_дней_отпуска, Кол_дней_бл
go


create proc ТабеляМесяц @dataTabelyMonth int, @dataTabelyYaer int
as
select Наименование, sum(Начисления.Сумма) Начислено, sum(Удержания.Сумма) Удержано, sum(Начисления.Сумма) - sum(Удержания.Сумма) Итого
from Отделы, Прием_на_работу, Табель, Начисления, Удержания
where Отделы.ID = ID_отдела and Прием_на_работу.ID = ID_приема and Табель.ID = Начисления.ID_табеля and Табель.ID = Удержания.ID_табеля and
	Month(Дата) = @dataTabelyMonth and Year(Дата) = @dataTabelyYaer
group by Наименование
go


create proc ИтоговыйОтчет @year int
as
SELECT S.Наименование, Месяц, Начислено, Удержано, Итого
FROM (SELECT DISTINCT Наименование, DATENAME(m, Дата) Месяц, Sum(Начисления.Сумма) Начислено, Sum(Удержания.Сумма) Удержано,
		sum(Начисления.Сумма) - sum(Удержания.Сумма) Итого,
			0 as sort1,	0 as sort2, 0 as sort3
	FROM (((Отделы INNER JOIN Прием_на_работу ON Отделы.ID = Прием_на_работу.ID_отдела) INNER JOIN Табель
		ON Прием_на_работу.ID = Табель.ID_приема) INNER JOIN Начисления ON Табель.ID = Начисления.ID_табеля)
		INNER JOIN Удержания ON Табель.ID = Удержания.ID_табеля
	WHERE Year(Дата) = @year
	GROUP BY Наименование, DATENAME(m, Дата), Year(Дата) * 12 + DatePart(m, Дата) - 1
	union all
	select 'За месяц', DATENAME(m, Дата) AS Месяц, Sum(Начисления.Сумма) Начислено, Sum(Удержания.Сумма) Удержано,
		sum(Начисления.Сумма) - sum(Удержания.Сумма) Итого,
			0, 0, 1
	from (((Отделы INNER JOIN Прием_на_работу ON Отделы.ID = Прием_на_работу.ID_отдела) INNER JOIN Табель
		ON Прием_на_работу.ID = Табель.ID_приема) INNER JOIN Начисления ON Табель.ID = Начисления.ID_табеля)
		INNER JOIN Удержания ON Табель.ID = Удержания.ID_табеля
	WHERE Year(Дата) = @year
	GROUP BY DATENAME(m, Дата), Year(Дата) * 12 + DatePart(m, Дата) - 1
	union all
	SELECT 'Итого', null, Sum(Начисления.Сумма) Начислено, Sum(Удержания.Сумма) Удержано,
		sum(Начисления.Сумма) - sum(Удержания.Сумма) Итого,
			1, 1, 0
	FROM (((Отделы INNER JOIN Прием_на_работу ON Отделы.ID = Прием_на_работу.ID_сотр) INNER JOIN Табель
		ON Прием_на_работу.ID = Табель.ID_приема) INNER JOIN Начисления ON Табель.ID = Начисления.ID_табеля)
		INNER JOIN Удержания ON Табель.ID = Удержания.ID_табеля
	WHERE Year(Дата) = @year
) S
ORDER BY sort1, Месяц, sort2, sort3;
go

insert into Пользователи(Роль, Логин, Пароль, ID_сотр) select 'user', 'user', 'user', 1
go
insert into Пользователи(Роль, Логин, Пароль) select 'admin', 'admin', 'admin'
go
insert into Пользователи(Роль, Логин, Пароль, ID_сотр) select 'accountant', 'accountant', 'accountant', 2
go
select * from Пользователи
go


create view Пользоват as
	select Пользователи.ID, ФИО, Роль, Логин, Пароль
	from Пользователи left join Сотрудники on Сотрудники.ID = ID_сотр
go
create trigger trgПользоватI on Пользоват instead of insert
as
declare @sotr int = (select s.ID from Сотрудники s, inserted i where s.ФИО = i.ФИО)
if @sotr is null
begin
	raiserror('Неверно указан сотрудник', 16, 2)
	rollback tran
	return
end
insert into Пользователи(Роль, Логин, Пароль, ID_сотр)
	select Роль, Логин, Пароль, @sotr from inserted i
go
create trigger trgПользоватU on Пользоват instead of update
as
declare @sotr int = (select s.ID from Сотрудники s, inserted i where s.ФИО = i.ФИО)
if @sotr is null
begin
	raiserror('Неверно указан сотрудник', 16, 2)
	rollback tran
	return
end
update Пользователи set Роль = i.Роль, Логин = i.Логин, Пароль = i.Пароль, ID_сотр = @sotr
	from inserted i, Пользователи p where p.ID = i.ID
go
create trigger trgПользоватD on Пользоват instead of delete
as
delete from Пользователи where ID in (select ID from deleted)
go


create view ДетиСотр as
	select Дети.ID ID, Дети.ФИО ФИО, Сотрудники.ФИО Родитель, Дети.Дата_рождения Дата_рождения
	from Дети, Сотрудники where Сотрудники.ID = ID_сотр
go
create trigger trgДетиСотрI on ДетиСотр instead of insert
as
declare @sotr int = (select s.ID from Сотрудники s, inserted i where s.ФИО = i.ФИО)
if @sotr is null
begin
	raiserror('Неверно указан сотрудник', 16, 2)
	rollback tran
	return
end
insert into Дети(ФИО, ID_сотр, Дата_рождения)
	select ФИО, @sotr, Дата_рождения from inserted i
go
create trigger trgДетиСотрU on ДетиСотр instead of update
as
declare @sotr int = (select s.ID from Сотрудники s, inserted i where s.ФИО = i.ФИО)
if @sotr is null
begin
	raiserror('Неверно указан сотрудник', 16, 2)
	rollback tran
	return
end
update Дети set ФИО = i.ФИО, Дата_рождения = i.Дата_рождения, ID_сотр = @sotr
	from inserted i, Дети d where d.ID = i.ID
go
create trigger trgДетиСотрD on ДетиСотр instead of delete
as
delete from Дети where ID in (select ID from deleted)
go


create view Приемы as
	select Прием_на_работу.ID as ID, ФИО, Должности.Наименование as Должность, Отделы.Наименование as Отдел, Ставка, Дата_приема, Дата_увольнения
	from Прием_на_работу, Сотрудники, Должности, Отделы where Сотрудники.ID = ID_сотр and Должности.ID = ID_должн and Отделы.ID = ID_отдела
go
create trigger trgПриемыI on Приемы instead of insert
as
declare @sotr int = (select s.ID from Сотрудники s, inserted i where s.ФИО = i.ФИО)
if @sotr is null
begin
	raiserror('Неверно указан сотрудник', 16, 2)
	rollback tran
	return
end
declare @otdel int = (select o.ID from Отделы o, inserted i where o.Наименование = i.Отдел)
if @otdel is null
begin
	raiserror('Неверно указан отдел', 16, 2)
	rollback tran
	return
end
declare @doljn int = (select d.ID from Должности d, inserted i where d.Наименование = i.Должность)
if @doljn is null
begin
	raiserror('Неверно указана должность', 16, 2)
	rollback tran
	return
end
insert into Прием_на_работу(ID_сотр, ID_должн, ID_отдела, Ставка, Дата_приема, Дата_увольнения)
	select @sotr, @doljn, @otdel, Ставка, Дата_приема, Дата_увольнения from inserted i
go
create trigger trgПриемыU on Приемы instead of update
as
declare @sotr int = (select s.ID from Сотрудники s, inserted i where s.ФИО = i.ФИО)
if @sotr is null
begin
	raiserror('Неверно указан сотрудник', 16, 2)
	rollback tran
	return
end
declare @otdel int = (select o.ID from Отделы o, inserted i where o.Наименование = i.Отдел)
if @otdel is null
begin
	raiserror('Неверно указан отдел', 16, 2)
	rollback tran
	return
end
declare @doljn int = (select d.ID from Должности d, inserted i where d.Наименование = i.Должность)
if @doljn is null
begin
	raiserror('Неверно указана должность', 16, 2)
	rollback tran
	return
end
update Прием_на_работу set ID_сотр = @sotr, ID_должн = @doljn, ID_отдела = @otdel, Ставка = i.Ставка, Дата_приема = i.Дата_приема,
	Дата_увольнения = i.Дата_увольнения from inserted i, Прием_на_работу p where p.ID = i.ID
go
create trigger trgПриемыD on Приемы instead of delete
as
if exists(select * from Табель where ID_приема in (select ID from deleted))
begin
	raiserror('Нельзя удалить прием, у которого есть табель', 16, 2)
	rollback tran
end
delete from Прием_на_работу where ID in (select ID from deleted)
go
;