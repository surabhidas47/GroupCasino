package com.github.zipcodewilmington.casino.games.slots;

import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer {




    public static boolean promptUserToStart() {
        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();

        return userInput.equalsIgnoreCase("");
    }

}