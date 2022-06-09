package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.DropDown;
import wrappers.Input;

public class NewAccountModal {
    WebDriver driver;

    public NewAccountModal(WebDriver driver){
        this.driver = driver;
    }

    public void create(String accountName, String website, String type, String parentAccount){
        new Input(driver,"Account Name").write(accountName);
        new Input(driver,"Website").write(website);
        new DropDown(driver, "Type").select(type);

    }

    public void save(){
        driver.findElement(By.cssSelector("[title='Save']")).click();

    }
}
