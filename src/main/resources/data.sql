INSERT INTO perfis VALUES(1, 'ROLE_ADMIN');
INSERT INTO perfis VALUES(2, 'ROLE_COMPRADOR');
INSERT INTO usuarios (id,nome,email,senha) VALUES(1, 'Administrador', 'admin@email.com.br', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');
INSERT INTO usuarios (id,nome,email,senha) VALUES(2, 'Comprador', 'comprador@email.com.br', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');
INSERT INTO usuarios_perfis values(1, 1);
INSERT INTO usuarios_perfis values(2, 2);

INSERT INTO produtos (id,nome,descricao, categoria, preco, ativo) VALUES (1,'PAPEL TOALHA','CX COM 100 rolos','HIGIENE',80.00,1);
INSERT INTO produtos (id,nome,descricao, categoria, preco, ativo) VALUES (2,'BOLACHA RECHEADA','PACOTE COM 3','ALIMENTOS',30.00,1);
INSERT INTO produtos (id,nome,descricao, categoria, preco, ativo) VALUES (3,'CARREGADOR CELULAR','110volts','ACESSORIOS',15.00,1);

INSERT INTO estoques (id, produto_id, quantidade, versao) VALUES (1, 1, 4, 0);
INSERT INTO estoques (id, produto_id, quantidade, versao) VALUES (2, 2, 3, 0);
INSERT INTO estoques (id, produto_id, quantidade, versao) VALUES (3, 3, 3, 0);

--INSERT INTO pedidos (id, data, usuario_id) VALUES (1, CURRENT_TIMESTAMP(), 1);
--INSERT INTO itens_pedidos (id, pedido_id, produto_id, quantidade, preco_unitario)
  --     VALUES (1,1,3,2,15.00);
--INSERT INTO itens_pedidos (id, pedido_id, produto_id, quantidade, preco_unitario)
  --     VALUES (2,1,2,5,30.00);
