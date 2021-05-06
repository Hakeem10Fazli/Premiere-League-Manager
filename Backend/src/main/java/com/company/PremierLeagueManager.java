package com.company;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
public class PremierLeagueManager implements LeagueManager {

    private final int numberOfClubs = 20;

    public static List<FootballClub> league = new ArrayList<>();
    public static List<Match> matchList = new ArrayList<>();
    public static List<Match> findArray = new ArrayList<>();
    public static List<FootballClub> sortGoals = new ArrayList<>();
    public static List<FootballClub> sortWins = new ArrayList<>();


    private Scanner scanner = new Scanner(System.in);


/////////////////////////////////////////DISPLAYING LEAGUE TABLE//////////////////////////////////////////////
    @Override
    public void displayLeagueTable() {
        System.out.println(" Club Name | " + " Location |" + " Wins |" + " Loss |" + " Draws |" + " Goals Scored |" + "Received Goals |" + "Points |" + " MatchedPlayed |");

        if (league.size() == 0) {
            System.out.println("League is empty");
            System.out.println("");

            return;
        } else {
            Collections.sort(league);
            for (FootballClub footballClub : league) {
                System.out.println("");
                System.out.println("Club Name" + " - " + footballClub.getClubName() + "  " + "|" + " Location" + " - "+footballClub.getLocation() + "  " + "|" + " Scored Goals Count - " + footballClub.getGoalsScored() + "  " + "|" + " Received Goals Count - " + footballClub.getGoalsReceived() + "  " + "|" + "  Current Points - " + footballClub.getPointsScored());
                System.out.println("");

            }
            System.out.println(league);

        }

    }
////////////////////////////////////////////////ADDING CLUB////////////////////////////////////////////////////

    @Override
    public void addClub() {
        FootballClub club = new FootballClub();
        if (league.size() == numberOfClubs) {
            System.out.println("Maximum Clubs reached");
            System.out.println("");

            return;
        } else {

            System.out.println("Name of Club: ");
            System.out.println("");

            String line = scanner.nextLine();
            club.setClubName(line);

            for(FootballClub football : league){
                if (football.getClubName().equals(line)) {
                    System.out.println("Club Already exists");
                    System.out.println("");
                    return;
                }

            }

            System.out.println(" Club Location: ");
            System.out.println("");

            line = scanner.nextLine();
            club.setLocation(line);
            league.add(club);
            System.out.println("Club Successfully Added");
            System.out.println();
        }
    }
    public List<FootballClub> addclubs(FootballClub club) {
        league.add(club);
        return league;
    }

    /////////////////////////////////CREATING MATCH TABLE DISPLAY///////////////////////////////////////////////

    public List<Match> matchTable() {
        Collections.sort(matchList,new SortByDate());
        return matchList;
    }

    @Override
    public void addPlayedMatch() {
        Match match = new Match();
        Scanner scanner = new Scanner(System.in);
        String line;

        System.out.println("Enter day: ");
        int day = scanner.nextInt();

        System.out.println("Enter month: ");
        int month = scanner.nextInt();


        System.out.println("Enter year: ");
        int year = scanner.nextInt();

        Date date = new Date(day, month, year);
        match.setMatchDate(date);

        Random random = new Random();
        int randomA;
        int randomB;

        do {
            randomA = random.nextInt(PremierLeagueManager.league.size());
            randomB = random.nextInt(PremierLeagueManager.league.size());
        } while (randomA == randomB);

        FootballClub clubA = league.get(randomA);
        match.setClub1Score(randomB);
        match.setClub1(clubA.getClubName());

        FootballClub clubB = league.get(randomB);
        match.setClub2Score(randomA);
        match.setClub2(clubB.getClubName());

        int goalsA = random.nextInt(6);
        int goalsB = random.nextInt(6);

        match.setClub1Score(goalsA);
        match.setClub2Score(goalsB);

        clubA.setGoalsScored(clubA.getGoalsScored() + goalsA);
        clubA.setGoalsReceived(clubA.getGoalsReceived() + goalsB);
        clubA.setMatchPlayed(clubA.getMatchPlayed() + 1);
        clubB.setGoalsScored(clubB.getGoalsScored() + goalsB);
        clubB.setGoalsReceived(clubB.getGoalsReceived() + goalsA);
        clubB.setMatchPlayed(clubB.getMatchPlayed() + 1);

        if (goalsA > goalsB) {
            clubA.setWins(clubA.getWins() + 1);
            clubB.setLosses(clubB.getLosses() + 1);
            clubA.setPointsScored(clubA.getPointsScored() + 3);
            clubB.setPointsScored(clubB.getPointsScored() + 1);
        } else if (goalsA < goalsB) {
            clubB.setWins(clubB.getWins() + 1);
            clubA.setLosses(clubA.getLosses() + 1);
            clubB.setPointsScored(clubB.getPointsScored() + 3);
            clubA.setPointsScored(clubA.getPointsScored() + 1);
        } else {
            clubA.setDraws(clubA.getDraws() + 1);
            clubB.setDraws(clubB.getDraws() + 1);
        }
        matchList.add(match);
        System.out.println(clubA.getClubName() + " x " + clubB.getClubName());
        System.out.println(matchList);
    }
    ////////////////////////////////////////GENERATING MATCH FROM GUI///////////////////////////////////////////////

