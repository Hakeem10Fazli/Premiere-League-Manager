package com.company;

import java.io.Serializable;
import java.util.Objects;

public abstract class SportsClub implements Serializable {
    private String clubName;
    private String location;

    public SportsClub() {

    }

    public String getClubName() {
        return clubName;
    }

    public String getLocation() {
        return location;
    }


    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SportsClub)) return false;
        SportsClub that = (SportsClub) o;
        return clubName.equals(that.clubName) &&
                location.equals(that.location);

    }

    @Override
    public int hashCode() {
        return Objects.hash(clubName, location);
    }

    @Override
    public String toString() {
        return
                "" + clubName + '\'' +
                        "" + location + '\'';
    }
}