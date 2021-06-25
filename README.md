# WebService-PetsCare
RESTful WebService para gerenciamento de serviços.
Sistema desenvolvido em Java com auxilio do Spring Framework.
Uso de base de dados SQL para registrar os serviços.


Passo a passo para criação das tabelas:


CREATE TABLE cuidadores(
id BIGINT NOT NULL,
nome VARCHAR(255) NOT NULL,
cpf VARCHAR(255) NOT NULL,
telefone VARCHAR(255) NOT NULL,
regiao VARCHAR(255) NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE servicos(
idServico BIGINT NOT NULL,
status VARCHAR(255) NOT NULL,
data VARCHAR(255) NOT NULL,
valor VARCHAR(255) NOT NULL,
nota BIGINT NOT NULL,
PRIMARY KEY(idServico)
);
