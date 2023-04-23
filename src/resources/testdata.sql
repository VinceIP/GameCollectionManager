BEGIN TRANSACTION;

DROP TABLE IF EXISTS game, platform, hardware;
DROP SEQUENCE IF EXISTS game_serial, platform_serial, hardware_serial;

CREATE SEQUENCE game_serial;
CREATE TABLE game(
	game_id int NOT NULL DEFAULT nextval('game_serial'),
	game_name text NOT NULL,
	game_rating int,
	game_description text,
	game_released date,
	game_website text,
	game_metacritic_url text,
	game_alternate_names text[],
	game_user_completed boolean DEFAULT FALSE,
	game_user_favorite boolean DEFAULT FALSE,
	CONSTRAINT PK_game PRIMARY KEY(game_id)
);

INSERT INTO game(game_name, game_rating, game_description, game_released, game_website, game_metacritic_url,
				game_alternate_names)
VALUES('Test Game', 96, 'Description of a test entry.', '2023-4-23', 'http://www.google.com', 'about:blank',
	  ARRAY['Alternate Name 1', 'Alternate Name 2']);
	  
INSERT INTO game(game_name, game_rating, game_description, game_released, game_website, game_metacritic_url,
				game_alternate_names)
VALUES('Some Other Game', 56, 'This one isn''t very good.', '1991-4-23', 'http://www.google.com', 'about:blank',
	  ARRAY['Mediocre: The Game', 'It''s Okay: The Game']);
	  
INSERT INTO game(game_name, game_rating, game_description, game_released, game_website, game_metacritic_url)
VALUES('I don''t know', 100, 'A masterpiece.', '1995-4-23', 'http://www.google.com', 'about:blank');

COMMIT; 