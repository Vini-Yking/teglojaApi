CREATE SCHEMA if not exists tegloja ;
/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases V10.0.2                    */
/* Target DBMS:           PostgreSQL 9                                    */
/* Project file:          ERteglojaAPI.dez                                */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database creation script                        */
/* Created on:            2022-06-03 00:01                                */
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
    id_cliente INTEGER  NOT NULL,
    CONSTRAINT PK_pedido PRIMARY KEY (id_pedido)
);

/* ---------------------------------------------------------------------- */
/* Add table "tegloja.pedido_itens"                                       */
/* ---------------------------------------------------------------------- */

CREATE TABLE tegloja.pedido_itens (
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

ALTER TABLE tegloja.pedido_itens ADD CONSTRAINT produto_pedido_itens 
    FOREIGN KEY (id_produto) REFERENCES tegloja.produto (id_produto);

ALTER TABLE tegloja.pedido_itens ADD CONSTRAINT pedido_pedido_itens 
    FOREIGN KEY (id_pedido) REFERENCES tegloja.pedido (id_pedido);

ALTER TABLE tegloja.endereco ADD CONSTRAINT cliente_endereco 
    FOREIGN KEY (id_cliente) REFERENCES tegloja.cliente (id_cliente);

ALTER TABLE tegloja.foto ADD CONSTRAINT produto_foto 
    FOREIGN KEY (id_produto) REFERENCES tegloja.produto (id_produto);
