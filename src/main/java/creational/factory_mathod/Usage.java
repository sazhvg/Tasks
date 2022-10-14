package creational.factory_mathod;

import creational.factory_mathod.payments.PaymentFactory;
import creational.factory_mathod.payments.plans.PaymentPlan;
import creational.factory_mathod.payments.PaymentType;

import java.time.ZonedDateTime;

public class Usage {

    public static final long SAMPLE_PRICE = 199;

    public static void main(String[] args) {
        if (args == null || args.length < 1) {
            throw new IllegalArgumentException("Expected at least one argument");
        }

        for (String paymentTypeArg : args) {
            PaymentType paymentType = PaymentType.valueOf(paymentTypeArg);
            PaymentPlan paymentPlan = PaymentFactory.createPaymentPlan(paymentType, SAMPLE_PRICE);

            System.out.println(paymentPlan.getNextPaymentAmount());
            System.out.println(paymentPlan.getNextPaymentDate(ZonedDateTime.now()));
        }
    }

}
