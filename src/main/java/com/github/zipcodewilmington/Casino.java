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
                        case "ROCK PAPER SCISSOR":
                        case "NUMBER GUESS":
                        case "SLOTS":
                        case "ROULETTE":
                            // log in user account
                            CasinoAccount userAccount = promptLogin(casinoAccountManager);
                            if(userAccount == null) {
                                console.println("No account found with that username and password. " +
                                        "Redirecting to the main menu.");
                                break;
                            }

                            if (gameSelectionInput.equals("ROCK PAPER SCISSOR")) {
                                new RpsGame().run();
                            } else if(gameSelectionInput.equals("NUMBER GUESS")){
                                new NumberGuessGame().run();
                            } else if (gameSelectionInput.equals("SLOTS")) {
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
                        "[SLOTS] [ROULETTE] [COIN FLIP] [NUMBER GUESS] [21] [ROCK PAPER SCISSOR] \n" +
                        ">> ");
    }

    private CasinoAccount promptLogin(CasinoAccountManager cam) {
        String userName = console.getStringInput("Enter your username: ");
        String password = console.getStringInput("Enter your password: ");
        return cam.getAccount(userName, password);
    }

    private void welcome() {
        console.println("Welcome to the Trillium Casino! \n\n");
    }


}
