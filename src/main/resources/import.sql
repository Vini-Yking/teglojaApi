INSERT INTO tegloja.categoria (nome_categoria) VALUES ('Utilitário');
INSERT INTO tegloja.categoria (nome_categoria) VALUES ('Material de construção');
INSERT INTO tegloja.categoria (nome_categoria) VALUES ('Ferramentas');

INSERT INTO tegloja.produto (nome_produto, quantidade_estoque, valor_unitario, id_categoria) VALUES ('Arruela', 1000, 2.42, 1);
INSERT INTO tegloja.produto (nome_produto, quantidade_estoque, valor_unitario, id_categoria) VALUES ('Porca', 1000, 0.34, 1);
INSERT INTO tegloja.produto (nome_produto, quantidade_estoque, valor_unitario, id_categoria) VALUES ('Bucha', 1000, 1.79, 1);
INSERT INTO tegloja.produto (nome_produto, quantidade_estoque, valor_unitario, id_categoria) VALUES ('Barra rosqueada', 25, 4.44, 3);
INSERT INTO tegloja.produto (nome_produto, quantidade_estoque, valor_unitario, id_categoria) VALUES ('Parafuso', 1000, 2.90, 1);
INSERT INTO tegloja.produto (nome_produto, quantidade_estoque, valor_unitario, id_categoria) VALUES ('Chave de Fenda', 50, 12.90, 3);
INSERT INTO tegloja.produto (nome_produto, quantidade_estoque, valor_unitario, id_categoria) VALUES ('Broca', 200, 8.28, 3);

INSERT INTO tegloja.endereco (bairro, cep, localidade, logradouro, uf) VALUES ('Lagoa', '27925400', 'Macaé', 'Avenida Vereador Roberto Garrido de Souza', 'RJ');
INSERT INTO tegloja.endereco (bairro, cep, localidade, logradouro, uf) VALUES ('Alto da Serra', '25635030', 'Petrópolis', 'Rua Fernando Fernandes Lima', 'RJ');
INSERT INTO tegloja.endereco (bairro, cep, localidade, logradouro, uf) VALUES ('Várzea', '25953000', 'Teresópolis', 'Avenida Lúcio Meira', 'RJ');
INSERT INTO tegloja.endereco (bairro, cep, localidade, logradouro, uf) VALUES ('Jardim Meudon', '25954020', 'Teresópolis', 'Rua Goitacases', 'RJ');
INSERT INTO tegloja.endereco (bairro, cep, localidade, logradouro, uf) VALUES ('São Pedro', '25955230', 'Teresópolis', 'Rua Pedro Strucchi', 'RJ');
INSERT INTO tegloja.endereco (bairro, cep, localidade, logradouro, uf) VALUES ('São Pedro', '25956250', 'Teresópolis', 'Rua Otto Alencar', 'RJ');

INSERT INTO tegloja.cliente (cep, cpf, email, nome_cliente, numero_endereco, id_endereco) VALUES ('27925400', '80501507043', 'thiago@serratec.com', 'Thiago Paes', 222, 1);
INSERT INTO tegloja.cliente (cep, cpf, email, nome_cliente, numero_endereco, id_endereco) VALUES ('25635030', '30632596082', 'vinicios@serratec.com', 'Marcos Vinicios', 111, 2);
INSERT INTO tegloja.cliente (cep, cpf, email, nome_cliente, numero_endereco, id_endereco) VALUES ('25953000', '06773117020', 'hitalo@serratec.com', 'Hítalo Taverna', 333, 3);
INSERT INTO tegloja.cliente (cep, cpf, email, nome_cliente, numero_endereco, id_endereco) VALUES ('25954020', '38890628065', 'silvia_patricia@serratec.com', 'Sílvia Patrícia', 232, 4);
INSERT INTO tegloja.cliente (cep, cpf, email, nome_cliente, numero_endereco, id_endereco) VALUES ('25955230', '27474817004', 'nicolas@serratec.com', 'Nícolas', 987, 5);
INSERT INTO tegloja.cliente (cep, cpf, email, nome_cliente, numero_endereco, id_endereco) VALUES ('25956250', '39198868012', 'gabriel@serratec.com', 'Gabriel Bochimpani', 987, 6);