package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;

    private By signIn = By.xpath("//span[contains(text(),'Login')]");
    private By title = By.cssSelector(".text-center h2");
    private By navigationContact = By.xpath("//a[contains(text(),'Contact')]");
    private By header = By.cssSelector("div[class*='video-banner'] h3");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLogin() {
        driver.findElement(signIn).click();
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;

    }

    public WebElement getTitle() {
        return driver.findElement(title);
    }
    public WebElement getHeader() {
        return driver.findElement(header);
    }

    public WebElement validateContactText() {
        return driver.findElement(navigationContact);
    }
}
