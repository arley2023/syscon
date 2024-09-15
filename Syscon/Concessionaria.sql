create database Concessionaria;
use Concessionaria;
create table Consultor (
	con_id int(4) unique not null primary key,
    con_nome varchar(30) not null
);
create table Cliente (
	cli_id int(4) unique not null primary key,
    cli_nome varchar(30) not null,
    cli_whats varchar(16) not null
);
create table Veiculo (
	vei_id int(4) unique not null primary key,
    vei_nome varchar(30) not null,
    vei_ano int(2) not null,
    vei_mod int(2) not null,
    vei_marca varchar(30) not null,
    vei_condicao varchar(8) not null,
    vei_placa varchar(8) not null,
	vei_km int(8) not null,
    vei_combustivel varchar(15) not null,
    vei_cambio varchar(15) not null,
    vei_carroc varchar(15) not null,
    vei_cor varchar(15) not null,
	vei_descricao varchar(250) not null
#   vei_gal longblob
);
create table Acessorios (
	ace_id int(4) unique not null primary key,
    ace_nome varchar(30) not null
);
create table ligacao (
		ligacao_id bigint(12) not null primary key
	# ligacao_id = con_id + cli_id + vei_id
);
create table veiace (
	veiace_id int(8) not null primary key
# veiace_id = vei_id + ace_id
);
insert into Consultor (con_id,con_nome) values 
	(1111,'jose durval'),
    (2222,'maria do socorro'),
    (3333,'paulo sanches'),
    (4444,'clara antunes');
insert into Cliente (cli_id,cli_nome,cli_whats) values 
	(9901,'carla maria','(85) 9.8947-8473'),
    (9902,'jose abreu lima','(85) 9.4547-8473'),
	(9906,'pedro felipe','(85) 9.8057-8783'),
    (9905,'rogerio mateus','(85) 9.8447-8783'),
    (9903,'edumondo dants','(85) 9.8457-8783'),
    (9904,'marcio garci','(85) 9.8347-8876');
insert into Veiculo (vei_id,vei_nome,vei_ano,vei_mod,vei_marca,
	vei_condicao,vei_placa,vei_km,vei_combustivel,vei_cambio,
	vei_carroc,vei_cor,vei_descricao) values 
	(8801,'Saveiro',2020,2021,'volkswagen',
    'usado','pns-9374',120.000,'flex','maunual',
    'pick-up','azul','pickup nova e revisada'),
    (8802,'Uno',2019,2020,'fiat',
    'usado','kso-2586',180.000,'gnv','maunual',
    'passeio','verde','muito economico'),
    (8803,'corsa',2019,2020,'gm',
    'usado','ddo-2786',90.000,'flex','automatico',
    'trabalho','branco','top'),
    (8804,'ford k',2019,2020,'ford',
    'zero','kso-2544',127.000,'flex','automatico',
    'lazer','bege','ainda anda');
insert into Acessorios (ace_id,ace_nome) values 
	(1001,'alarme'),
    (2002,'airbags'),
    (3003,'som'),
    (4004,'gps');
insert into ligacao (ligacao_id) values (111199018801),(111199028802),(111199018804);
insert into veiace (veiace_id) values (88022002),(88012002),(88032002),(88011001),(88021001);
select * from Consultor;
select * from Cliente;
select * from Veiculo;
select * from Acessorios;
select * from ligacao;
select * from veiace;
