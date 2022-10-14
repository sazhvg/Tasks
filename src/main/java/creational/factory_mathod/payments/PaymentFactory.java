package creational.factory_mathod.payments;

import creational.factory_mathod.payments.plans.ImmediatePaymentPlan;
import creational.factory_mathod.payments.plans.PaymentPlan;
import creational.factory_mathod.payments.plans.TenYearsPaymentPlan;
import creational.factory_mathod.payments.plans.ThreeMonthsPaymentPlan;

public class PaymentFactory {

    public static PaymentPlan createPaymentPlan(PaymentType paymentType, long amount) {
        switch (paymentType) {
            case IMMEDIATE_FULL:
                return new ImmediatePaymentPlan(amount);
            case THREE_MONTH:
                return new ThreeMonthsPaymentPlan(amount);
            case TEN_YEARS:
                return new TenYearsPaymentPlan(amount);
        }
        throw new IllegalArgumentException("Unknown payment type");
    }
}
