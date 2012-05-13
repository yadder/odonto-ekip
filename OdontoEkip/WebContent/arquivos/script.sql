-- dropando o banco...
drop database if exists odonto;
-- criando o banco...
create database if not exists odonto;
-- usando o banco...
use odonto;

-- criando a tabela disponibilidade...
create table tb_disponibilidade(
	codigo_disponibilidade int primary key auto_increment,
	dia_semana varchar(20) not null,
	hora_inicio time not null,
	hora_fim time not null
) TYPE=INNODB;
	
-- criando a tabela consulta...
create table tb_consulta(
	codigo_consulta int primary key auto_increment,
	data_consulta date not null,
	status_consulta varchar(20)
) TYPE=INNODB;

-- criando a tabela pagamento...
create table tb_pagamento(
	codigo_pagamento int primary key auto_increment,
	numero_parcela int not null,
	valor_parcela double not null,
	status_pagamento varchar(20) not null
) TYPE=INNODB;

-- criando a tabela elemento...
create table tb_elemento(
	codigo_elemento int primary key auto_increment,
	nome_elemento varchar(2) not null unique
) TYPE=INNODB;

-- criando a tabela prescricao...
create table tb_prescricao(
	codigo_prescricao int primary key auto_increment,
	observacao varchar(255) not null
) TYPE=INNODB;

-- criando a tabela convenio...
create table tb_convenio(
	codigo_convenio int primary key auto_increment,
	nome_convenio varchar(50) not null unique
) TYPE=INNODB;

-- criando a tabela face...
create table tb_face(
	codigo_face int primary key auto_increment,
	nome_face varchar(30) not null unique
) TYPE=INNODB;

-- criando a tabela procedimento...
create table tb_procedimento(
	codigo_procedimento int primary key auto_increment,
	descricao_procedimento varchar(50) not null unique,
	valor_procedimento double not null,
	codigo_convenio int not null,
		foreign key(codigo_convenio) references tb_convenio(codigo_convenio)
) TYPE=INNODB;

-- criando a tabela fornecedor...
create table tb_fornecedor(
	codigo_fornecedor int primary key auto_increment,
	site_fornecedor varchar(50),
	cnpj_fornecedor varchar(18) not null unique,
	nome_fornecedor varchar(50) not null,
	nome_vendedor varchar(50) not null,
	email_vendedor varchar(50) not null,
	logradouro_fornecedor varchar(100),
	numero_logradouro_fornecedor int,
	complemento_logradouro_fornecedor varchar(50),
	bairro_fornecedor varchar(30),
	cidade_fornecedor varchar(30),
	estado_fornecedor varchar(30), 
	cep_fornecedor varchar(10)
) TYPE=INNODB;

-- criando a tabela telefone_fornecedor...
create table tb_telefone_fornecedor(
	codigo_telefone int primary key auto_increment,
	ddd_telefone_fornecedor varchar(2) not null,
	telefone_fornecedor varchar(9) not null unique,
	codigo_fornecedor int not null,
		foreign key (codigo_fornecedor) references tb_fornecedor(codigo_fornecedor)
) TYPE=INNODB;

-- criando a tabela usuario...
create table tb_usuario(
	codigo_usuario int primary key auto_increment,
	nome_usuario varchar(50) not null,
	login_usuario varchar(20) not null unique,
	senha_usuario varchar(20) not null,
	perfil_usuario varchar(20) not null,
	rg_usuario varchar(20),
	cpf_usuario varchar(14) not null unique,
	data_nascimento_usuario date,
	sexo_usuario varchar(1) not null
) TYPE=INNODB;


-- criando a tabela dentista...
create table tb_dentista(
	cro_dentista varchar(30) not null,
	codigo_dentista int not null,
		foreign key (codigo_dentista) references tb_usuario(codigo_usuario)
) TYPE=INNODB;

-- criando a tabela paciente...
create table tb_paciente(
	responsavel_paciente varchar(50),
	logradouro_paciente varchar(100),
	numero_logradouro_paciente int,
	complemento_logradouro_paciente varchar(50),
	bairro_paciente varchar(30),
	cidade_paciente varchar(30),
	estado_paciente varchar(30), 
	cep_paciente varchar(10),
	codigo_convenio int not null,
		foreign key (codigo_convenio) references tb_convenio(codigo_convenio),
	codigo_paciente int not null,
		foreign key (codigo_paciente) references tb_usuario(codigo_usuario)
) TYPE=INNODB;

-- criando a tabela telefone_paciente...
create table tb_telefone_paciente(
	codigo_telefone int primary key auto_increment,
	ddd_telefone_paciente varchar(2) not null,
	telefone_paciente varchar(9) not null unique,
	codigo_paciente int not null,
		foreign key (codigo_paciente) references tb_paciente(codigo_paciente)
) TYPE=INNODB;

-- criando a tabela odontograma...
create table tb_odontograma(
	codigo_odontograma int primary key auto_increment,
	valor_odontograma double not null,
	data_odontograma date not null,
	status_odontograma varchar(20) not null,
	codigo_paciente int not null,
	codigo_dentista int not null,
		foreign key (codigo_paciente) references tb_paciente(codigo_paciente),
		foreign key (codigo_dentista) references tb_dentista(codigo_dentista)
) TYPE=INNODB;

-- criando a tabela odontograma_procedimento...
create table tb_odontograma_procedimento(
	codigo_odontograma_procedimeto int primary key auto_increment,
	status_pagamento varchar(20) not null,
	data_pagamento date,
	codigo_odontograma int not null,
	codigo_procedimento int not null,
		foreign key (codigo_odontograma) references tb_odontograma(codigo_odontograma),
		foreign key (codigo_procedimento) references tb_procedimento(codigo_procedimento)		
) TYPE=INNODB;

-- criando a tabela inquerito_odontologico...
create table tb_inquerito_odontologico(
	codigo_inquerito_odontologico int primary key auto_increment,
	tratamento_medico varchar(1) not null,
	usando_medicacao varchar(1) not null,
	alergia varchar(1) not null,
	anemia varchar(1) not null,
	fumante varchar(1) not null,
	hepatite varchar(1) not null,
	alcoolista varchar(1) not null,
	sifilis varchar(1) not null,
	herpes_afta varchar(1) not null,
	hiv varchar(1) not null,
	gravidez varchar(1) not null,
	tuberculose varchar(1) not null,
	diabetes varchar(1) not null,
	asma varchar(1) not null,
	cardiaco varchar(1) not null,
	data_ultimo_atendimento date not null,
	concluiu_tratamento varchar(1) not null,
	experiencia_negativa_tratamento varchar(1) not null,
	roer_unhas varchar(1) not null,
	respirar_pela_boca varchar(1) not null,
	morder_objetos varchar(1) not null,
	ranger_os_dentes varchar(1) not null,
	chupar_dedo_chupeta varchar(1) not null,
	outros varchar(255),
	fio_fita_dental varchar(1) not null,
	palito varchar(1) not null,
	unitufo_bitufo varchar(7) not null,
	tipo_escova varchar(5) not null,
	interdental varchar(1) not null,
	creme_dental varchar(1) not null,
	ingere_alimentos_entre_refeicoes varchar(1) not null,
	codigo_paciente int not null,
		foreign key (codigo_paciente) references tb_paciente(codigo_paciente)
) TYPE=INNODB;