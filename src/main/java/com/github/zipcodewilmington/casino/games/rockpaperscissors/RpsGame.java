package com.github.zipcodewilmington.casino.games.rockpaperscissors;

import com.fasterxml.jackson.databind.util.ISO8601Utils;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Random;

public class RpsGame implements GameInterface {

    RpsPlayer player;
    String userChoice;
    String computerChoice;
    String playAgain;
    String[] choices = {"R", "P", "S"};

    private final IOConsole console = new IOConsole(AnsiColor.CYAN);

    public RpsGame(RpsPlayer player) {
        this.player = player;
    }

    @Override
    public void run() {

        displayInstructions();

        boolean play = true;
        while(play==true) {

            getUserChoice();

            getComputerChoice();

            displayResults(userChoice, computerChoice);

            playAgain();
            if(playAgain.equalsIgnoreCase("yes")) {
                play = true;
            } else if(playAgain.equalsIgnoreCase("no")) {
                play = false;
            }

        }

    }

    @Override
    public void displayInstructions() {
        console.println("   ++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                            "     Welcome to the Trillium's Rock Paper Scissor Game!\n" +
                            "   ++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
    }

    public String getUserChoice() {
        userChoice = console.getStringInput("\n     Enter your move: [R] for rock  [P] for paper  [S] for scissor");
        while(true) {
            if (!(userChoice.equalsIgnoreCase("R") || userChoice.equalsIgnoreCase("S") || userChoice.equalsIgnoreCase("P"))) {
                console.println(userChoice + " is not a valid move.");
            }
            break;
        }
       return userChoice.toUpperCase();
    }

    public String getComputerChoice() {
        computerChoice = choices[new Random().nextInt(choices.length)];
        return computerChoice;
//        Random random = new Random();
//        int number = random.nextInt(3);
//        computerChoice = choices[number];
//        return computerChoice;
    }


    public Boolean isWinner(String userChoice, String computerChoice) {
        return (userChoice.equalsIgnoreCase("R") && computerChoice.equalsIgnoreCase("S")) ||
                (userChoice.equalsIgnoreCase("P") && computerChoice.equalsIgnoreCase("R")) ||
                (userChoice.equalsIgnoreCase("S") && computerChoice.equalsIgnoreCase("P"));

    }

    public void displayResults(String userChoice, String computerChoice) {
        if (userChoice.equalsIgnoreCase(computerChoice)) {
            console.println("\n     It's a tie!\n");
        } else if (isWinner(userChoice, computerChoice)) {
            console.println("\n     You won!\n");
        } else {
            console.println("\n     You lost...\n");
//            player.getAccount().withdrawBalance(50);
        }
        console.println("     Your move: " + userChoice.toUpperCase() +
                                    "\n     Our move: " + computerChoice);
    }

    public String playAgain() {
        playAgain = console.getStringInput("\n     Would you like to play again? Enter [YES] or [NO]");
        return playAgain;
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

    @Override
    public void quit() {

    }

}
