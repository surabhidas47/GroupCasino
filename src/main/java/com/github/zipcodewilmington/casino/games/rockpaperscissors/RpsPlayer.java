package com.github.zipcodewilmington.casino.games.rockpaperscissors;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;


public class RpsPlayer extends Player {

    public RpsPlayer(CasinoAccount account) {
        super(account);
    }
    //account is passed to the constructor of the superclass(Player) setting up RpsPlayer object along with its casino account

    @Override
    public CasinoAccount getPlayerAccount() {
        return this.account;
    }

}
