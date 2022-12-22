package com.techelevator.model;

import java.util.Objects;

public class Host {

    private int hostID;

    private int userID;

    public int getHostID() {
        return hostID;
    }

    public void setHostID(int hostID) {
        this.hostID = hostID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Host eventHost = (Host) o;
        return hostID == eventHost.hostID  && userID == eventHost.userID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostID, userID);
    }

    @Override
    public String toString() {
        return "EventHost{" +
                "hostID=" + hostID +
                ", userID=" + userID +
                '}';
    }

}
