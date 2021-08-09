package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    By username = By.cssSelector("[id='user_email']");
    By password = By.xpath("//input[@id='user_password']");
    By logIn = By.cssSelector("[name='commit']");
    By forgotPass = By.cssSelector(".link-below-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public ForgotPassword forgotPassword(){
        driver.findElement(forgotPass).click();
       return new ForgotPassword(driver);

    }
    public WebElement getUser(){
        return driver.findElement(username);
    }
    public WebElement getPass(){
        return driver.findElement(password);
    }
    public WebElement logIn(){
        return driver.findElement(logIn);
    }
}
