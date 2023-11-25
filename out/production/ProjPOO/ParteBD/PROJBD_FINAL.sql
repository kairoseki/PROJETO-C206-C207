drop database if exists BD;
create database BD;

use BD;

create table Locadora(
	idLocadora int auto_increment primary key
);

#1:N
create table Jogos(
	idJogos int auto_increment primary key,
    NomeJ varchar(50) not null,
    GeneroJ varchar(50) not null,
    DataJ int not null,
    StatusJ int not null,
    idLocadora int,
    constraint fksetor
		foreign key (idLocadora)
        references Locadora(idLocadora)
        on update cascade
        on delete cascade
);

#1:N
create table Filmes(
	idFilmes int auto_increment primary key,
    NomeF varchar(50) not null,
    GeneroF varchar(50) not null,
    DataF int not null,
    StatusF int not null,
    idLocadora int,
    constraint fkLocadora1
		foreign key (idLocadora)
        references Locadora(idLocadora)
        on update cascade
        on delete cascade
);

#N:M
create table Cliente(
	CPF int,
    primary key (cpf)
);

create table Locadora_has_Cliente(
	Locadora_idLocadora int not null,
    Cliente_CPF int not null,
    primary key(Locadora_idLocadora, Cliente_CPF),
    constraint fk_Locadora_has_Cliente
		foreign key(Locadora_idLocadora)
        references Locadora (idLocadora)
        on update cascade
        on delete cascade,
	constraint fk_Locadora_has_Cliente
		foreign key(Cliente_CPF)
        references Cliente(CPF)
        on update cascade
        on delete cascade
);

#1:1
create table Cadastro (
	idCadastro int auto_increment primary key
);

insert into Locadora() values(default),
(default);

insert into Cliente() values(123456789),
(456123789);

insert into cadastro() values(default);

select * from filmes;
select * from Jogos;