package com.github.zipcodewilmington.casino.games.numberguess;

/**
 * Created by leon on 7/21/2020.
 */
import java.util.Scanner;
public class NumberGuessGame {
        private Player player;
        private Scanner scanner;
        private int targetNumber;
         private int numberOfTries;

        public NumberGuessGame() {
            this.scanner = new Scanner(System.in);
            this.numberOfTries = 3;
        }

        public void add(Player player) {
            this.player = player;
        }

        public void run() {
            System.out.println(displayInstructions());
            boolean playAgain = true;
            while (playAgain) {
                targetNumber = (int) (Math.random() * 10) + 1; // Generate a random number between 1 and 10
                numberOfTries = 3;
                boolean isWinner = false;

                while (!isWinner && numberOfTries > 0) {
                    int userGuess = getUserGuess();
                    isWinner = checkWinner(userGuess);
                    numberOfTries--;
                    if (isWinner) {
                        System.out.println("Congratulations!!!! You LUCKILY guessed the right number: " + targetNumber);
                    } else if (numberOfTries > 0) {
                        System.out.println("Better Luck Next Time!");
                    }
                    else {
                        System.out.println("Out of attempts! The number was " + targetNumber);
                    }

                }

                playAgain = playAgain();
            }
            quit();
        }

        public String displayInstructions() {
            return "Welcome to the rigged for our casino Number Guessing Game!!!! Try to guess the number between 1 and 10.";
        }

        public int getUserGuess() {
            System.out.print("Waste Your Money On A Guess: ");
            return scanner.nextInt();
        }

        public boolean checkWinner(int userGuess) {
            if (userGuess == targetNumber) {
                return true;
            } else if (userGuess < targetNumber) {
                System.out.println("Seriously? Try Higher!");
            } else {
                System.out.println("Try going lower");
            }
            return false;
        }

        public boolean playAgain() {
            System.out.print("Play Again? (yup/nah): ");
            String playAgainChoice = scanner.next().toLowerCase();
            return playAgainChoice.equals("yup");
        }

        public void quit() {
            System.out.println("Thank you for playing, Stop quitting everything!");
            scanner.close();
        }

        public static void main(String[] args) {
            NumberGuessGame game = new NumberGuessGame();
            Player player = new Player();
            game.add(player);
            game.run();
        }
    }

    class Player {
        // You can add additional methods or attributes specific to the player here
    }

