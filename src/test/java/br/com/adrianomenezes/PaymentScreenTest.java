package br.com.adrianomenezes;

import br.com.adrianomenezes.assignments.PaymentScreenPage;
import br.com.adrianomenezes.factory.DriverFactory;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static br.com.adrianomenezes.PaymentScreenActions.*;


public class PaymentScreenTest {
    private WebDriver driver;
    private PaymentScreenPage p;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){

        this.driver = DriverFactory.getDriver(browser);
        this.p = new PaymentScreenPage(driver);
    }


    @Test
    public void buyWithPromoCodeFreeTest()  {

        p.goTo();
        p.applyPromoCode("FREEUDEMY");
        p.buyProduct();
        String status = p.getStatus();
        Assert.assertEquals("PASS",status);

        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);

    }

    @Test
    public void buyWithPromoCodeTest()  {

        p.goTo();
        p.applyPromoCode("PARTIALUDEMY");
        p.enterCC("4111111111111111","2023","123");
        p.buyProduct();
        String status = p.getStatus();
        Assert.assertEquals("PASS",status);

        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);

    }

    @Test
    public void buyWithCCTest()  {

        p.goTo();
        p.enterCC("4111111111111111","2023","123");
        p.buyProduct();
        String status = p.getStatus();
        Assert.assertEquals("PASS",status);

        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);

    }

    @Test
    public void cantBuyWithWrongCCTest()  {

        p.goTo();
        p.enterCC("4111222111111111","2023","123");
        p.buyProduct();
        String status = p.getStatus();
        Assert.assertEquals("FAIL",status);

        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);

    }

    @Test(dataProvider = "criteriaProvider")
    public void paymentScreenTest(Consumer<PaymentScreenPage> consumer) {

        p.goTo();
        consumer.accept(p);

        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);

    }

    @DataProvider(name="criteriaProvider")
    public Object[] testdata(){
        return new Object[]{
                validCC.andThen(buy).andThen(successfulPurchase),
                freeCoupom.andThen(buy).andThen(successfulPurchase),
                discountCoupom.andThen(validCC).andThen(buy).andThen(successfulPurchase),
                invalidCC.andThen(buy).andThen(failedPurchase),
                invalidCC.andThen(discountCoupom).andThen(buy).andThen(failedPurchase),
                buy.andThen(failedPurchase)
        };
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }
}
