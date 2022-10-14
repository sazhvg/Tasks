package creational.factory_mathod.payments.plans;

import java.time.ZonedDateTime;

public class TenYearsPaymentPlan implements PaymentPlan {

    private final long totalAmount;

    public TenYearsPaymentPlan(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public ZonedDateTime getNextPaymentDate(ZonedDateTime forDate) {
        return forDate.withDayOfYear(1)
                .plusYears(1);
    }

    @Override
    public long getNextPaymentAmount() {
        return totalAmount / 10;
    }
}
