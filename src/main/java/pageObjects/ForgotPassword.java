package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
    public WebDriver driver;

    By email = By.cssSelector("#user_email");
    By sendMeInstructions = By.xpath("//input[@type='submit']");

    public ForgotPassword(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmail(){
        return driver.findElement(email);
    }
    public WebElement clickSendMe(){
        return driver.findElement(sendMeInstructions);
    }
}
