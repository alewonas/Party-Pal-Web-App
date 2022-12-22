package com.techelevator.controller;


import com.techelevator.dao.DJDao;
import com.techelevator.dao.UserDao;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/dj")
public class DJController {

    private DJDao djDao;
    private UserDao userDao;

    public DJController (DJDao djDao, UserDao userDao){
        this.djDao = djDao;
        this.userDao = userDao;
    }

    @RequestMapping(value="/hosts", method = RequestMethod.GET)
    public List<Map<String, String>> getListOfHosts(){
        return djDao.listHostNames();
    }

    @RequestMapping(value = "/djid", method = RequestMethod.GET)
    private int getLoggedInDjID (Principal principal) {
        int loggedInUserID = userDao.findIdByUsername(principal.getName());
        int loggedInDjID = djDao.findDjIDByUserID(loggedInUserID);
        return loggedInDjID;
    }

}
