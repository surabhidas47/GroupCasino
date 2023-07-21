package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.games.rockpaperscissors.RpsGame;
import com.github.zipcodewilmington.casino.games.rockpaperscissors.RpsPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Random;

public class RPSTest {

    @Test
    public void testIsWinner()  {
        CasinoAccount account = new CasinoAccount("Angela", "pw", 500);
        RpsPlayer player = new RpsPlayer(account);
        RpsGame game = new RpsGame(player);
        String user = "ROCK";
        String computer = "SCISSOR";
        boolean winner = game.isWinner(user, computer);

        Assert.assertTrue(winner);
    }

    @Test
    public void testIsWinner2()  {
        CasinoAccount account = new CasinoAccount("Angela", "pw", 500);
        RpsPlayer player = new RpsPlayer(account);
        RpsGame game = new RpsGame(player);
        String user = "ROCK";
        String computer = "PAPER";
        boolean winner = game.isWinner(user, computer);

        Assert.assertFalse(winner);
    }


}
