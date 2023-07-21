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

    @Test
    void testCompareResults() {
//        Given
        GameRoulette game = new GameRoulette();
        int bet = 10;
        int choice = 1;
        int spin = 1;
        int expected = 110;
//        When
        game.compareResults(bet, choice, spin);
        int actual = game.bank;
//        Then
        assertEquals(expected, actual);

    }


}