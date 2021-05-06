package com.company;

import java.io.IOException;
import java.util.List;

public interface LeagueManager {
    void addClub();

    void addPlayedMatch();

    void deleteTeam();

    List<FootballClub> leaguetable();

    void displayStatistics();

    void displayLeagueTable();

    void load() throws IOException,ClassNotFoundException;

    void loadMatches() throws IOException,ClassNotFoundException;

    List<FootballClub> getLeague();

    void store(PremierLeagueManager premierLeagueManager);
}
