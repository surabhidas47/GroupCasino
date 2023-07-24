package com.github.zipcodewilmington.casino.games.roulette;

import org.junit.Assert;
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
    void play2(){
    GameRoulette game = new GameRoulette();
    int expected = 50;

    int actual = game.bank;

        Assert.assertNotEquals(expected,actual);
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
    void testGetSpin2(){
        GameRoulette game = new GameRoulette();
        int actual = game.getSpin();
        Assert.assertFalse(actual>38);
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
    @Test
    void testCompareResults2(){
//        Given
        GameRoulette game = new GameRoulette();
        int bet = 10;
        int choice = 2;
        int spin = 1;
        int expected = 90;
//        When
        game.compareResults(bet, choice, spin);
        int actual = game.bank;
//        then
        assertEquals(expected,actual);
    }
    @Test
    void testCompareResults3(){
//        Given
        GameRoulette game = new GameRoulette();
        int bet = 50;
        int choice = 1;
        int spin = 2;
        int expected = 50;
//        When
        game.compareResults(bet, choice, spin);
        int actual = game.bank;
//        then
        assertEquals(actual,expected);
    }
    @Test
    void testCompareResults4(){
//        Given
        GameRoulette game = new GameRoulette();
        int bet = 100;
        int choice = 1;
        int spin = 1;
        int expected = 100;
//        when
        game.compareResults(bet, choice, spin);
        int actual = game.bank;
//        then
        assertNotEquals(expected,actual);
    }


}