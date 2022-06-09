package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown {
    WebDriver driver;
    String label;

    public DropDown(WebDriver driver, String label){
        this.driver = driver;
        this.label = label;
    }

    public void select(String option){
        driver.findElement(By.xpath(
                        String.format("//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//a", label)
        )).click();

        driver.findElement(By.cssSelector(String.format("a[title='%s']", option))).click();
    }
}


