package com.company;

import java.util.Comparator;

public class SortByGoals implements Comparator<FootballClub> {

    @Override
    public int compare(FootballClub club1, FootballClub club2) {
        if (club1.getGoalsScored() < club2.getGoalsScored()) {
            return 1;
        } else if (club1.getGoalsScored() > club2.getGoalsScored()) {
            return -1;
        }
        return 0;
    }
}
