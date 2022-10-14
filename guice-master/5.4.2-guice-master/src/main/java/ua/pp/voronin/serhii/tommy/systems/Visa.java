package ua.pp.voronin.serhii.tommy.systems;

import ua.pp.voronin.serhii.tommy.systems.client.VisaClient;

import javax.inject.Inject;

public class Visa implements PaymentSystem {

    @Inject
    private VisaClient client;

    @Override
    public void initiateTransaction(Transaction transaction) {
        client.interactWithVisa();
    }

    @Override
    public TransactionStatus getTransactionStatus(Transaction transaction) {
        client.interactWithVisa();
        return null;
    }
}
