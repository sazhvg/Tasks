package ua.pp.voronin.serhii.tommy.systems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.pp.voronin.serhii.tommy.systems.client.McClient;

@Component
public class MasterCard implements PaymentSystem {

    @Autowired
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
