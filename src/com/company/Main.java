package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Lineup lineup = new Lineup();
        boolean quit = false;
        int selection;
        Scanner scanner = new Scanner(System.in);

        while (!quit) {
            lineup.printMenu();
            selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    lineup.printLineup();
                    break;
                case 2:
                    lineup.addToList();
                    break;
                case 3:
//                    lineup.removeFromList();
                    break;
                case 4:
                    boolean playingBall = true;
                    Player currentBatter = lineup.getHead();
                    while(playingBall) {
                        System.out.println("Now batting: " + currentBatter.getValue());
                        System.out.println("1) Next batter");
                        System.out.println("2) Previous batter");
                        System.out.println("3) Foul! Repeat same batter");
                        System.out.println("4) That's the ballgame!");
                        System.out.println("Enter selection: ");
                        int batter = scanner.nextInt();
                        switch(batter) {
                            case 1:
                                if(currentBatter.moveToNextItem() == null) {
                                    System.out.println("At the bottom of the order.");
                                } else {
                                    currentBatter = (Player) currentBatter.moveToNextItem();
                                } break;
                            case 2:
                                if(currentBatter.moveToPrevItem() == null) {
                                    System.out.println("At the top of the order.");
                                } else {
                                    currentBatter = (Player) currentBatter.moveToPrevItem();
                                } break;
                            case 3:
                                System.out.println("Foul ball!");
                                break;
                            case 4:
                                playingBall = false;
                                break;
                        }
                    }
                    lineup.printMenu();
                case 5:
                    quit = true;
                    break;
            }
        }

    }


}
