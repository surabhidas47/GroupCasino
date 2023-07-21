package com.github.zipcodewilmington.casino.games.rockpaperscissors;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;


public class RpsPlayer extends Player{

    public RpsPlayer(CasinoAccount account) {
        super(account);
    }


    @Override
    public CasinoAccount getPlayerAccount() {
        return this.account;
    }
}
