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
    SlotsPlayer sp = new SlotsPlayer();


//    just temp to check if code works




    public void run() {
        int numberOfTries = 0;
        boolean hasMatch = false;


        displayInstructions();

        do {
            promptUserToStart();
            String[] wordList = spin();
            printResult(wordList);
            numberOfTries++;

            if (checkMatch(wordList)) {
                hasMatch = true;
                break;
            }

            if (numberOfTries < 3) {
                System.out.println("Press Enter to spin again!");
            }


        }
        while (numberOfTries < 3);

        if (hasMatch) {
            updateAccount();
        } else {
            quit();
        }
    }

        @Override
        public void displayInstructions () {
            System.out.println(" ***************************************");
            System.out.println(" ---------------------------------------");
            System.out.println(" { Welcome to the Slot Machine Game!!! } ");
            System.out.println(" ---------------------------------------");
            System.out.println(" ***************************************\n");
            System.out.println("     Type 'PULL' to crank the lever!\n ");
            System.out.print(">>>   ");
        }


        public String[] spin () {
            Random random = new Random();
            for (int i = 0; i < wordList.length; i++) {
                int randomIndex = random.nextInt(wordList.length);
                wordList[i] = wordList[randomIndex];
            }
            return wordList;
        }


        public void printResult (String[]wordList){
            System.out.println(wordList[0] + " " + wordList[1] + " " + wordList[2]);
            if (checkMatch(wordList)) {
                System.out.println("Congratulations! You have a match!\n");
            } else {
                System.out.println("Better luck next time. No match.\n");
            }
        }


        public boolean checkMatch (String[]wordList){

            return wordList[0].equals(wordList[1]) && wordList[0].equals(wordList[2]);
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





