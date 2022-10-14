package structural.bridge.systems;

public class Visa implements PaymentSystem {

    @Override
    public void initiateTransaction(Transaction transaction) {
        // Do what visa does
    }

    @Override
    public TransactionStatus getTransactionStatus(Transaction transaction) {
        // Do what visa does
        return null;
    }
}
