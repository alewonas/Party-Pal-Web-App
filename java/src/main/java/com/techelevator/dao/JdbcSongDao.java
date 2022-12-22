package com.techelevator.dao;

import com.techelevator.model.NewSongDTO;
import com.techelevator.model.Song;
import com.techelevator.security.services.RestSpotifyService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JdbcSongDao implements SongDao{

    private final JdbcTemplate jdbcTemplate;
    private RestSpotifyService restSpotifyService;

    public JdbcSongDao(JdbcTemplate jdbcTemplate, RestSpotifyService restSpotifyService) {
        this.jdbcTemplate = jdbcTemplate;
        this.restSpotifyService = restSpotifyService;
    }

    @Override
    public List<Song> listSongs() {
        List<Song> songs = new ArrayList<>();
        String sql = "SELECT * FROM song;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Song song = mapRowToSong(results);
            songs.add(song);
        }
        return songs;
    }

    @Override
    public String getTrackUri(String songName) {
        String sql= "SELECT track_uri FROM song WHERE song_name = ?;";
        String result = jdbcTemplate.queryForObject(sql,String.class, songName);
        if(result != null){
            return result;
        } else{
            return null;
        }
    }

    @Override
    public List<Map<String, String>> listPlaylistSongs(int eventID) {
        List<Song> songs = new ArrayList<>();
        String sql = "SELECT * FROM song AS s " +
                     "JOIN playlist_song AS ps ON s.track_uri = ps.track_uri " +
                     "JOIN playlist AS p ON ps.playlist_uri = p.playlist_uri " +
                     "JOIN event AS e ON p.playlist_uri = e.playlist_uri " +
                     "WHERE event_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, eventID);
        while (results.next()) {
            songs.add(mapRowToSong(results));
        }

        List<Map<String, String>> json = new ArrayList<>();

        for(Song song: songs){
            Map<String, String> songAndArtist = new HashMap<>();
            songAndArtist.put("songName", song.getSongName());
            songAndArtist.put("artist", song.getArtistName());

            json.add(songAndArtist);
        }
        return json;
    }

    @Override
    public void createSong(NewSongDTO newSongDTO) {
        String sql = "INSERT INTO song (track_uri, song_name, artist_name, genre_id) " +
                    "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, newSongDTO.getUri(), newSongDTO.getName(), newSongDTO.getArtists(), 3);
    }

    private Song mapRowToSong(SqlRowSet rowSet){
        Song song = new Song();
        song.setTrackUri(rowSet.getString("track_uri"));
        song.setSongName(rowSet.getString("song_name"));
        song.setArtistName(rowSet.getString("artist_name"));
        song.setGenreID(rowSet.getInt("genre_id"));
        return song;
    }

}
