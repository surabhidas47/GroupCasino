package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class PlayerRoulette extends Player {

    public PlayerRoulette(CasinoAccount account){
        super(account);
    }

    @Override
    public CasinoAccount getPlayerAccount() {
        return this.account;
    }
}
