package com.techelevator.spotify;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "external_urls",
        "href",
        "id",
        "name",
        "type",
        "uri"
})
@Generated("jsonschema2pojo")

public class Artist {


    @JsonProperty("name")
    private String artistName;


    @JsonProperty("name")
    public String getArtistName() {
        return artistName;
    }

    @JsonProperty("name")
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

}
