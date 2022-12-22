package com.techelevator.model;

import java.util.Objects;

public class Event {

    private int eventID;
    private int djID;
    private int hostID;
    private String playlistUri;
    private String eventName;
    private String eventInformation;
    private String genres;
    private String eventPicture;

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getDjID() {
        return djID;
    }

    public void setDjID(int djID) {
        this.djID = djID;
    }
    public int getHostID() {
        return hostID;
    }

    public String getPlaylistUri() {
        return playlistUri;
    }

    public void setPlaylistUri(String playlistUri) {
        this.playlistUri = playlistUri;
    }

    public void setHostID(int hostID) {
        this.hostID = hostID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventInformation() {
        return eventInformation;
    }

    public void setEventInformation(String eventInformation) {
        this.eventInformation = eventInformation;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getEventPicture() {
        return eventPicture;
    }

    public void setEventPicture(String eventPicture) {
        this.eventPicture = eventPicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return eventID == event.eventID && djID == event.djID && Objects.equals(eventName, event.eventName) && Objects.equals(eventInformation, event.eventInformation) && Objects.equals(genres, event.genres) && Objects.equals(eventPicture, event.eventPicture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventID, djID, eventName, eventInformation, genres, eventPicture);
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventID=" + eventID +
                ", djID=" + djID +
                ", eventName='" + eventName + '\'' +
                ", eventInformation='" + eventInformation + '\'' +
                ", genres='" + genres + '\'' +
                ", eventPicture='" + eventPicture + '\'' +
                '}';
    }

}
