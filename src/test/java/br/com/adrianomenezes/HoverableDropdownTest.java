package br.com.adrianomenezes;

import br.com.adrianomenezes.factory.DriverFactory;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import javax.swing.*;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class HoverableDropdownTest {

    private WebDriver driver;
    private Actions actions;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
        this.actions = new Actions(driver);
    }

    @Test(dataProvider = "linkProvider")
    public void hoverDropdownTest(String path) {

        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/drop-down.html#");
        String[] split = path.split("=>");
        Arrays.stream(split)
                .map(s -> s.strip())
                .map(s -> By.linkText(s))
                .map(by -> driver.findElement(by))
                .map(ele -> actions.moveToElement(ele))
                .forEach(actions1 -> actions1.perform());

        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
    }

    @DataProvider(name = "linkProvider")
    public Object[] testData() {
        return new Object[] {
                "Dropdown =>  Dropdown Link 2",
                "Dropdown =>  Dropdown Link 5 => Dropdown Submenu Link 5.1",
                "Dropdown =>  Dropdown Link 5 => Dropdown Submenu Link 5.4 => Dropdown Submenu Link 5.4.2"
        };
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }
}
