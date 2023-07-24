package com.github.zipcodewilmington.casino.games.CoinToss;

import java.util.Random;
import java.util.Scanner;

public class CoinTossGame {

    int userFlip;
    int gameAns;
    int toss;
    int choice;



    public  void run (){
        displayInstructions();
        int tossResult=theToss();

        for (int i=0;i<3;i++){
            int userChoice=getChoice();
            displayTossResult(tossResult);
            match(tossResult,userChoice);

            if (i<2 && tossResult ==userChoice){
                updateAccount();
                break;
            }

            tossResult=theToss();
        }
        quit();

    }

    public  void displayInstructions(){
        System.out.println("      ***************************************");
        System.out.println("      ---------------------------------------");
        System.out.println("            (H) Lets play coin toss (T)  ");
        System.out.println("      ---------------------------------------");
        System.out.println("      ***************************************\n");
        System.out.println("You get three tries! If you win you double your bet!!\n");



    }

    public int theToss(){
        Random random = new Random();
        int toss= random.nextInt(2);
    return toss;
    }

    public  int getChoice(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("     Enter your Guess: 0 for Heads, 1 for Tails");
        int choice = scanner.nextInt();
        return choice;

    }
    public  void displayTossResult(int result) {
        System.out.println("The coin toss result: " + (result == 0 ? "Heads" : "Tails"));
    }

    public  void match(int toss, int choice) {
        if (toss == choice) {
            System.out.println("Congratulations! You guessed it right!");
        } else {
            System.out.println("Sorry! Better luck next time.");
        }
    }

    public  void updateAccount(){
        System.out.println("BLOOOP.\n");

    }

    public  void quit() {

        System.out.println("Thank you for playing! Press 1 to replay or 2 to return to the casino lobby.");
        Scanner console = new Scanner(System.in);
        int choice = console.nextInt();
        if (choice == 1) {
            run();
        } else if (choice == 2) {
            //back to main menu when i comment out this classes main method

        }


    }
    }
