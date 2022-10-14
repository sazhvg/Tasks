package structural.bridge.products;

import structural.bridge.systems.PaymentSystem;
import structural.bridge.systems.Transaction;

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
