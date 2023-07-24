package com.github.zipcodewilmington.casino;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Set;


/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {

    private HashMap<String, CasinoAccount> accounts;
    private Path file = Paths.get("accounts.txt"); //creates object used to locate file in file system

    public CasinoAccountManager() throws IOException {
        this.accounts = new HashMap<>(); // hashmap containing username as key, and account info as value
        BufferedReader reader = Files.newBufferedReader(this.file); //BufferReader to read file
        String line; // used to store line when reading through file
        while ((line = reader.readLine()) != null) { //while there is a line for BufferReader to read
            String[] accountInfo = line.split(" "); //split words at whitespace
            // create new user account and add information
            CasinoAccount account = new CasinoAccount(accountInfo[0], accountInfo[1], Integer.parseInt(accountInfo[2])); //returns an integer given a string representation
            this.accounts.put(account.getUserName(), account); //store username account info into accounts hashmap
        }

    }

    public CasinoAccount getAccount(String username, String password) {
        if (this.accounts.containsKey(username)) { //check if username key exists in the accounts hashmap
            CasinoAccount account = this.accounts.get(username); // if it exists, get the account 
            if (account.getPassword().equals(password)) {
                return account; // return account if the given password equals the password associated with the username key
            }
        }
        return null; // else return null
    }

    public CasinoAccount createAccount(String username, String password, int balance) {
        if (this.accounts.containsKey(username)) { // if username already exists in accounts, return null
            return null;
        } else {
            CasinoAccount newAccount = new CasinoAccount(username, password, balance);
            this.accounts.put(username, newAccount); //store username as key and the entire new account as value in accounts hashmap
            return newAccount; // else if account doesn't exist, return newly created account
        }
    }

    public void registerAccount(CasinoAccount account) {
        this.accounts.put(account.getUserName(), account); // add new account with username as key to the accounts hashmap
    }

    public Set<String> getAccountUsername() {
        return accounts.keySet(); // return a set of usernames (keys)
    }

    public void updateAccounts() throws IOException {
        String info = ""; // adding updated balance info to existing account
        for(HashMap.Entry<String, CasinoAccount> entry : this.accounts.entrySet()) { //this is an enhanced for loop
            //update each account in accounts with current balance information and store in "info"
            info += entry.getValue().getUserName() + " " + entry.getValue().getPassword() + " " + entry.getValue().getBalance() + "\n";
        }
        byte[] infoToAdd = info.getBytes(); //create byte array and store string "info" as bytes
        Files.write(this.file, infoToAdd); //add infoToAdd to the file accounts.txt
    }

}




