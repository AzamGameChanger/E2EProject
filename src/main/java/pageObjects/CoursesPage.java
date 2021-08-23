package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursesPage {

    public WebDriver driver;

    private By logInToCourses = By.cssSelector(".theme-btn.register-btn");
    private By emailId = By.cssSelector("[id='user_email']");
    private By passId= By.id("user_password");
    private By signInCourses = By.name("commit");

    public CoursesPage(WebDriver driver) {
        this.driver=driver;
    }


    public WebElement loginCourses(){
        return driver.findElement(logInToCourses);
    }

    public WebElement enterID(){
        return driver.findElement(emailId);
    }
    public WebElement enterPass(){
        return driver.findElement(passId);
    }
    public WebElement clickLogin(){
        return driver.findElement(signInCourses);
    }

}
