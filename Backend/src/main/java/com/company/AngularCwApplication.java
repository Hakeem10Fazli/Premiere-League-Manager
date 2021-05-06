package com.company;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class AngularCwApplication {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();

        SpringApplication.run(AngularCwApplication.class, args);// stating point of spring application

        premierLeagueManager.loadMatches();
        premierLeagueManager.load();
        menu();


    }

    public static void menu() {
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Premier League menu: ");
            System.out.println("Press 1 to Add Club");
            System.out.println("Press 2 to Delete Club");
            System.out.println("Press 3 to view Statistics");
            System.out.println("Press 4 to view Premiere League Table");
            System.out.println("Press 5 to Add a Match");
            System.out.println("Press 6 to Store");
            System.out.println("Press 7 to Load GUI");
            System.out.println("Press Q to Exit");

            String line = scanner.nextLine();
            switch (line) {
                case "1":
                    premierLeagueManager.addClub();
                    break;
                case "2":
                    premierLeagueManager.deleteTeam();
                    break;
                case "3":
                    premierLeagueManager.displayStatistics();
                    break;
                case "4":
                    premierLeagueManager.displayLeagueTable();
                    break;
                case "5":
                    premierLeagueManager.addPlayedMatch();
                    break;
                case "6":
                    premierLeagueManager.store(premierLeagueManager);
                    premierLeagueManager.storeMatches(premierLeagueManager);

                    break;
                case "7":
                    Runtime rt = Runtime.getRuntime();
                    String url = "http://localhost:4200/table";
                    try {
                        rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                case ("q"):
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Input");
            }

        }
    }
}
