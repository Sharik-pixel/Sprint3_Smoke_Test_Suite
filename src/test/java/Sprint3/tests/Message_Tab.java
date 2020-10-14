package Sprint3.tests;

import Sprint3.util.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Message_Tab {

    WebDriver driver;
    String browserType = "chrome";
    //Truck driver Credentials
    String URL = "https://login2.nextbasecrm.com/";
    String userName = "helpdesk28@cybertekschool.com";
    String password = "UserUser";

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Test
    public void verify_topic_icon(){
        driver.findElement(By.xpath("//span[.='Message']")).click();
        driver.findElement(By.xpath("//span[@title='Topic']")).click();
        boolean topic_displayed = driver.findElement(By.xpath("//input[@id='POST_TITLE']")).isDisplayed();

        Assert.assertTrue(topic_displayed,"topic box is not displayed");
    }
    @Test
    public void verify_record_video()throws InterruptedException{


            //finding message tab

            driver.findElement(By.xpath("(//span[.='Message'])[2]")).click();

            Thread.sleep(2000);
            driver.findElement(By.xpath("(//span[@class='feed-add-post-form-but-cnt feed-add-videomessage'])[1]")).click();

        }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
