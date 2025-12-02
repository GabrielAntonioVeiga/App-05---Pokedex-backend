INSERT INTO usuarios (id, email, senha) VALUES
                                            (1, 'gabriel.veiga@gmail.com', '123456'),
                                            (2, 'uriel.duarte@gmail.com', '123456'),
                                            (3, 'vitor.espinoza@gmail.com', '123456'),
                                            (4, 'rafael.silva@gmail.com', '123456');

INSERT INTO pokemons (id, nome, tipo, usuario_cadastrador_id) VALUES
                                                                  (1, 'Pikachu', 'Elétrico', 1),
                                                                  (2, 'Charmander', 'Fogo', 1),
                                                                  (3, 'Bulbasaur', 'Planta/Veneno', 1),
                                                                  (4, 'Squirtle', 'Água', 1),
                                                                  (5, 'Jigglypuff', 'Normal/Fada', 1),
                                                                  (6, 'Gengar', 'Fantasma/Veneno', 1),
                                                                  (7, 'Eevee', 'Normal', 1),
                                                                  (8, 'Snorlax', 'Normal', 1),
                                                                  (9, 'Dragonite', 'Dragão/Voador', 1),
                                                                  (10, 'Mewtwo', 'Psíquico', 1);

INSERT INTO habilidades (id, nome, pokemon_id) VALUES
                                                   -- Pikachu (1)
                                                   (1, 'Choque do Trovão', 1),
                                                   (2, 'Investida Trovão', 1),

                                                   -- Charmander (2)
                                                   (3, 'Brasas', 2),
                                                   (4, 'Lança-Chamas', 2),

                                                   -- Bulbasaur (3)
                                                   (5, 'Chicote de Vinha', 3),
                                                   (6, 'Raio Solar', 3),

                                                   -- Squirtle (4)
                                                   (7, 'Jato d''Água', 4),
                                                   (8, 'Hidro Bomba', 4),

                                                   -- Jigglypuff (5)
                                                   (9, 'Canção de Ninar', 5),
                                                   (10, 'Tapa', 5),

                                                   -- Gengar (6)
                                                   (11, 'Bola Sombria', 6),
                                                   (12, 'Hipnose', 6),

                                                   -- Eevee (7)
                                                   (13, 'Ataque Rápido', 7),
                                                   (14, 'Mordida', 7),

                                                   -- Snorlax (8)
                                                   (15, 'Descansar', 8),
                                                   (16, 'Avalanche', 8),

                                                   -- Dragonite (9)
                                                   (17, 'Furacão', 9),
                                                   (18, 'Soco do Dragão', 9),

                                                   -- Mewtwo (10)
                                                   (19, 'Psíquico', 10),
                                                   (20, 'Esfera de Aura', 10);

-- Ajustar sequences para evitar conflito com inserts via aplicação:
SELECT setval('usuarios_id_seq', (SELECT MAX(id) FROM usuarios));
SELECT setval('pokemons_id_seq', (SELECT MAX(id) FROM pokemons));
SELECT setval('habilidades_id_seq', (SELECT MAX(id) FROM habilidades));
