package com.techelevator.model;

import com.techelevator.spotify.Artist;

import java.util.List;

public class SearchResponseDTO {

    private String name;
    private String uri;
    private List<Artist> artists;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

}
