package com.company;

import java.util.Comparator;


public class SortByPoints implements Comparator<FootballClub> {

    @Override
    public int compare(FootballClub club1, FootballClub club2) {
        if (club1.getPointsScored() < club2.getPointsScored()) {
            return 1;
        } else if (club1.getPointsScored() > club2.getPointsScored()) {
            return -1;
        }
        return 0;
    }
}

