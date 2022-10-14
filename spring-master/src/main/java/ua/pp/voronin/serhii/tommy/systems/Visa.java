package ua.pp.voronin.serhii.tommy.systems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.pp.voronin.serhii.tommy.systems.client.VisaClient;

@Component
public class Visa implements PaymentSystem {

    @Autowired
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
