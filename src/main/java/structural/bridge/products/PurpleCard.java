package structural.bridge.products;

import structural.bridge.systems.PaymentSystem;
import structural.bridge.systems.Transaction;

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
