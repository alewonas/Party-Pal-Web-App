package com.techelevator.controller;

import com.techelevator.dao.DJDao;
import com.techelevator.dao.PlaylistDao;
import com.techelevator.dao.UserDao;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/playlist")
public class PlaylistController{

    private PlaylistDao playlistDao;
    private DJDao djDao;
    private UserDao userDao;

    public PlaylistController(PlaylistDao playlistDao, DJDao djDao, UserDao userDao){
        this.playlistDao = playlistDao;
        this.djDao = djDao;
        this.userDao = userDao;
    }

    private int getLoggedInUserID (Principal principal) {
        int loggedInUserID = userDao.findIdByUsername(principal.getName());
        return loggedInUserID;
    }

    @RequestMapping(path="/list", method = RequestMethod.GET)
    public List<Map<String, String>> getDJPlaylistNames(Principal principal){
        int userID = getLoggedInUserID(principal);
        int DjID = djDao.findDjIDByUserID(userID);
        return playlistDao.listDJPlaylists(DjID);
    }

}
