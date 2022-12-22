package com.techelevator.model;

import java.util.Objects;

public class Song {

    private String trackUri;
    private String songName;
    private String artistName;
    private int genreID;

    public String getTrackUri() {
        return trackUri;
    }

    public void setTrackUri(String trackUri) {
        this.trackUri = trackUri;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return genreID == song.genreID && Objects.equals(trackUri, song.trackUri) && Objects.equals(songName, song.songName) && Objects.equals(artistName, song.artistName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackUri, songName, artistName, genreID);
    }

    @Override
    public String toString() {
        return "Song{" +
                "trackUri='" + trackUri + '\'' +
                ", songName='" + songName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", genreID=" + genreID +
                '}';
    }

}
