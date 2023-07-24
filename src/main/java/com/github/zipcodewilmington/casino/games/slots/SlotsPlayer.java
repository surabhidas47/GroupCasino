package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;

import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer extends Player {
    public SlotsPlayer(CasinoAccount account) {super(account);}

    @Override
    public CasinoAccount getPlayerAccount() {
        return this.account;
    }


    public static boolean promptUserToStart() {
        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();

        return userInput.equalsIgnoreCase("");
    }

}