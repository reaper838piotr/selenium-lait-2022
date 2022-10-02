import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestFive {

    public ChromeDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public void setupWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }

    @Test
    public void sumIntegers() {
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");

        driver.findElement(By.id("sum1")).sendKeys("2");
        driver.findElement(By.id("sum2")).sendKeys("5");
        driver.findElement(By.xpath("//*[@id='gettotal']/button")).click();


//        boolean result = driver.findElement(By.xpath("//*[@id=\'addmessage\']")).isDisplayed();
        String result = driver.findElement(By.xpath("//*[@id=\'addmessage\']")).getText();
        System.out.println(result);
        //Assert.assertEquals("9", result);
    }

    @Test
    public void selectCheckBox() {
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().window().maximize();


        //Uruchom strone
        driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");

        //Przeslij wartosci i kliknij przycisk
        driver.findElement(By.id("isAgeSelected")).click();

        //Zweryfikuj rezultat
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='txtAge']"))));
        Boolean message_is_displayed = driver.findElement(By.xpath("//div[@id='txtAge']")).isDisplayed();
        Assert.assertTrue(message_is_displayed);
    }

        @Test
        public void testLocalFile() {
            driver.get("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
            driver.findElement(By.xpath("//input[@value='Other']")).click();
            driver.findElement(By.xpath("//input[@value='0 - 5']")).click();
            driver.findElement(By.xpath("//div[@class='w-8/12 smtablet:w-full left-input mr-20 pr-30 border-r-4 border-black smtablet:border-r-0 smtablet:mr-0 smtablet:pr-0']//button")).click();
            String text = driver.findElement(By.xpath("//span[@class='genderbutton']")).getText();
            String age = driver.findElement(By.xpath("//span[@class='groupradiobutton']")).getText();
            Assert.assertEquals("Other", text);
            Assert.assertEquals("0 - 5", age);

        }


    }


