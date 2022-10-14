package ua.pp.voronin.serhii.tommy.systems;

public interface PaymentSystem {

    void initiateTransaction(Transaction transaction);

    TransactionStatus getTransactionStatus(Transaction transaction);
}
