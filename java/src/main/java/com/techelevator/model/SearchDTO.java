package com.techelevator.model;

public class SearchDTO {

    //This is the class that represents the data that is passed from the client to the server for a search endpoint.

    private String userSearch;

    public String getUserSearch() {
        return userSearch;
    }

    public void setUserSearch(String userSearch) {
        this.userSearch = userSearch;
    }

    @Override
    public String toString() {
        return "SearchDTO{" +
                "userSearch='" + userSearch + '\'' +
                '}';
    }

}
