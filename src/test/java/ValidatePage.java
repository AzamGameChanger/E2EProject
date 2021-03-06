import Resources.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.io.IOException;

public class ValidatePage extends base {
    public WebDriver driver;
    LandingPage landingPage;
    public static Logger log = LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void basePageNavigation() {

        landingPage = new LandingPage(driver);
        Assert.assertEquals(landingPage.getTitle().getText(), "FEATURED COURSES");
        log.info("Successfully validated Text message.");

    }
    @Test
    public void validateHeader() {

        Assert.assertEquals(landingPage.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
        log.info("Successfully validated Text message.");

    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

}

