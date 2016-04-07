package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by travis on 3/31/16.
 */
public class Lineup {

    private Player head;

    public Lineup() {
        this.head = null;
    }

    private Player createPlayer() {
        System.out.println("Enter new player name: ");
        Scanner scanner = new Scanner(System.in);
        return new Player(scanner.next());
    }

    public void addToList() {
        Player newPlayer = createPlayer();
        if(this.head == null) {
            this.head = newPlayer;
            System.out.println(newPlayer.getValue() + " is now in the lineup.");
        } else {
            Player currentPlayer = head;
            while (currentPlayer.hasNextItem()) {
                if(newPlayer.compare(currentPlayer) == 0) {
                    System.out.println(newPlayer.getValue() + " already in the list.");
//                    return false;
                } else if(newPlayer.compare(currentPlayer) == -1) {
                    if(currentPlayer.getPrevItem() == null) {
                        this.head = newPlayer;
                    } else {
                        newPlayer.setPrevItem(currentPlayer.getPrevItem());
                        currentPlayer.getPrevItem().setNextItem(newPlayer);
                    }
                    newPlayer.setNextItem(currentPlayer);
                    currentPlayer.setPrevItem(newPlayer);
//                    return true;
                } else if (newPlayer.compare(currentPlayer) == 1) {
                    currentPlayer = (Player) currentPlayer.getNextItem();
                }
            }
            int comparison = newPlayer.compare(currentPlayer);
            System.out.println(comparison);
            if(comparison == 0) {
                System.out.println("Player is already in the lineup.");
                return;
            } else if(comparison == -1) {
                System.out.println(newPlayer.getValue() + " compared to " + currentPlayer.getValue() + " returns -1.");
                newPlayer.setPrevItem(currentPlayer.getPrevItem());
                newPlayer.setNextItem(currentPlayer);
                if(!currentPlayer.hasPrevItem()) {
                    System.out.println(currentPlayer.getValue() + "'s prev item is null. Head should be set to " + newPlayer.getValue());
                    this.head = newPlayer;
                } else {
                    currentPlayer.getPrevItem().setNextItem(newPlayer);
                }
                currentPlayer.setPrevItem(newPlayer);
            } else if(comparison == 1) {
                currentPlayer.setNextItem(newPlayer);
                newPlayer.setPrevItem(currentPlayer);
            }
            System.out.println(newPlayer.getValue() + " has been added to the lineup.");
        }
    }

//    public void removeFromList() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter name of player to remove: ");
//        String playerNameToRemove = scanner.nextLine();
//        for (Player player : this.playerList) {
//            if (player.getValue().equals(playerNameToRemove)) {
//                if (player.hasPrevItem() && player.hasNextItem()) {
//                    player.getPrevItem().setNextItem(player.getNextItem());
//                    player.getNextItem().setPrevItem(player.getPrevItem());
//                // player doesn't have a previous item - next player needs to be head and prev item set to null
//                } else if(player.hasNextItem()) {
//                    this.head = (Player) player.getNextItem();
//                    player.getNextItem().setPrevItem(null);
//                // player doesn't have next item - set prev item's next item to null
//                } else if(player.hasPrevItem()) {
//                    player.getPrevItem().setNextItem(null);
//                } else {
//                    System.out.println("List is now empty.");
//                }
//                playerList.remove(player);
//                System.out.println("Player removed from the lineup.");
//                return;
//            }
//        }
//        // player not found in the list
//        System.out.println("Player not found in the lineup.");
//    }




    public Player getHead() {
        return head;
    }

    public void printLineup() {
        Player currentPlayer = this.head;
        if(currentPlayer == null) {
            System.out.println("List is empty.");
        } else {
            while (currentPlayer != null) {
                System.out.println(currentPlayer.getValue());
                currentPlayer = (Player) currentPlayer.getNextItem();
            }
        }
    }

    public void printMenu() {
        System.out.println("2016 Astros Lineup");
        System.out.println("__________________");
        System.out.println("1) Print Lineup");
        System.out.println("2) Add Player");
        System.out.println("3) Remove From Lineup");
        System.out.println("4) Play Ball!");
        System.out.println("5) Quit");
        System.out.println("Make selection: ");
    }

}