package com.company;

import java.util.Comparator;

public class SortByWins implements Comparator<FootballClub> {

    @Override
    public int compare(FootballClub club1, FootballClub club2) {
        if (club1.getWins() < club2.getWins()) {
            return 1;
        } else if (club1.getWins() > club2.getWins()) {
            return -1;
        }
        return 0;
    }
}
