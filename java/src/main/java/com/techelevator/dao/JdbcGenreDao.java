package com.techelevator.dao;

import com.techelevator.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcGenreDao implements GenreDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcGenreDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createGenre(Genre genre){
        String sql = "INSERT INTO genre (genre_name) " +
                     "VALUES (?)";
        jdbcTemplate.update(sql, genre.getGenreName());

    }
    @Override
    public void deleteGenre(Genre genre){
        String sql = "DELETE FROM genre WHERE genre_name = ?;";
        jdbcTemplate.update(sql, genre.getGenreName());
    }

}
