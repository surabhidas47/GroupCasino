package com.github.zipcodewilmington.casino.games.CoinToss;

import java.util.Scanner;

public class CoinTossGame {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        run();
    }
    public static void run (){
        displayInstructions();

    }

    public static void displayInstructions(){
        System.out.println("      ***************************************");
        System.out.println("      ---------------------------------------");
        System.out.println("              (H) Lets play coin toss (T) } ");
        System.out.println("      ---------------------------------------");
        System.out.println("      ***************************************\n");
        System.out.println("You get three tries! If you win you double your bet!!\n");
        System.out.println("         Type 'FLIP' to try your luck!\n ");
        //thurs night after angela changes
        System.out.print("         >>>   ");

    }









}
