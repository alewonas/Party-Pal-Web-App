package com.techelevator.model;

import java.util.Objects;

public class Genre {

    private int genreID;
    private String genreName;

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return genreID == genre.genreID && Objects.equals(genreName, genre.genreName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreID, genreName);
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreID=" + genreID +
                ", genreName='" + genreName + '\'' +
                '}';
    }

}
