import Resources.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.io.IOException;


public class HomePage extends base {
    public WebDriver driver;
    public static Logger log = LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();

    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String Username, String Password, String text) {
        driver.get(prop.getProperty("url"));

        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = landingPage.getLogin();
        loginPage.getUser().sendKeys(Username);
        loginPage.getPass().sendKeys(Password);

        log.info(text);

        loginPage.logIn().click();

        ForgotPassword fp= loginPage.forgotPassword();
        fp.getEmail().sendKeys(prop.getProperty("email"));
        fp.clickSendMe().click();
    }
    @AfterTest
    public void tearDown() {
        driver.close();
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[2][3];
        //0th Row
        data[0][0] = "nonrestricteduser@qw.com";
        data[0][1] = "12345";
        data[0][2] = "Restricted User";

        //1st Row
        data[1][0] = "restricteduser@qw.com";
        data[1][1] = "54321";
        data[1][2] = "Non-restricted user";

        return data;
    }
}

