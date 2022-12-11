package br.com.adrianomenezes;

import br.com.adrianomenezes.assignments.PaymentScreenPage;
import org.testng.Assert;

import java.util.function.Consumer;

public class PaymentScreenActions {
    public static final Consumer<PaymentScreenPage> freeCoupom =
            p ->  p.applyPromoCode("FREEUDEMY");

    public static final Consumer<PaymentScreenPage> discountCoupom =
            p ->  p.applyPromoCode("PARTIALUDEMY");

    public static final Consumer<PaymentScreenPage> validCC =
            p -> p.enterCC("4111111111111111","2023","123");

    public static final Consumer<PaymentScreenPage> invalidCC =
            p -> p.enterCC("4111222111111111","2023","123");

    public static final Consumer<PaymentScreenPage> buy =
            p -> p.buyProduct();

//    public static final Consumer<PaymentScreenPage> goTo =
//            p -> p.goTo();

    //validations
    public static final Consumer<PaymentScreenPage> successfulPurchase =
            p -> Assert.assertEquals(p.getStatus(),"PASS");
    public static final Consumer<PaymentScreenPage> failedPurchase =
            p -> Assert.assertEquals(p.getStatus(),"FAIL");
}
