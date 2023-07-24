package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.CoinToss.CoinTossGame;
import com.github.zipcodewilmington.casino.games.CoinToss.CoinTossPlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class CoinTossTest {

@Test
    public void testTheToss1(){
    CasinoAccount account = new CasinoAccount("Surahi", "das", 100);
    CoinTossPlayer player = new CoinTossPlayer(account);
    CoinTossGame ct = new CoinTossGame(player);
    int result = ct.theToss();

    Assertions.assertTrue(result ==0||result ==1);


}

    @Test
    public void testTheToss2(){
        CasinoAccount account = new CasinoAccount("Surahi", "das", 100);
        CoinTossPlayer player = new CoinTossPlayer(account);
        CoinTossGame ct = new CoinTossGame(player);
        int result = ct.theToss();

        Assertions.assertFalse(result !=0||result ==1);


    }

    @Test
    public void testTheToss3(){
        CasinoAccount account = new CasinoAccount("Surahi", "das", 100);
        CoinTossPlayer player = new CoinTossPlayer(account);
        CoinTossGame ct = new CoinTossGame(player);
        int result = ct.theToss();

        Assertions.assertTrue(result ==0||result !=1);

    }




}
