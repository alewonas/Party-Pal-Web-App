package com.techelevator.model;

import java.util.Objects;

public class Playlist {

    private String playlistUri;
    private String playlistName;
    private int djID;

    public String getPlaylistUri() {
        return playlistUri;
    }

    public void setPlaylistUri(String playlistUri) {
        this.playlistUri = playlistUri;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public int getDjID() {
        return djID;
    }

    public void setDjID(int djID) {
        this.djID = djID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return playlistUri == playlist.playlistUri && djID == playlist.djID && Objects.equals(playlistName, playlist.playlistName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistUri, playlistName, djID);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistID=" + playlistUri +
                ", playlistName='" + playlistName + '\'' +
                ", djID=" + djID +
                '}';
    }

}

