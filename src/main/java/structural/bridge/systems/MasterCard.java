package structural.bridge.systems;

public class MasterCard implements PaymentSystem {

    @Override
    public void initiateTransaction(Transaction transaction) {
        // Do what MasterCard does
    }

    @Override
    public TransactionStatus getTransactionStatus(Transaction transaction) {
        // Do what MasterCard does
        return null;
    }
}
