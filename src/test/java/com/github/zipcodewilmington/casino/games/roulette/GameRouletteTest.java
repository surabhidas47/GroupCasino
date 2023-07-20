package com.github.zipcodewilmington.casino.games.roulette;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRouletteTest {



    @Test
    void play() {
//        Given
        GameRoulette game = new GameRoulette();
        int expected = 100;
//        When
        int actual = game.bank;
//        Then
        assertEquals(expected, actual);
    }
    @Test
    void testGetSpin() {
//        Given
        GameRoulette game = new GameRoulette();
//      When
        int actual = game.getSpin();
//        Then
        assertTrue(actual >= 0 && actual <= 37);
    }

//    @Test
//    void testGetBet() {
////        Given
//        GameRoulette game = new GameRoulette();
////      When
//        int actual = game.getBet();
////        Then
//        assertTrue(actual >= 0 && actual <= 100);
//    }

}