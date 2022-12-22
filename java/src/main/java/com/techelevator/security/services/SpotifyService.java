package com.techelevator.security.services;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface SpotifyService {

    String getAccessToken() throws JsonProcessingException;

    String getDevices();

    String getArtistTopTracks();

    void startResumePlayback(int eventID);

    String pausePlayback();

    String skipToNext();

    String searchForItem(String userSearch);

    String createPlaylist();

    String getUsersPlaylist();


    String addItemsToPlaylist(String trackUri, String playlistUri);
}