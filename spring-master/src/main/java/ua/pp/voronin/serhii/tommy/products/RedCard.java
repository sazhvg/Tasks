package ua.pp.voronin.serhii.tommy.products;

import ua.pp.voronin.serhii.tommy.systems.PaymentSystem;
import ua.pp.voronin.serhii.tommy.systems.Transaction;

public class RedCard extends DebitCard {

    public RedCard(String alias, PaymentSystem paymentSystem) {
        super(alias, paymentSystem);
    }

    @Override
    public long getAvailableOverdraft() {
        return 100;
    }

    @Override
    public Transaction createTransaction() {
        // Creating transaction
        return null;
    }
}
