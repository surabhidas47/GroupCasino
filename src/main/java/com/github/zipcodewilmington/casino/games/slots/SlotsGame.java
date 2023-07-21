package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Random;
import java.util.Scanner;

import static com.github.zipcodewilmington.casino.games.slots.SlotsPlayer.promptUserToStart;

    /**
     * Created by leon on 7/21/2020.
     */
    public class SlotsGame {
        Scanner console = new Scanner(System.in);
        String[] wordList = {"*STAR*", "*LUCK*", "*CASH*", "*PRAY*", "*HOPE*"};
        SlotsPlayer sp = new SlotsPlayer();

        //just temp to check if code works
//        public static void main(String[] args) {
//            run();
//        }

        public  void run() {
            int numberOfTries=0;

            displayInstructions();

            do {
                promptUserToStart();
                String[] wordList = spin();
                printResult(wordList);
                numberOfTries++;
                System.out.println("Press Enter to spin again!");

            }
            while (numberOfTries<3);


            if (checkMatch(wordList)){
                updateAccount();
            } else {
                quit();
            }


        }


        public  void displayInstructions(){
            System.out.println(" ***************************************");
            System.out.println(" ---------------------------------------");
            System.out.println(" { Welcome to the Slot Machine Game!!! } ");
            System.out.println(" ---------------------------------------");
            System.out.println(" ***************************************\n");
            System.out.println("     Type 'PULL' to crank the lever!\n ");
            System.out.print(">>>   ");


        }

        public  String[] spin() {
            Random random = new Random();
//        String[] wordList = {"*STAR*", "*LUCK*", "*CASH*", "*PRAY*", "*HOPE*"};


            for (int i = 0; i < wordList.length; i++) {
                int randomIndex = random.nextInt(wordList.length);
                wordList[i] = wordList[randomIndex];
            }

            return wordList;
        }

        public  void printResult(String[] wordList) {
            System.out.println(wordList[0] + " " + wordList[1] + " " + wordList[2]);

            if (checkMatch(wordList)) {
                System.out.println("Congratulations! You have a match!\n");
            } else {
                System.out.println("Better luck next time. No match.\n");
            }
        }


        public boolean checkMatch(String[] wordList) {

            return wordList[0].equals(wordList[1]) && wordList[0].equals(wordList[2]);
        }

        public void updateAccount(){
            System.out.println("BLOOOP.\n");

        }

        public  void quit(){
            System.out.println("Thank you for playing! Press 1 to replay or 2 to exit game");
            int choice = console.nextInt();
            if(choice==1) {
                run();
            }

        }


    }

