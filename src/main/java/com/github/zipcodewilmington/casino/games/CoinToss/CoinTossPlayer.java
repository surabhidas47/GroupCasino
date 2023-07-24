package com.github.zipcodewilmington.casino.games.CoinToss;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;

public class CoinTossPlayer extends Player {
    public CoinTossPlayer(CasinoAccount account) {super(account);}

    @Override
    public CasinoAccount getPlayerAccount() {
        return this.account;
    }


}
