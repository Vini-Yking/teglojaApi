CREATE SCHEMA if not exists tegloja ;
/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases V10.0.2                    */
/* Target DBMS:           PostgreSQL 9                                    */
/* Project file:          ERteglojaAPI.dez                                */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database creation script                        */
/* Created on:            2022-06-06 12:17                                */
/* ---------------------------------------------------------------------- */


/* ---------------------------------------------------------------------- */
/* Add tables                                                             */
/* ---------------------------------------------------------------------- */

/* ---------------------------------------------------------------------- */
/* Add table "tegloja.categoria"                                          */
/* ---------------------------------------------------------------------- */

CREATE TABLE tegloja.categoria (
    id_categoria SERIAL  NOT NULL,
    nome_categoria CHARACTER VARYING(100)  NOT NULL,
    CONSTRAINT PK_categoria PRIMARY KEY (id_categoria)
);

/* ---------------------------------------------------------------------- */
/* Add table "tegloja.produto"                                            */
/* ---------------------------------------------------------------------- */

CREATE TABLE tegloja.produto (
    id_produto SERIAL  NOT NULL,
    nome_produto CHARACTER VARYING(100),
    valor_unitario DOUBLE PRECISION,
    quantidade_estoque INTEGER,
    data_ultima_alteracao TIMESTAMP,
    id_categoria INTEGER  NOT NULL,
    CONSTRAINT PK_produto PRIMARY KEY (id_produto)
);

/* ---------------------------------------------------------------------- */
/* Add table "tegloja.cliente"                                            */
/* ---------------------------------------------------------------------- */

CREATE TABLE tegloja.cliente (
    id_cliente SERIAL  NOT NULL,
    cpf CHARACTER VARYING(11)  NOT NULL,
    nome_cliente CHARACTER VARYING(100)  NOT NULL,
    email CHARACTER VARYING(100)  NOT NULL,
    cep CHARACTER VARYING(9)  NOT NULL,
    CONSTRAINT PK_cliente PRIMARY KEY (id_cliente)
);

/* ---------------------------------------------------------------------- */
/* Add table "tegloja.pedido"                                             */
/* ---------------------------------------------------------------------- */

CREATE TABLE tegloja.pedido (
    id_pedido SERIAL  NOT NULL,
    status_pedido CHARACTER(40)  NOT NULL,
    data_compra TIMESTAMP,
    data_entrega TIMESTAMP,
    valor_total DOUBLE PRECISION,
    tipo_pagamento CHARACTER VARYING(40),
    id_cliente INTEGER  NOT NULL,
    CONSTRAINT PK_pedido PRIMARY KEY (id_pedido)
);

/* ---------------------------------------------------------------------- */
/* Add table "tegloja.pedido_item"                                        */
/* ---------------------------------------------------------------------- */

CREATE TABLE tegloja.pedido_item (
    id_item SERIAL  NOT NULL,
    id_produto INTEGER  NOT NULL,
    quantidade_produto INTEGER  NOT NULL,
    valor_desconto DOUBLE PRECISION,
    valor_venda DOUBLE PRECISION,
    id_pedido INTEGER  NOT NULL,
    CONSTRAINT PK_pedido_itens PRIMARY KEY (id_item)
);

/* ---------------------------------------------------------------------- */
/* Add table "tegloja.endereco"                                           */
/* ---------------------------------------------------------------------- */

CREATE TABLE tegloja.endereco (
    id_endereco SERIAL  NOT NULL,
    cep CHARACTER VARYING(9)  NOT NULL,
    logradouro CHARACTER VARYING(100),
    complemento CHARACTER VARYING(100),
    bairro CHARACTER VARYING(100),
    localidade CHARACTER VARYING(100),
    uf CHARACTER VARYING(100),
    id_cliente INTEGER  NOT NULL,
    CONSTRAINT PK_endereco PRIMARY KEY (id_endereco)
);