    public List<Match> addmatch(Date date) {
        Match match = new Match();
        match.setMatchDate(date);

        Random random = new Random();
        int randomA;
        int randomB;

        do {
            randomA = random.nextInt(PremierLeagueManager.league.size());
            randomB = random.nextInt(PremierLeagueManager.league.size());
        } while (randomA == randomB);

        FootballClub clubA = league.get(randomA);
        match.setClub1Score(randomB);
        match.setClub1(clubA.getClubName());

        FootballClub clubB = league.get(randomB);
        match.setClub2Score(randomA);
        match.setClub2(clubB.getClubName());

        int goalsA = random.nextInt(6);
        int goalsB = random.nextInt(6);

        match.setClub1Score(goalsA);
        match.setClub2Score(goalsB);

        clubA.setGoalsScored(clubA.getGoalsScored() + goalsA);
        clubA.setGoalsReceived(clubA.getGoalsReceived() + goalsB);
        clubA.setMatchPlayed(clubA.getMatchPlayed() + 1);
        clubB.setGoalsScored(clubB.getGoalsScored() + goalsB);
        clubB.setGoalsReceived(clubB.getGoalsReceived() + goalsA);
        clubB.setMatchPlayed(clubB.getMatchPlayed() + 1);

        if (goalsA > goalsB) {
            clubA.setWins(clubA.getWins() + 1);
            clubB.setLosses(clubB.getLosses() + 1);
            clubA.setPointsScored(clubA.getPointsScored() + 3);
            clubB.setPointsScored(clubB.getPointsScored() + 1);
        } else if (goalsA < goalsB) {
            clubB.setWins(clubB.getWins() + 1);
            clubA.setLosses(clubA.getLosses() + 1);
            clubB.setPointsScored(clubB.getPointsScored() + 3);
            clubA.setPointsScored(clubA.getPointsScored() + 1);
        } else {
            clubA.setDraws(clubA.getDraws() + 1);
            clubB.setDraws(clubB.getDraws() + 1);
        }
        matchList.add(match);
        System.out.println(clubA.getClubName() + " x " + clubB.getClubName());
        System.out.println(matchList);
        return matchList;
    }
    ////////////////////////////////////////FINDING MATCH FROM GUI///////////////////////////////////////////////

    public List<Match> findMatches(Date date) {
        findArray.clear();
        for (Match match : matchList) {
            if (match.getMatchDate().getDay() == date.getDay() && match.getMatchDate().getMonth() == date.getMonth() && match.getMatchDate().getYear() == date.getYear()) {
                findArray.add(match);
            }
        }
        System.out.println(findArray);
        System.out.println(matchList);
        System.out.println(matchList.get(1));
        return findArray;
    }

    public List<Match> finddate() {
        return findArray;
    }

    @Override
    public void deleteTeam() {
        System.out.println("Name of Club: ");
        System.out.println("");

        String line = scanner.nextLine();
        for (FootballClub club : league) {
            if (club.getClubName().equals(line)) {
                league.remove(club);
                System.out.println("Club " + club.getClubName() + " removed");
                System.out.println("");

                return;
            }
        }
        System.out.println("Club doesnt exist");
        System.out.println("");

    }
    ////////////////////////////////////////DISPLAYING LEAGUE TABLE IN GUI///////////////////////////////////////////////

