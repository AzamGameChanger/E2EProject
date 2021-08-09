package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;

   // By signIn = By.xpath("//span[contains(text(),'Login')]");

    By signIn = By.xpath("//span[contains(text(),'Login')]");
    By title = By.cssSelector(".text-center h2");
    By navigationContact = By.xpath("//a[contains(text(),'Contact')]");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLogin(){
         driver.findElement(signIn).click();
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;

    }
    public WebElement getTitle(){
        return driver.findElement(title);
    }
    public WebElement validateContactText(){
        return driver.findElement(navigationContact);
    }
}
