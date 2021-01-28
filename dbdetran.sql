show databases;
drop database dbdetran;
create database dbdetran2;

use dbdetran2;

create table veiculo (
	placa varchar(8) primary key,
	marca varchar(50) not null,
    modelo varchar(100) not null,
    renavam varchar (12) not null unique
);


show tables;

describe veiculo;

insert into veiculo (marca,placa,modelo,renavam)
values ('Volkswagen','TJ87BA3','Golf 2020 GTI','02483254794');

insert into veiculo (marca,placa,modelo,renavam)
values ('Toyota','F23HJ9T','Corola 2018','60348520149');

select*from veiculo;
select*from veiculo where placa = 'TJ87BA3';
select*from veiculo where renavam = '60348520149';

delete from veiculo where placa = 'BYJ48T2';

create table multa (
	idmulta int primary key auto_increment,
    condutor varchar(50),
    localmulta varchar (100) not null,
    dataehora timestamp default current_timestamp,
    codigo varchar (5) not null,
    valor decimal (10,2) not null,
    pontuacao int not null,
    placa varchar(7) not null
    
);
alter table multa add constraint veiculo_multa
foreign key (placa) references veiculo(placa)
on delete no action;

drop table multa;

show tables;

describe multa;

insert into multa (condutor,localmulta,codigo,valor,pontuacao,placa)
values ('Vinicius Bueno','Radial Leste, 1180','71291',130.16,4,'TJ87BA3');

insert into multa (condutor,localmulta,codigo,valor,pontuacao,placa)
values ('Bill Gates','Avenida Paes de Barros, 2050','52400',2934.70,7,'F23HJ9T');

insert into multa (condutor,localmulta,codigo,valor,pontuacao,placa)
values ('José','Avenida Paes de Barros, 3050','53400',2934.70,7,'1234567');

select*from multa;

select * from multa inner join veiculo on multa.placa = veiculo.placa;

select 
M.localmulta,dataehora,pontuacao,valor,
V.marca,modelo,renavam
from multa as M 
inner join veiculo as V
on M.placa = V.placa;

select * from multa where placa = 'TJ87BA3' and codigo = '51001';