    @Override
    public List<FootballClub> leaguetable() {
        Collections.sort(league,new SortByPoints());
        return league;
    }

    public List<FootballClub> sortGoals() {
        sortGoals.addAll(league);
        System.out.println(league);
        Collections.sort(sortGoals,new SortByGoals());
        return sortGoals;
    }

    public List<FootballClub> sortWins() {
        sortWins.addAll(league);
        System.out.println(league);
        Collections.sort(sortWins,new SortByWins());
        return sortWins;
    }

    ////////////////////////////////////////DISPLAYING STATISTICS//////////////////////////////////////////////////////
    @Override
    public void displayStatistics() {

        System.out.println("Input club name: ");
        System.out.println("");
        boolean arg = false;

        String line = scanner.nextLine();
        for (FootballClub club : league) {
            if (club.getClubName().equals(line)) {
                System.out.println("Club " + club.getClubName() + " matches won: " + club.getWins());
                System.out.println("Club " + club.getClubName() + " matches lost: " + club.getLosses());
                System.out.println("Club " + club.getClubName() + " matches draw: " + club.getDraws());
                System.out.println("Club " + club.getClubName() + " scored goals: " + club.getGoalsScored());
                System.out.println("Club " + club.getClubName() + " received goals: " + club.getGoalsReceived());
                System.out.println("Club " + club.getClubName() + " points: " + club.getPointsScored());
                System.out.println("Club " + club.getClubName() + " matches played: " + club.getMatchPlayed());
                arg = true;
            }else{
                arg=false;
            }
        }

        if(arg){
            System.out.println("");System.out.println("Club Doesnt exist");
        }
    }

    @Override
    public List<FootballClub> getLeague() {
        return null;
    }


    ////////////////////////////////////////STORING CLUB DATA TO A TEXT FILE//////////////////////////////////////////////////////

    @Override
    public void store(PremierLeagueManager premierLeagueManager) {
        String filename="PremierLeague.txt";
        try{
            ObjectOutputStream objectSaving =new ObjectOutputStream(new FileOutputStream(filename));
            for(FootballClub footballClub:league){
                objectSaving.writeObject(footballClub);
            }
            objectSaving.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("data has been saved successfully");
    }


    ////////////////////////////////////////STORING MATCH DATA TO A TEXT FILE//////////////////////////////////////////////////////

    public void storeMatches(PremierLeagueManager premierLeagueManager) {
        String filename="PremierLeagueMatches.txt";
        try{
            ObjectOutputStream objectSaving =new ObjectOutputStream(new FileOutputStream(filename));
            for(Match match:matchList){
                objectSaving.writeObject(match);
            }
            objectSaving.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("data has been saved successfully");
    }

    ////////////////////////////////////////LOADING THE CLUB DATA//////////////////////////////////////////////////////

    public void load() throws IOException,ClassNotFoundException {
        File file = new File("PremierLeague.txt");
        try {
            if(file.length()!=0) {
                FileInputStream fileInputSt = new FileInputStream(file);
                ObjectInputStream objectInputSt = new ObjectInputStream(fileInputSt);
                for (; ; ) {
                    try {
                        league.add((FootballClub) objectInputSt.readObject());
                    } catch (EOFException e) {
                        break;
                    }
                }
                System.out.println("Previous data has been loaded successfully");
            }else {
                AngularCwApplication.menu();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("");

    }
    ////////////////////////////////////////LOADING MATCH DATA//////////////////////////////////////////////////////

    public void loadMatches() throws IOException,ClassNotFoundException {
        File file = new File("PremierLeagueMatches.txt");
        try {
            if(file.length()!=0) {
                FileInputStream fileInputSt = new FileInputStream(file);
                ObjectInputStream objectInputSt = new ObjectInputStream(fileInputSt);
                for (; ; ) {
                    try {
                        matchList.add((Match) objectInputSt.readObject());
                    } catch (EOFException e) {
                        break;
                    }
                }
                System.out.println("Previous data has been loaded successfully");
            }else {
                AngularCwApplication.menu();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("");


    }

}