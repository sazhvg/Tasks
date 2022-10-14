package ua.pp.voronin.serhii.tommy.products;

import ua.pp.voronin.serhii.tommy.systems.PaymentSystem;
import ua.pp.voronin.serhii.tommy.systems.Transaction;

public class PurpleCard extends DebitCard {

    public PurpleCard(String alias, PaymentSystem paymentSystem) {
        super(alias, paymentSystem);
    }

    @Override
    public long getAvailableOverdraft() {
        return 0;
    }

    @Override
    public Transaction createTransaction() {
        // Creating transaction
        return null;
    }
}
