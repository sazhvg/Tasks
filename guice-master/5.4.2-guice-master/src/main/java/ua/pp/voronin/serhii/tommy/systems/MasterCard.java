package ua.pp.voronin.serhii.tommy.systems;

import ua.pp.voronin.serhii.tommy.systems.client.McClient;

import javax.inject.Inject;

public class MasterCard implements PaymentSystem {

    @Inject
    private McClient client;

    @Override
    public void initiateTransaction(Transaction transaction) {
        client.interact();
    }

    @Override
    public TransactionStatus getTransactionStatus(Transaction transaction) {
        client.interact();
        return null;
    }
}
