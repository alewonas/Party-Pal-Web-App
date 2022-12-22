package com.techelevator.controller;

import com.techelevator.dao.GenreDao;

import com.techelevator.model.Genre;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/genre")
public class GenreController {

    private GenreDao genreDao;

    public GenreController(GenreDao genreDao){
        this.genreDao = genreDao;
    }

    @PreAuthorize("hasRole('DJ')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public void createGenre(@RequestBody Genre genre){
        genreDao.createGenre(genre);
    }

    @PreAuthorize("hasRole('DJ')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public void deleteGenre(@RequestBody Genre genre){
        genreDao.deleteGenre(genre);
    }

}
