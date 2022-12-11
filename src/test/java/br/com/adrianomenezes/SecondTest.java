package br.com.adrianomenezes;

import br.com.adrianomenezes.factory.DriverFactory;
import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;


public class SecondTest extends TestCase {

    private WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void setDriver(@Optional("chrome") String browser){
	}

    public void testApp() throws MalformedURLException {
        this.driver = DriverFactory.getDriver("chrome");
		this.driver.get("https://google.com/");
		this.driver.findElements(By.tagName("a"))
				.stream()
				.map(WebElement::getText)
				.map(String::trim)
				.filter(e -> e.length() > 0)
				.filter(e -> !e.toLowerCase().contains("s"))
				.map(String::toUpperCase)
				.forEach(System.out::println);
    }

}
