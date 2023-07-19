package com.github.zipcodewilmington.casino;

public abstract class Player {

    protected CasinoAccount account;

    public Player(CasinoAccount account) {
        this.account = account;
    }

    public CasinoAccount getAccount() { // return/access account with this method
        return this.account;
    }

    public String getUsername() { // return/access username
        return this.account.getUserName();
    }

}
