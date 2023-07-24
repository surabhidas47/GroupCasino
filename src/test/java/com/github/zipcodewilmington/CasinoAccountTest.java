package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

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

    @Test
    public void testGetBalance() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Linda", "pw", 500);
        Integer expected = 500;
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBalance2() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 1000);
        Integer expected = 1000;
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBalance3() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 2000);
        Integer expected = 2000;
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetBalance() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 2000);
        Integer expected = 2000;
        account.setBalance(expected);
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetBalance2() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 800);
        Integer expected = 800;
        account.setBalance(expected);
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetBalance3() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 300);
        Integer expected = 300;
        account.setBalance(expected);
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddBalance() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 1500);
        Integer expected = 2000;
        account.addBalance(500);
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddBalance2() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 500);
        Integer expected = 2000;
        account.addBalance(1500);
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddBalance3() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 800);
        Integer expected = 5200;
        account.addBalance(4400);
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWithdrawBalance() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 1500);
        Integer expected = 1000;
        account.withdrawBalance(500);
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWithdrawBalance2() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 1500);
        Integer expected = 500;
        account.withdrawBalance(1000);
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWithdrawBalance3() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 2800);
        Integer expected = 2200;
        account.withdrawBalance(600);
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCheckBalance() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 1500);
        Integer bet = 1000;

        Assert.assertTrue(account.checkBalance(bet));
    }

    @Test
    public void testCheckBalance2() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 1500);
        Integer bet = 1500;

        Assert.assertTrue(account.checkBalance(bet));
    }

    @Test
    public void testCheckBalance3() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 1500);
        Integer bet = 2000;

        Assert.assertFalse(account.checkBalance(bet));
    }

    @Test
    public void testCheckBalance4() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 1500);
        Integer bet = 1501;

        Assert.assertFalse(account.checkBalance(bet));
    }
}
