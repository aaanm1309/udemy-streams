package br.com.adrianomenezes.factory;

import com.google.common.base.Supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static final Supplier<WebDriver> chromeSupplier = () -> {
        System.setProperty("webdriver.chrome.driver", "/Adriano/cursos/udemy/NewStream/src/main/java/br/com/adrianomenezes/chromedriver/chromedriver.exe");

        return new ChromeDriver();
    };

    private static final Supplier<WebDriver> firefoxSupplier = () -> {
        System.setProperty("webdriver.gecko.driver", "/home/qa/.arquillian/drone/firefox/geckodriver");
        return new FirefoxDriver();
    };

//    private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();
//
//    static {
//        MAP.put("chrome", chromeSupplier);
//        MAP.put("firefox", firefoxSupplier);
//    }
    private static final Map<String, Supplier<WebDriver>> MAP = Map.of(
            "chrome", chromeSupplier,
            "firefox", firefoxSupplier
    );


    public static WebDriver getDriver(String browser){
        return MAP.get(browser).get();
    }

}
