create keyspace trabalho_bd with replication = 
					{'class':'SimpleStrategy',
					'replication_factor':2};

use trabalho_bd;
create table filmes(id int primary key, 
					titulo varchar, 
					titulo_original varchar,
					ano int, 
					qtd_visualizacao int,
					duracao_min int,
					censura int, 
					nota float);

insert into filmes (id, titulo, titulo_original, ano,
					qtd_visualizacao, duracao_min, censura, nota)
			values (1, 'O Auto da Compadecida', 
					'O Auto da Compadecida',
					2000, 300, 104, 0, 9.9);

insert into filmes (id, titulo, titulo_original, ano,
					qtd_visualizacao, duracao_min, censura, nota)
			values (2, 'Vingadores: Ultimato', 
					'Avengers: Endgame',
					2019, 250, 181, 14, 9.7);