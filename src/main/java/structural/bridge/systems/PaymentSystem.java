package structural.bridge.systems;

public interface PaymentSystem {

    void initiateTransaction(Transaction transaction);

    TransactionStatus getTransactionStatus(Transaction transaction);
}
