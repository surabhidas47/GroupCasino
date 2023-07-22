package com.github.zipcodewilmington.casino.games.slots;
import org.junit.Assert;
import org.junit.Test;


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






}
