package com.company;

import java.io.Serializable;

public class Match implements Serializable {
    private String club1;
    private String club2;
    private int club1Score;
    private int club2Score;
    private Date matchDate;

    public void setClub1(String club1) {
        this.club1 = club1;
    }

    public void setClub2(String club2) {
        this.club2 = club2;
    }

    public void setClub1Score(int club1Score) {
        this.club1Score = club1Score;
    }

    public void setClub2Score(int club2Score) {
        this.club2Score = club2Score;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getClub1() {
        return club1;
    }

    public String getClub2() {
        return club2;
    }

    public int getClub1Score() {
        return club1Score;
    }

    public int getClub2Score() {
        return club2Score;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    @Override
    public String toString() {
        return "Match{" +
                "club1='" + club1 + '\'' +
                ", club2='" + club2 + '\'' +
                ", club1Score=" + club1Score +
                ", club2Score=" + club2Score +
                ", matchDate=" + matchDate +
                '}';
    }
}
