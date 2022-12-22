package com.techelevator.controller;

import com.techelevator.dao.DJDao;
import com.techelevator.dao.EventDao;
import com.techelevator.dao.HostDao;
import com.techelevator.dao.UserDao;

import com.techelevator.model.Event;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/event")
public class EventController {

    private EventDao eventDao;
    private UserDao userDao;
    private DJDao djDao;
    private HostDao hostDao;

    public EventController (EventDao eventDao, UserDao userDao, DJDao djDao, HostDao hostDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
        this.djDao = djDao;
        this.hostDao = hostDao;
    }

    private int getLoggedInUserID (Principal principal) {
        int loggedInUserID = userDao.findIdByUsername(principal.getName());
        return loggedInUserID;
    }

    @PreAuthorize("hasRole('DJ')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public void createNewEvent(@RequestBody Event event, Principal principal) {
        int userID = getLoggedInUserID(principal);
        int DjID = djDao.findDjIDByUserID(userID);
        eventDao.createNewEvent(event, DjID);
    }

    @PreAuthorize("hasAnyRole('HOST','DJ')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public void updateEvent(@RequestBody Event event, Principal principal){
        eventDao.updateEvent(event);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path="/list", method = RequestMethod.GET)
    public List<Event> listOfEvents(){
        return eventDao.listOfEvents();
    }

    @PreAuthorize("hasRole('DJ')")
    @RequestMapping(path="/dj/{djID}", method = RequestMethod.GET)
    public List<Event> getDJsEventNames(@PathVariable int djID){
        return eventDao.getDJEventNames(djID);
    }

    @PreAuthorize("hasRole('DJ')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path= "/delete/{eventID}", method = RequestMethod.DELETE)
    public void deleteEvent(@PathVariable int eventID){
        eventDao.deleteEvent(eventID);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/{eventID}", method = RequestMethod.GET)
    public Event event(@PathVariable int eventID){
        Event event = eventDao.getEvent(eventID);
        return event;
    }

}



