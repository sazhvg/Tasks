package creational.factory_mathod.payments.plans;

import java.time.ZonedDateTime;

public class ThreeMonthsPaymentPlan implements PaymentPlan {

    private final long totalAmount;

    public ThreeMonthsPaymentPlan(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public ZonedDateTime getNextPaymentDate(ZonedDateTime forDate) {
        return forDate.withDayOfMonth(1)
                .plusMonths(1);
    }

    @Override
    public long getNextPaymentAmount() {
        return totalAmount / 3;
    }
}
