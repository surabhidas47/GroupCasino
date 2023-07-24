package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CasinoAccountManagerTest {

    CasinoAccount account = new CasinoAccount("Angela", "password", 1000);
    CasinoAccount account1 = new CasinoAccount("Bob", "pw", 2000);
    CasinoAccount account2 = new CasinoAccount("Linda", "pw", 500);

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
    public void testGetAccount3() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        cam.registerAccount(account2);
        CasinoAccount actual = cam.getAccount("Linda", "pw");

        Assert.assertEquals(actual, account2);
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

    @Test
    public void testCreateAccount3() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount expected = cam.createAccount("Linda", "pw", 500);
        CasinoAccount actual = cam.getAccount("Linda", "pw");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetUsernames() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account1 = cam.createAccount("Linda", "pw", 500);
        CasinoAccount account2 = cam.createAccount("Bob", "pw", 1500);
        cam.registerAccount(account1);
        cam.registerAccount(account2);
        int expected = 10;
        int actual = cam.getAccountUsername().size();


        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetUsernames2() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        int expected = 8;
        int actual = cam.getAccountUsername().size();


        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetUsernames3() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account1 = cam.createAccount("Linda", "pw", 500);
        CasinoAccount account2 = cam.createAccount("Bob", "pw", 1500);
        CasinoAccount account3 = cam.createAccount("Tina", "pw", 1500);
        cam.registerAccount(account1);
        cam.registerAccount(account2);
        cam.registerAccount(account3);
        int expected = 11;
        int actual = cam.getAccountUsername().size();


        Assert.assertEquals(expected, actual);
    }
}
