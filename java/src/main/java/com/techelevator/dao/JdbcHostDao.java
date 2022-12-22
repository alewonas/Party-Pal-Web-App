package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcHostDao implements HostDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcHostDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int findHostIDByUserID (int userID) {
        String sql = "SELECT host_id FROM host WHERE user_id = ?;";
        int id = jdbcTemplate.queryForObject(sql, Integer.class, userID);
        if (id != 0) {
            return id;
        } else {
            return 0;
        }
    }

}
