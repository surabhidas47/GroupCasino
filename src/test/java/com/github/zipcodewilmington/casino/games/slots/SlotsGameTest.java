package com.github.zipcodewilmington.casino.games.slots;
import org.junit.Assert;
import org.junit.Test;


import java.util.Random;

public class SlotsGameTest {


    @Test
    public void testSpin(){
        Random random = new Random(1);
        SlotsGame sg = new SlotsGame();

        String [] result = sg.spin();

        String [] original = {"*STAR*", "*LUCK*", "*CASH*", "*PRAY*", "*HOPE*"};
        Assert.assertTrue(original != result);
    }

    @Test
    public void testPrintResultTrue1() {
        // Mock input for wordList with a match
        String[] wordList = {"*STAR*", "*STAR*", "*STAR*"};
        SlotsGame sg = new SlotsGame();

        // Call the method and capture the result
        boolean result = sg.checkMatch(wordList);

        // Assert the expected result with the actual result
        Assert.assertTrue(result);

    }

    @Test
    public void testPrintResultTrue2() {
        // Mock input for wordList with a match
        String[] wordList = {"*PRAY*", "*PRAY*", "*PRAY*"};
        SlotsGame sg = new SlotsGame();

        // Call the method and capture the result
        boolean result = sg.checkMatch(wordList);

        // Assert the expected result with the actual result
        Assert.assertTrue(result);

    }

    @Test
    public void testPrintResultFalse1() {
        // Mock input for wordList with a match
        String[] wordList = {"word", "bloop", "word"};
        SlotsGame sg = new SlotsGame();

        // Call the method and capture the result
        boolean result = sg.checkMatch(wordList);

        // Assert the expected result with the actual result
        Assert.assertFalse(result);


    }

    @Test
    public void testPrintResultFalse2() {
        // Mock input for wordList with a match
        String[] wordList = {"word", "bloop", "bloop"};
        SlotsGame sg = new SlotsGame();

        // Call the method and capture the result
        boolean result = sg.checkMatch(wordList);

        // Assert the expected result with the actual result
        Assert.assertFalse(result);


    }




}
