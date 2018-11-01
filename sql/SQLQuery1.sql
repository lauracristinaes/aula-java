
go
USE AulaJava

create table JavaFTI(
id int not null,
nome varchar(50) not null,
dtNasc datetime,
idade int,
constraint UC_JavaFTI unique(id, nome)
)

alter table JavaFTI drop constraint UC_JavaFTI

alter table JavaFTI add constraint UC_JavaFTI unique(id, nome)

alter table JavaFTI add constraint CHK_JavaFTI check (idade>=15 and dtNasc>= '01-01-2000')

alter table JavaFTI add turma varchar(10)

alter table JavaFTI add constraint DC_JavaFTI default 'JAVA01' for turma

alter table JavaFTI drop constraint CHK_JavaFTI

alter table JavaFTI add idTeste int identity(1,1)

insert into JavaFTI (id, nome, dtNasc, idade) values ('1','Laura', '26-12-1992', '25')



select * from JavaFTI