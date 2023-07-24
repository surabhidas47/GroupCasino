package com.github.zipcodewilmington.casino.games.slots;
import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.Assert;
import org.junit.Test;

import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;


import java.util.Random;

public class SlotsGameTest {

    @Test
    public void testSpin1(){
        //checking shuffled array not empty
        SlotsGame sg = new SlotsGame();

        String [] shuffle = sg.spin();

        Assert.assertNotNull(shuffle);
    }

    @Test
    public void testSpin2(){
        //checking length of arrays equal
        SlotsGame sg = new SlotsGame();

        String [] original = {"*STAR*", "*LUCK*", "*CASH*", "*PRAY*", "*HOPE*"};
        String [] shuffle = sg.spin();

        Assert.assertEquals(original.length, shuffle.length);
    }

    @Test
    public void testSpin3(){
        //checking actual contents of shuffle array is diff than the shuffled
        SlotsGame sg = new SlotsGame();

        String [] original = {"*STAR*", "*LUCK*", "*CASH*", "*PRAY*", "*HOPE*"};
        String [] shuffle = sg.spin();

        Assert.assertNotEquals(original, shuffle);
    }

    @Test
    public void testCheckMatch1(){
        //checking that if first three index
        SlotsGame sg = new SlotsGame();

        String [] original = {"*STAR*", "*STAR*", "*STAR*" };

        boolean result = sg.checkMatch(original);

        Assert.assertTrue(result);
    }

    @Test
    public void testCheckMatch2(){
        //checking that
        SlotsGame sg = new SlotsGame();

        String [] original = {"*LUCK*", "*STAR*", "*STAR*" };

        boolean result = sg.checkMatch(original);

        Assert.assertFalse(result);
    }

    @Test
    public void testCheckMatch3(){
        //checking that
        SlotsGame sg = new SlotsGame();

        String [] original = {"*LUCK*", null, "*STAR*" };

        boolean result = sg.checkMatch(original);

        Assert.assertFalse(result);
    }

    @Test
    public void testCheckMatch4(){
        //checking that
        SlotsGame sg = new SlotsGame();

        String [] original = {"*LUCK*", "*PRAY*", "*STAR*" };

        boolean result = sg.checkMatch(original);

        Assert.assertFalse(result);
    }




}
