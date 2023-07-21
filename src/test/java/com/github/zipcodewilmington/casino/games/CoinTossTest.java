package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.casino.games.CoinToss.CoinTossGame;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class CoinTossTest {

@Test
    public void testTheToss1(){

    CoinTossGame ct = new CoinTossGame();
    int result = ct.theToss();

    Assertions.assertTrue(result ==0||result ==1);


}
//@Test
//public void testTheTossSecific(){
//    CoinTossGame ct = new CoinTossGame();
//    int result = ct.theToss();
//
//     Assertions.assertTrue(result ==0||result ==1,"The res")
//
//
//
//
//
//}
//






}
