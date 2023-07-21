package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 */
public interface GameInterface extends Runnable {


    void add(Player player); //add player to game

    void remove(Player player);// remove player from game

    void displayInstructions(); // display instruction for game

    Boolean checkWinner(); // compare to see if user won/lost


    void quit(); // exit game
    void run(); //specifies how game will run
}
