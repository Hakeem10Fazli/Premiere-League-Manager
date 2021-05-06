package com.company;

import java.io.Serializable;
import java.util.Objects;

public class FootballClub extends SportsClub implements Serializable, Comparable<FootballClub> {

    private int wins;
    private int losses;
    private int draws;
    private int goalsReceived;
    private int goalsScored;
    private int pointsScored;
    private int matchPlayed;


    public FootballClub() {
        super();

    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public void setPointsScored(int pointsScored) {
        this.pointsScored = pointsScored;
    }

    public int getMatchPlayed() {
        return matchPlayed;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getPointsScored() {
        return pointsScored;
    }

    public void setMatchPlayed(int matchPlayed) {
        this.matchPlayed = matchPlayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FootballClub)) return false;
        if (!super.equals(o)) return false;
        FootballClub that = (FootballClub) o;
        return wins == that.wins &&
                losses == that.losses &&
                draws == that.draws &&
                goalsReceived == that.goalsReceived &&
                goalsScored == that.goalsScored &&
                pointsScored == that.pointsScored &&
                matchPlayed == that.matchPlayed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wins, losses, draws, goalsReceived, goalsScored, pointsScored, matchPlayed);
    }

    @Override
    public int compareTo(FootballClub i) {
        if (pointsScored == i.getPointsScored())
            return 0;
        else if (pointsScored > i.getPointsScored())
            return -1;
        else
            return 1;


    }

    @Override
    public String toString() {
        return super.toString() +

                "" + wins +
                "=" + losses +
                "=" + draws +
                "=" + goalsReceived +
                "=" + goalsScored +
                "=" + pointsScored +
                "=" + matchPlayed;
    }
}