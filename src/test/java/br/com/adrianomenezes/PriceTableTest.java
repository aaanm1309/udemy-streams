package br.com.adrianomenezes;

import br.com.adrianomenezes.assignments.PriceTable;
import br.com.adrianomenezes.factory.DriverFactory;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class PriceTableTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){

        this.driver = DriverFactory.getDriver(browser);
    }


    @Test
    public void minPriceTest() throws MalformedURLException {
        PriceTable p = new PriceTable(driver);
        p.selectMinPriceRow();
        String status = p.getStatus();
        Assert.assertEquals("PASS",status);

        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);


    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }
}
