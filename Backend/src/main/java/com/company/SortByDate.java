package com.company;

import java.util.Comparator;
public class SortByDate implements Comparator<Match>{

    @Override
    public int compare(Match match1 , Match match2) {
        if (match1.getMatchDate().getYear() < match2.getMatchDate().getYear()) {
            return 1;
        } else if (match1.getMatchDate().getYear() > match2.getMatchDate().getYear()) {
            return -1;
        } else if (match1.getMatchDate().getYear() == match2.getMatchDate().getYear()){
            if (match1.getMatchDate().getMonth() < match2.getMatchDate().getMonth()) {
                return 1;
            } else if (match1.getMatchDate().getMonth() > match2.getMatchDate().getMonth()) {
                return -1;
            } else if (match1.getMatchDate().getMonth() == match2.getMatchDate().getMonth()){
                if (match1.getMatchDate().getDay() < match2.getMatchDate().getDay()) {
                    return 1;
                } else if (match1.getMatchDate().getDay() > match2.getMatchDate().getDay()) {
                    return -1;
                }
                return 0;
            }
            return 0;
        }
        return 0;
    }
}


