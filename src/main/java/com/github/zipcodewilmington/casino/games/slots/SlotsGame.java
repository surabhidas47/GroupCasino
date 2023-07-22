package com.github.zipcodewilmington.casino.games.slots;


import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import com.github.zipcodewilmington.Casino;


import java.util.Random;
import java.util.Scanner;

import static com.github.zipcodewilmington.casino.games.slots.SlotsPlayer.promptUserToStart;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {

    String[] wordList = {"*STAR*", "*LUCK*", "*CASH*", "*PRAY*", "*HOPE*"};
    SlotsPlayer sp; //instance of player
    private final IOConsole console = new IOConsole(AnsiColor.CYAN);
    int bet;

    public SlotsGame(SlotsPlayer splayer) {
        sp = splayer;
    }

    public SlotsGame() {
    }

    public void run() {

        displayInstructions();
        placeBet();
        winOrLose();

    }

        @Override
        public void displayInstructions () {
            System.out.println(" ***************************************");
            System.out.println(" ---------------------------------------");
            System.out.println(" { Welcome to the Slot Machine Game!!! } ");
            System.out.println(" ---------------------------------------");
            System.out.println(" ***************************************\n");
            System.out.print(">>>   ");
        }

        public int placeBet() {
            return bet = console.getIntegerInput("Place your bet: ");
        }

        public String[] spin () {
            Random random = new Random();
            for (int i = 0; i < wordList.length; i++) {
                int randomIndex = random.nextInt(wordList.length);
                wordList[i] = wordList[randomIndex];
            }
            return wordList;
        }

        public void askUserToPullMsg () {
            System.out.println("     Type 'PULL' to crank the lever!\n ");
        }

        public boolean checkMatch (String[]wordList){

            boolean indexCheck= wordList[0].equals(wordList[1]) && wordList[0].equals(wordList[2]);
            return  indexCheck;
        }

        public boolean winOrLose () {
            int tries = 3;

            while (tries > 0) {
                askUserToPullMsg();
                promptUserToStart();
                spin();
                System.out.println(wordList[0] + " " + wordList[1] + " " + wordList[2]);
                System.out.println("\n");

                if (checkMatch(wordList)) {
                    System.out.println("Congratulations! You have a match! You have doubled your bet!\n");
                    sp.getPlayerAccount().addBalance(bet * 2);
                    sp.getPlayerAccount().setBalance(sp.getPlayerAccount().getBalance());
                    System.out.println("Your balance now is: " + sp.getPlayerAccount().getBalance() + "\n");
                    return true;

                }

                tries --;

            }

            noMatch();
            return false;

        }

        public void noMatch() {
            System.out.println("Better luck next time. No match. You lost your bet!\n");
                sp.getPlayerAccount().withdrawBalance(bet);
                sp.getPlayerAccount().setBalance(sp.getPlayerAccount().getBalance());
                System.out.println("Your balance now is: " + sp.getPlayerAccount().getBalance() + "\n");

        }




        public void updateAccount () {
            System.out.println("BLOOOP.\n");

        }

        @Override
        public void quit () {

            System.out.println("Thank you for playing! Press 1 to replay or 2 to return to the casino lobby.");
            Scanner console = new Scanner(System.in);
            int choice = console.nextInt();
            if (choice == 1) {
                run();
            } else if (choice == 2) {
                //back to main menu when i comment out this classes main method
            }
        }

    @Override
    public void add(Player player) {

    }

    @Override
    public void remove(Player player) {

    }


    @Override
    public Boolean checkWinner() {
        return null;
    }



}





