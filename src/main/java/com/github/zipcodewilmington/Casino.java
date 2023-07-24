package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;

import com.github.zipcodewilmington.casino.games.CoinToss.CoinTossGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import com.github.zipcodewilmington.casino.games.rockpaperscissors.RpsGame;
import com.github.zipcodewilmington.casino.games.rockpaperscissors.RpsPlayer;
import com.github.zipcodewilmington.casino.games.roulette.GameRoulette;
import com.github.zipcodewilmington.casino.games.roulette.PlayerRoulette;
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
                    console.println("\n   Create an account here! \n");
                    String userName = console.getStringInput("\nEnter your account username: ");
                    String userPassword = console.getStringInput("Enter your account password: ");
                    Integer userBalance = console.getIntegerInput("Enter the dollar amount of money you would like to add to your account: ");
                    if (casinoAccountManager.getAccountUsername().contains(userName)) {
                        System.out.println("\n   This username already exists\n");
                    } else {
                        casinoAccountManager.createAccount(userName, userPassword, userBalance);
                        casinoAccountManager.updateAccounts();
                        System.out.println("\n   Account successfully created\n");
                    }
                    break;

                case "SELECT GAME":
                    String gameSelectionInput = getGameSelectionInput();
                    switch (gameSelectionInput) {
                        case "ROCK PAPER SCISSOR":
                        case "rock paper scissor":
                        case "5":
                        case "NUMBER GUESS":
                        case "number guess":
                        case "4":
                        case "SLOTS":
                        case "slots":
                        case "1":
                        case "ROULETTE":
                        case "roulette":
                        case "2":
                        case "COIN TOSS":
                        case "coin toss":
                        case "3":
                            // log in user account
                            CasinoAccount userAccount = promptLogin(casinoAccountManager);
                            if (userAccount == null) {
                                console.println("\n   No account found with that username and password. " +
                                        "Redirecting to the main menu.\n");
                                break;
                            }

                            if (gameSelectionInput.equals("ROCK PAPER SCISSOR") || gameSelectionInput.equals("rock paper scissor") || gameSelectionInput.equals("5")) {
                                RpsPlayer player = new RpsPlayer(userAccount);
                                new RpsGame(player).run();
                            } else if (gameSelectionInput.equals("NUMBER GUESS") || gameSelectionInput.equals("number guess") || gameSelectionInput.equals("4")) {
//                                NumberGuessPlayer nplayer = new NumberGuessPlayer(userAccount);
//                                new NumberGuessGame(nplayer).run();
                            } else if (gameSelectionInput.equals("SLOTS") || gameSelectionInput.equals("1") || gameSelectionInput.equals("slots")) {
//                                SlotsPlayer splayer = new SlotsPlayer(userAccount);
//                                new SlotsGame(splayer).run();
                            } else if (gameSelectionInput.equals("COIN TOSS") || gameSelectionInput.equals("coin toss") || gameSelectionInput.equals("3")) {
                                new CoinTossGame().run();
                            } else {
                                new GameRoulette().run();
                            }
                            casinoAccountManager.updateAccounts();
                            break;


                            }

                    }
            }
            while (!"EXIT".equalsIgnoreCase(arcadeDashBoardInput)) ;
        }



    private String getArcadeDashboardInput() {
        return console.getStringInput(
                "\n           Select an option: \n" +
                        "[CREATE ACCOUNT]  [SELECT GAME]  [EXIT] ");
    }

    private String getGameSelectionInput() {
        return console.getStringInput(
                "\n\n               Select any of the following games: \n" +
                        "[1]SLOTS [2]ROULETTE [3]COIN TOSS [4]NUMBER GUESS [5]ROCK PAPER SCISSOR ");

    }

    private CasinoAccount promptLogin(CasinoAccountManager cam) {
        String userName = console.getStringInput("\nEnter your username: ");
        String password = console.getStringInput("Enter your password: ");
        return cam.getAccount(userName, password);
    }

    private void welcome() {
        console.println(" +++++++++++++++++++++++++++++++++++++++++\n" +
                            "   +++++++++++++++++++++++++++++++++++++\n" +
                            "      Welcome to the Trillium Casino!\n" +
                            "   +++++++++++++++++++++++++++++++++++++\n" +
                            " +++++++++++++++++++++++++++++++++++++++++\n");
    }



}
