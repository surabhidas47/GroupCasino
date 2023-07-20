package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import com.github.zipcodewilmington.casino.games.rockpaperscissors.RpsGame;
import com.github.zipcodewilmington.casino.games.roulette.GameRoulette;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
import java.io.IOException;

import java.io.IOException;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino {

    // wordguess wg1 = new wordguess

    // game object 2

    // game object 3

    // player
    private final IOConsole console = new IOConsole(AnsiColor.CYAN);

    public void run() throws IOException {

        String arcadeDashBoardInput;
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        welcome();

        do {
            arcadeDashBoardInput = getArcadeDashboardInput().toUpperCase();

            switch (arcadeDashBoardInput) {

                case "CREATE ACCOUNT":
                    console.println("Create an account here! ");
                    String userName = console.getStringInput("Enter your account username: ");
                    String userPassword = console.getStringInput("Enter your account password: ");
                    Integer userBalance = console.getIntegerInput("Enter the dollar amount of money you would like to add to your account: ");
                    if (casinoAccountManager.getAccountUsername().contains(userName)) {
                        System.out.println("This username already exists");
                    } else {
                        casinoAccountManager.createAccount(userName, userPassword, userBalance);
                        casinoAccountManager.updateAccounts();
                        System.out.println("Account successfully created");
                    }
                    break;

                case "SELECT GAME":
                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
                    switch (gameSelectionInput) {
                        case "ROCK PAPER SCISSORS":
                        case "NUMBER GUESS":
                            if (gameSelectionInput.equals("ROCK PAPER SCISSORS")) {
                                new RpsGame().run();
                            } else {
                                new NumberGuessGame().run();
                            }
                            casinoAccountManager.updateAccounts();
                            break;

                        case "SLOTS":
                        case "ROULETTE":
                            if (gameSelectionInput.equals("SLOTS")) {
                                new SlotsGame().run();
                            } else {
                                new GameRoulette().run();
                            }
                            casinoAccountManager.updateAccounts();
                            break;

                    }

            }
        } while (!"EXIT".equalsIgnoreCase(arcadeDashBoardInput));
    }


    private String getArcadeDashboardInput() {
        return console.getStringInput(
                "Select an option: \n" +
                        "[CREATE ACCOUNT]  [SELECT GAME]  [EXIT] \n" +
                        ">> ");
    }

    private String getGameSelectionInput() {
        return console.getStringInput(
                "Select any of the following games: \n" +
                        "[SLOTS] [ROULETTE] [COIN FLIP] [NUMBER GUESS] [21] [ROCK PAPER SCISSORS] \n" +
                        ">> ");
    }

    private void welcome() {
        console.println("Welcome to the Trillium Casino! \n\n");
    }


}
