package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.Assert;
import org.junit.Test;

public class CasinoAccountTest {


    @Test
    public void getUserNameTest() {
        CasinoAccount account = new CasinoAccount("Angela", "password", 1000);
        String expected = "Angela";
        Assert.assertEquals(expected, account.getUserName());
    }

    @Test
    public void getUserNameTest2() {
        CasinoAccount account = new CasinoAccount("Linda", "pw", 500);
        String expected = "Linda";
        Assert.assertEquals(expected, account.getUserName());
    }

    @Test
    public void getUserNameTest3() {
        CasinoAccount account = new CasinoAccount("Bob", "password", 100);
        String expected = "Bob";
        Assert.assertEquals(expected, account.getUserName());
    }

    @Test
    public void getPasswordTest() {
        CasinoAccount account = new CasinoAccount("Angela", "password", 1000);
        String expected = "password";
        Assert.assertEquals(expected, account.getPassword());
    }

    @Test
    public void getPasswordTest2() {
        CasinoAccount account = new CasinoAccount("Linda", "apple", 1000);
        String expected = "apple";
        Assert.assertEquals(expected, account.getPassword());
    }

    @Test
    public void getPasswordTest3() {
        CasinoAccount account = new CasinoAccount("Angela", "cereal", 1000);
        String expected = "cereal";
        Assert.assertEquals(expected, account.getPassword());
    }

    @Test
    public void checkBalanceTest1() {
        CasinoAccount account = new CasinoAccount("Angela", "password", 1000);
        Assert.assertTrue(account.checkBalance(1000));
    }

    @Test
    public void checkBalanceTest2() {
        CasinoAccount account = new CasinoAccount("Angela", "password", 1000);
        Assert.assertTrue(account.checkBalance(500));
    }
}
