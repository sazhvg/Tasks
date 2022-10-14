package ua.pp.voronin.serhii.tommy.products;

import ua.pp.voronin.serhii.tommy.model.Account;
import ua.pp.voronin.serhii.tommy.systems.PaymentSystem;
import ua.pp.voronin.serhii.tommy.systems.Transaction;
import ua.pp.voronin.serhii.tommy.systems.TransactionStatus;

public abstract class DebitCard {

    private String alias;
    protected PaymentSystem paymentSystem;

    public DebitCard(String alias, PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public void performTransfer(Account from, Account to, long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Improper transfer request");
        }
        if (from.getAmount() + getAvailableOverdraft() < amount) {
            throw new IllegalStateException("Insufficient funds");
        }
        Transaction transaction = createTransaction();
        paymentSystem.initiateTransaction(transaction);
        int statusChecksCount = 0;
        while (!isTransactionComplete(transaction)) {
            try {
                Thread.sleep((long) Math.pow(100, statusChecksCount));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (paymentSystem.getTransactionStatus(transaction) == TransactionStatus.COMPLETED_SUCCESSFULLY) {
            from.setAmount(from.getAmount() - amount);
            to.setAmount(to.getAmount() + amount);
        }
    }

    private boolean isTransactionComplete(Transaction transaction) {
        TransactionStatus transactionStatus = paymentSystem.getTransactionStatus(transaction);
        return transactionStatus == TransactionStatus.COMPLETED_SUCCESSFULLY ||
                transactionStatus == TransactionStatus.REJECTED ||
                transactionStatus == TransactionStatus.FAILED;

    }

    public abstract long getAvailableOverdraft();

    public abstract Transaction createTransaction();
}
