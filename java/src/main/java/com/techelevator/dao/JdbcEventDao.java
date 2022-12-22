package com.techelevator.dao;

import com.techelevator.model.Event;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcEventDao implements EventDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcEventDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createNewEvent(Event newEvent, int dJID) {
        String sql = "INSERT INTO event (host_id, dj_id, playlist_uri, event_name, event_information, genres, event_picture) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?) ";
        jdbcTemplate.update(sql,  newEvent.getHostID(), dJID, newEvent.getPlaylistUri(), newEvent.getEventName(), newEvent.getEventInformation(), newEvent.getGenres(), newEvent.getEventPicture());
    }

    @Override
    public void updateEvent(Event updatedEvent){
        String sql = "UPDATE event SET playlist_uri = ?, event_name = ?, event_information = ?, genres = ?, event_picture = ?" +
                     "WHERE event_id = ?;";
        jdbcTemplate.update(sql, updatedEvent.getPlaylistUri(), updatedEvent.getEventName(), updatedEvent.getEventInformation(), updatedEvent.getGenres(), updatedEvent.getEventPicture(), updatedEvent.getEventID());
    }

    @Override
    public List<Event> listOfEvents() {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT * FROM event";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()){
            eventList.add(mapRowToEvent(rowSet));
        }
        return eventList;
    }

    @Override
    public Event getEvent(int eventID){
        String sql = "SELECT * FROM event WHERE event_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, eventID);
        if (results.next()){
            return mapRowToEvent(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Event> getDJEventNames(int djID) {
        List<Event> eventNames = new ArrayList<>();
        String sql = "SELECT * FROM event WHERE dj_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, djID);
        while (results.next()){
            Event events = mapRowToEvent(results);
            eventNames.add(events);
        }
        return eventNames;
    }

    @Override
    public void deleteEvent(int eventID) {
        String sql = "DELETE FROM event WHERE event_id = ?";
        int deletedEvent = jdbcTemplate.update(sql, eventID);
    }

    private Event mapRowToEvent(SqlRowSet rowSet){
        Event event = new Event();
        event.setEventID(rowSet.getInt("event_id"));
        event.setHostID(rowSet.getInt("host_id"));
        event.setDjID(rowSet.getInt("dj_id"));
        event.setPlaylistUri(rowSet.getString("playlist_uri"));
        event.setEventName(rowSet.getString("event_name"));
        event.setEventInformation(rowSet.getString("event_information"));
        event.setGenres(rowSet.getString("genres"));
        event.setEventPicture(rowSet.getString("event_picture"));
        return event;
    }

}
