package com.company;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
public class RestAPI {
    public static PremierLeagueManager premierLeague = new PremierLeagueManager();

    @GetMapping("/table")
    public List<FootballClub> getRequest() {
        return premierLeague.leaguetable();
    }


    @GetMapping("/tableGoals")
    public List<FootballClub> getRequest2() {
        return premierLeague.sortGoals();
    }


    @GetMapping("/tableWins")
    public List<FootballClub> getRequest3() {
        return premierLeague.sortWins();
    }

    @PostMapping("/addmatch")
    public List<Match> addmatches(@RequestBody Date date){
        return premierLeague.addmatch(date);
    }

    @GetMapping("/match")
    public List<Match> getRequestmatch() {
        return premierLeague.matchTable();
    }

    @PostMapping("/club")
    public List<FootballClub> addClub(@RequestBody FootballClub club) {
        return premierLeague.addclubs(club);
    }

    @PostMapping("/findmatch")
    public List<Match> findmatch(@RequestBody Date date) {
        return premierLeague.findMatches(date);
    }

    @GetMapping("/finddate")
    public List<Match> getfindmatch() {
        return premierLeague.finddate();
    }

}