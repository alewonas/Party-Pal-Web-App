package com.techelevator.model;

import java.util.Objects;

public class DJ {

    private int djID;
    private int userID;

    public int getDjID() {
        return djID;
    }

    public void setDjID(int djID) {
        this.djID = djID;
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
        DJ dj = (DJ) o;
        return djID == dj.djID && userID == dj.userID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(djID, userID);
    }

    @Override
    public String toString() {
        return "DJ{" +
                "djID=" + djID +
                ", userID=" + userID +
                '}';
    }

}
