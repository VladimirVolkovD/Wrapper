package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.NewAccountModal;

import java.time.Duration;


@Test
public class LoginTest {

    public void test(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver  driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://tms-a.my.salesforce.com");
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("Login")).click();

        driver.get("https://tms-a.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        driver.findElement(By.cssSelector("a[title=New]")).click();

        NewAccountModal newAccountModal = new NewAccountModal(driver);

        newAccountModal.create("Volodya_new","teachmeskills.by", "Press", "Volodya_new");
        newAccountModal.save();

        driver.quit();

    }
}
