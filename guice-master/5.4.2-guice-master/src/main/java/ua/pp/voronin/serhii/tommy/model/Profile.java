package ua.pp.voronin.serhii.tommy.model;

import ua.pp.voronin.serhii.tommy.products.DebitCard;

import java.util.List;

public class Profile {

    private String name;
    private String lastName;
    private List<DebitCard> cards;
    private List<Account> accounts;

    public Profile(String name, String lastName, List<DebitCard> cards) {
        this.name = name;
        this.lastName = lastName;
        this.cards = cards;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
