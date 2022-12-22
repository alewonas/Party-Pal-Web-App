BEGIN TRANSACTION;

INSERT INTO playlist (playlist_uri, dj_id, playlist_name)
VALUES ('spotify:playlist:5o0ZidwaV7XrPJ4j43uqNu', 3001, 'Graduation Playlist');

INSERT INTO playlist (playlist_uri, dj_id, playlist_name)
VALUES ('spotify:playlist:17cjDMmgMoUIrTomJc0tmc', 3001, 'Bottle & Cork NYD Playlist');

INSERT INTO playlist (playlist_uri, dj_id, playlist_name)
VALUES ('spotify:playlist:5wL6MHDg5CQLT6VYaZ8MiF', 3002, 'Christmas Party Playlist');

INSERT INTO playlist (playlist_uri, dj_id, playlist_name)
VALUES ('spotify:playlist:1NxETOJZZ3Sr2eNRaytmzs', 3002, 'Super Bowl Playlist');

INSERT INTO genre (genre_name)
VALUES('Hip/Hop');

INSERT INTO genre (genre_name)
VALUES('Classic Rock');

INSERT INTO genre (genre_name)
VALUES('Lit');

INSERT INTO song (track_uri, song_name, artist_name, genre_id)
VALUES ('spotify:track:3a1lNhkSLSkpJE4MSHpDu9', 'Congratulations', 'Post Malone', 1);

INSERT INTO playlist_song (playlist_uri, track_uri)
VALUES ('spotify:playlist:5o0ZidwaV7XrPJ4j43uqNu', 'spotify:track:3a1lNhkSLSkpJE4MSHpDu9');

INSERT INTO song (track_uri, song_name, artist_name, genre_id)
VALUES ('spotify:track:5VSAonaAPhhGn0G7hMYwWK', 'Sister Golden Hair', 'America', 2);

INSERT INTO playlist_song (playlist_uri, track_uri)
VALUES ('spotify:playlist:17cjDMmgMoUIrTomJc0tmc', 'spotify:track:5VSAonaAPhhGn0G7hMYwWK');

INSERT INTO song (track_uri, song_name, artist_name, genre_id)
VALUES ('spotify:track:0bYg9bo50gSsH3LtXe2SQn', 'All I Want for Christmas Is You', 'Mariah Carey', 3);

INSERT INTO playlist_song (playlist_uri, track_uri)
VALUES ('spotify:playlist:5wL6MHDg5CQLT6VYaZ8MiF', 'spotify:track:0bYg9bo50gSsH3LtXe2SQn');

INSERT INTO event (host_id, dj_id, playlist_uri, event_name, event_information, genres, event_picture)
VALUES (2001, 3001, 'spotify:playlist:5o0ZidwaV7XrPJ4j43uqNu', 'Tech Elevator Graduation', 'Friday December 16th || 4:30pm - 6:30pm || Wilm Tech Elevator Campus - Come celebrate the hard accomplishments of WILM Java Cohort 2!', 'Lit', '');

INSERT INTO event (host_id, dj_id, playlist_uri, event_name, event_information, genres, event_picture)
VALUES (2002, 3001, 'spotify:playlist:17cjDMmgMoUIrTomJc0tmc', 'Bottle & Cork New Year''s Day Jam', 'Sunday January 1st || 5:00pm - 8:00pm || Bottle & Cork - Come start the New Year right with live acts and cold beverages!', 'Classic Rock', '');

INSERT INTO event (host_id, dj_id, playlist_uri, event_name, event_information, genres, event_picture)
VALUES (2001, 3002, 'spotify:playlist:5wL6MHDg5CQLT6VYaZ8MiF', 'Trolley Square Christmas Block Party', 'Thursday December 22nd || 5:00pm - 9:00pm || Trolley Square - Come celebrate the holidays Trolley style', 'Lit', '');

COMMIT TRANSACTION;