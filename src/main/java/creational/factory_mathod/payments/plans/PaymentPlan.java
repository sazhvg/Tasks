package creational.factory_mathod.payments.plans;

import java.time.ZonedDateTime;

public interface PaymentPlan {

    ZonedDateTime getNextPaymentDate(ZonedDateTime forDate);

    long getNextPaymentAmount();
}
