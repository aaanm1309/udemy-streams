package br.com.adrianomenezes;

import junit.framework.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class FirstTest extends TestCase {


    public void testApp() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserVersion", "67");
        chromeOptions.setCapability("platformName", "Windows XP");
        WebDriver driver = new RemoteWebDriver(new URL("https://www.google.com"), chromeOptions);
        driver.get("http://www.google.com");
        driver.quit();
    }

}
