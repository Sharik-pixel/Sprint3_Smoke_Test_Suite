package Sprint3.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AC_9 {

    public static void main(String[] args) throws InterruptedException {

        //Here i have stored credentials & URL
        String URL = "http://login2.nextbasecrm.com";
        String userName = "helpdesk28@cybertekschool.com";
        String password = "UserUser";


        /*
        Here i wanted to disable all notifications for Google CHROME driver
        Don't pay attention to this. I was just trying

        chrome_options = Options()
        chrome_options.add_argument("--disable-notifications")
        browser = webdriver.Chrome(chrome_options=chrome_options)

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
         */

        WebDriverManager.chromedriver().setup();

        // This object is to block all pop up notifications on Chrome  Browser
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get(URL);

        driver.findElement(By.name("USER_LOGIN")).sendKeys(userName);
        Thread.sleep(1000);
        driver.findElement(By.name("USER_PASSWORD")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //finding message tab

        driver.findElement(By.xpath("(//span[.='Message'])[2]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='feed-add-post-form-but-cnt feed-add-videomessage'])[1]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='popup-window-button popup-window-button-blue']")).click();

        /*
        In this case I wanted to handle this pop up Notification Tab, with
        Alert class from java -> where it have methods such Accept(); and Dismiss();
        Unfortunately, it did not work. If you guys have any solution,
        PLEASE let me know!!!
         */
        Alert alert = driver.switchTo().alert();
        alert.accept();

        Thread.sleep(4000);

    }
}
