package br.com.adrianomenezes;


import br.com.adrianomenezes.factory.DriverFactory;
import br.com.adrianomenezes.util.LinkUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
public class BrokenLinkTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
    }

    // https://the-internet.herokuapp.com/broken_images

    @Test
    public void linkTest() {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");

        System.out.println("Before :: " + LocalDateTime.now());

//
                this.driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .parallel()
                .map(e -> e.getAttribute("src"))
                .forEach(src -> {
                    System.out.println(LinkUtil.getResponseCode(src) + " :: " + src);
                });
//                .parallel()
//                .map(e -> e.getAttribute("src"))
//                .filter(src -> LinkUtil.getResponseCode(src) != 200)
//                .collect(Collectors.toList());

        System.out.println("After :: " + LocalDateTime.now());
    }

    @Test
    public void linkTest2() {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");

        System.out.println("Before :: " + LocalDateTime.now());

        this.driver.findElements(By.xpath("//*[@href]"))
                .stream()
                .parallel()
                .map(e -> e.getAttribute("href"))
                .forEach(src -> {
                    System.out.println(LinkUtil.getResponseCode(src) + " :: " + src);
                });

        System.out.println("After :: " + LocalDateTime.now());
    }

    @Test
    public void linkTest3() {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");

        System.out.println("Before :: " + LocalDateTime.now());

        Boolean returned = this.driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .parallel()
                .map(e -> e.getAttribute("src"))
                .map(src -> LinkUtil.getResponseCode(src))
                .anyMatch(rc -> rc != 200);

        Assert.assertFalse(returned);
        System.out.println("After :: " + LocalDateTime.now());
    }

    @Test
    public void linkTest4() {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");

        System.out.println("Before :: " + LocalDateTime.now());

        List<String> returned = this.driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .parallel()
                .map(e -> e.getAttribute("src"))
                .filter(src -> LinkUtil.getResponseCode(src) != 200)
                .collect(Collectors.toList());

        Assert.assertEquals(returned.size(), 0 , returned.toString());
        //        returned.stream().forEach(System.out::println);
        System.out.println("After :: " + LocalDateTime.now());
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }
}
