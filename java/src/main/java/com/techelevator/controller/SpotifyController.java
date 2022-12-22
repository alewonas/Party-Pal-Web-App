package com.techelevator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techelevator.security.services.SpotifyService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@CrossOrigin
@RestController
public class SpotifyController {

    private SpotifyService spotifyService;

    public SpotifyController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    /**
     * These are the service calls to get spotify data and return JSON back to client
     */

    @RequestMapping(path = "/token", method = RequestMethod.GET)
    public String getSpotifyAccessToken() throws JsonProcessingException {
        URI currentUri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
        String asString = currentUri.toString();
        return spotifyService.getAccessToken();
    }

    @RequestMapping(path = "/devices", method = RequestMethod.GET)
    public String getSpotifyConnectedDevices() throws JsonProcessingException {
        return spotifyService.getDevices();
    }

    @RequestMapping(path = "/artist/tracks", method = RequestMethod.GET)
    public String getSpotifyArtistTopTracks() throws JsonProcessingException {
        return spotifyService.getArtistTopTracks();
    }

    @RequestMapping(path = "/play/{eventID}", method = RequestMethod.PUT)
    public void playSpotifyTrack(@PathVariable int eventID) throws JsonProcessingException {
         spotifyService.startResumePlayback(eventID);
    }

    @RequestMapping(path = "/pause", method = RequestMethod.PUT)
    public String pausePlayback() throws JsonProcessingException {
        return spotifyService.pausePlayback();
    }

    @RequestMapping(path = "/skip", method = RequestMethod.POST)
    public String skipToNext() throws JsonProcessingException {
        return spotifyService.skipToNext();
    }

    @RequestMapping(path = "/search/tracks/{userSearch}", method = RequestMethod.GET)
    public String searchForItem(@PathVariable String userSearch) throws JsonProcessingException {
        return spotifyService.searchForItem(userSearch);
    }

    @RequestMapping(path = "/create/playlist", method = RequestMethod.POST)
    public String createPlaylist() throws JsonProcessingException {
        return spotifyService.createPlaylist();
    }

    @RequestMapping(path = "/user/playlist", method = RequestMethod.GET)
    public String getUsersPlaylist() throws JsonProcessingException {
        return spotifyService.getUsersPlaylist();
    }

    @RequestMapping(path = "/add/playlist/{trackUri}", method = RequestMethod.POST)
    public String addItemsToPlaylist(@PathVariable String trackUri, @RequestBody String playlistUri) throws JsonProcessingException {
        return spotifyService.addItemsToPlaylist(trackUri, playlistUri);
    }

}
