-- dropando o banco...
drop database if exists odonto;
-- criando o banco...
create database odonto;
-- usando o banco...
use odonto;

-- criando a tabela usuario...
create table tb_usuario(
	codigo_usuario int primary key auto_increment,
	nome_usuario varchar(50) not null,
	login_usuario varchar(20) not null,
	senha_usuario varchar(20) not null,
	perfil_usuario varchar(20) not null,
	rg_usuario varchar(20),
	cpf_usuario varchar(14) not null,
	data_nascimento_usuario date,
	sexo_usuario varchar(1) not null);

-- inserir usuario
insert into tb_usuario values(null,'josue pedro','josue1912','senha','admin','000000000','00000000000','1982-12-19','m');

	
/*	
create table endereco(idendereco int primary key auto_increment,
					  bairro varchar (35),
					  cidade varchar (35),
					  idpessoa int unique, foreign key(idpessoa) references pessoa(idpessoa));
*/
	
