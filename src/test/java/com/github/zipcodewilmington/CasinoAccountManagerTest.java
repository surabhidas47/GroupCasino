package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CasinoAccountManagerTest {

    CasinoAccount account = new CasinoAccount("Angela", "password", 1000);
    CasinoAccount account1 = new CasinoAccount("Bob", "pw", 2000);

    @Test
    public void testGetAccount() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        cam.registerAccount(account);
        CasinoAccount actual = cam.getAccount("Angela", "password");

        Assert.assertEquals(actual, account);
    }

    @Test
    public void testGetAccount2() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        cam.registerAccount(account1);
        CasinoAccount actual = cam.getAccount("Bob", "pw");

        Assert.assertEquals(actual, account1);
    }

    @Test
    public void testCreateAccount() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount expected = cam.createAccount("Bob", "pw", 2000);
        CasinoAccount actual = cam.getAccount("Bob", "pw");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateAccount2() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount expected = cam.createAccount("Angela", "password", 1000);
        CasinoAccount actual = cam.getAccount("Angela", "password");

        Assert.assertEquals(expected, actual);
    }

}