/* ---------------------------------------------------------------------- */
/* Add table "tegloja.foto"                                               */
/* ---------------------------------------------------------------------- */

CREATE TABLE tegloja.foto (
    id_foto SERIAL  NOT NULL,
    tipo CHARACTER VARYING(40),
    nome CHARACTER VARYING(100),
    metadados_foto BYTEA,
    id_produto INTEGER  NOT NULL,
    CONSTRAINT PK_foto PRIMARY KEY (id_foto)
);

/* ---------------------------------------------------------------------- */
/* Add foreign key constraints                                            */
/* ---------------------------------------------------------------------- */

ALTER TABLE tegloja.produto ADD CONSTRAINT categoria_produto 
    FOREIGN KEY (id_categoria) REFERENCES tegloja.categoria (id_categoria);

ALTER TABLE tegloja.pedido ADD CONSTRAINT cliente_pedido 
    FOREIGN KEY (id_cliente) REFERENCES tegloja.cliente (id_cliente);

ALTER TABLE tegloja.pedido_item ADD CONSTRAINT produto_pedido_itens 
    FOREIGN KEY (id_produto) REFERENCES tegloja.produto (id_produto);

ALTER TABLE tegloja.pedido_item ADD CONSTRAINT pedido_pedido_itens 
    FOREIGN KEY (id_pedido) REFERENCES tegloja.pedido (id_pedido);

ALTER TABLE tegloja.endereco ADD CONSTRAINT cliente_endereco 
    FOREIGN KEY (id_cliente) REFERENCES tegloja.cliente (id_cliente);

ALTER TABLE tegloja.foto ADD CONSTRAINT produto_foto 
    FOREIGN KEY (id_produto) REFERENCES tegloja.produto (id_produto);

/* ---------------------------------------------------------------------- */
/* INSERTS                                                                */
/* ---------------------------------------------------------------------- */

insert into api.categoria (nome_categoria) 
values 
('Utilitário'),
('Material de construção'),
('Ferramentas');

insert into api.produto (nome_produto, quantidade_estoque, valor_unit, id_categoria)
values 
('Arruela', 1000, 2.42, 1),
('Porca', 1000, 0.34, 1),
('Bucha', 1000, 1.79, 1),
('Barra rosqueada', 25, 4.44, 3),
('Parafuso', 1000, 2.90, 1),
('Chave de Fenda', 50, 12.90, 3),
('Broca', 200, 8.28, 3);

insert into api.endereco (bairro, cep, localidade, logradouro, uf)
values
('Lagoa', '27925400', 'Macaé', 'Avenida Vereador Roberto Garrido de Souza', 'RJ'),
('Alto da Serra', '25635030', 'Petrópolis', 'Rua Fernando Fernandes Lima', 'RJ'),
('Várzea', '25953000', 'Teresópolis', 'Avenida Lúcio Meira', 'RJ'),
('Jardim Meudon', '25954020', 'Teresópolis', 'Rua Goitacases', 'RJ'),
('São Pedro', '25955230', 'Teresópolis', 'Rua Pedro Strucchi', 'RJ'),
('São Pedro', '25956250', 'Teresópolis', 'Rua Otto Alencar', 'RJ');

insert into api.cliente (cep, cpf, email, nome_cliente, endereco_numero, id_endereco)
values
('27925400', '80501507043', 'thiago@serratec.com', 'Thiago Paes', 222, 1),
('25635030', '30632596082', 'vinicios@serratec.com', 'Marcos Vinicios', 111, 2),
('25953000', '06773117020', 'hitalo@serratec.com', 'Hítalo Taverna', 333, 3),
('25954020', '38890628065', 'silvia_patricia@serratec.com', 'Sílvia Patrícia', 232, 4),
('25955230', '27474817004', 'nicolas@serratec.com', 'Nícolas', 987, 5),
('25956250', '39198868012', 'gabriel@serratec.com', 'Gabriel Bochimpani', 987, 6);










