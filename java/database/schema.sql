BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS dj CASCADE;
DROP TABLE IF EXISTS playlist CASCADE;
DROP TABLE IF EXISTS host CASCADE;
DROP TABLE IF EXISTS event CASCADE;
DROP TABLE IF EXISTS genre CASCADE;
DROP TABLE IF EXISTS song CASCADE;
DROP TABLE IF EXISTS playlist_song CASCADE;
DROP TABLE IF EXISTS host_playlist CASCADE;

DROP SEQUENCE IF EXISTS seq_user_id, seq_dj_id, seq_host_id;

CREATE SEQUENCE seq_user_id
    INCREMENT BY 1
    START WITH 1001
    NO MAXVALUE;

CREATE TABLE users (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user_id PRIMARY KEY (user_id)
);

CREATE SEQUENCE seq_dj_id
    INCREMENT BY 1
    START WITH 3001
    NO MAXVALUE;

CREATE TABLE dj (
    dj_id int NOT NULL DEFAULT nextval('seq_dj_id'),
    user_id int NOT NULL,
    CONSTRAINT PK_dj_id PRIMARY KEY (dj_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE playlist (
    playlist_uri varchar(50) NOT NULL UNIQUE,
    dj_id int NOT NULL,
    playlist_name varchar(50),
    CONSTRAINT PK_playlist_uri PRIMARY KEY (playlist_uri),
    CONSTRAINT FK_dj_id FOREIGN KEY (dj_id) REFERENCES dj (dj_id)
);

CREATE SEQUENCE seq_host_id
    INCREMENT BY 1
    START WITH 2001
    NO MAXVALUE;

CREATE TABLE host (
    host_id int NOT NULL DEFAULT nextval('seq_host_id'),
    user_id int NOT NULL,
    CONSTRAINT PK_host_id PRIMARY KEY (host_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE event (
    event_id SERIAL,
    host_id int NOT NULL,
    dj_id int NOT NULL,
    playlist_uri varchar(50) NOT NULL,
    event_name varchar(200),
    event_information varchar(1000),
    genres varchar(100),
    event_picture varchar(100),
    CONSTRAINT PK_event_id PRIMARY KEY (event_id),
    CONSTRAINT FK_host_id FOREIGN KEY (host_id) REFERENCES host (host_id),
    CONSTRAINT FK_dj_id FOREIGN KEY (dj_id) REFERENCES dj (dj_id),
    CONSTRAINT FK_playlist_uri FOREIGN KEY (playlist_uri) REFERENCES playlist (playlist_uri)
);

CREATE TABLE genre (
    genre_id SERIAL,
    genre_name varchar(50) NOT NULL UNIQUE,
    CONSTRAINT PK_genre_id PRIMARY KEY (genre_id)
);

CREATE TABLE song (
    track_uri varchar(100) NOT NULL UNIQUE,
    song_name varchar(100) NOT NULL,
    artist_name varchar(50) NOT NULL,
    genre_id int NOT NULL,
    CONSTRAINT PK_track_uri PRIMARY KEY (track_uri),
    CONSTRAINT FK_genre_id FOREIGN KEY (genre_id) REFERENCES genre (genre_id)
);

CREATE TABLE playlist_song (
    playlist_uri varchar(50) NOT NULL,
    track_uri varchar(100) NOT NULL,
    CONSTRAINT FK_playlist_uri FOREIGN KEY (playlist_uri) REFERENCES playlist (playlist_uri),
    CONSTRAINT FK_track_uri FOREIGN KEY (track_uri) REFERENCES song (track_uri)
);

CREATE TABLE host_playlist (
    host_id int NOT NULL,
    playlist_uri varchar(50) NOT NULL,
    CONSTRAINT FK_host_id FOREIGN KEY (host_id) REFERENCES host (host_id),
    CONSTRAINT FK_playlist_uri FOREIGN KEY (playlist_uri) REFERENCES playlist (playlist_uri)
);

DROP USER IF EXISTS final_capstone_owner;
DROP USER IF EXISTS final_capstone_appuser;

CREATE USER final_capstone_owner
WITH PASSWORD 'finalcapstone';
CREATE USER final_capstone_appuser
WITH PASSWORD 'finalcapstone';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO final_capstone_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_owner;

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_capstone_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_appuser;

COMMIT TRANSACTION;

ROLLBACK;



