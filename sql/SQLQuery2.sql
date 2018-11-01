use AulaJava

creATE TABLE Contato(
ID int not null,
Nome varchar(25) not null,
Telefone varchar(255),
constraint PK_Contato primary key (ID)
);

create table Funcionario(
Matricula varchar(20) not null,
Nome varchar(80) not null,
DtNasc date not null,
constraint PK_Funcionario primary key (Matricula)
);

create table Dependente(
MatriculaFunc varchar(20) not null,
Nome varchar(80) not null,
codigoDep varchar(15) not null,
constraint PK_Dependente primary key (codigoDep),
constraint FK_Dependente foreign key (MatriculaFunc) references Funcionario(Matricula)
);

create table Curso(
codigo varchar(20) not null,
ano date not null,
Nome varchar(40) not null,
constraint PK_Curso primary key (codigo)
);

create table FuncCurso(
matriculaFunc varchar(20) not null,
codigoCurso varchar(20),
constraint FK_FuncMat foreign key (matriculaFunc) references Funcionario(Matricula),
constraint FK_CursoCod foreign key (codigoCurso) references Curso(codigo)
);



