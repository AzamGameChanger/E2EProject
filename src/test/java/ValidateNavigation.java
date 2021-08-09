import Resources.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import java.io.IOException;

public class ValidateNavigation extends base {

    public WebDriver driver;
    public static Logger log = LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized.");
        driver.get(prop.getProperty("url"));
        log.info("Navigated to Home Page.");
    }

    @Test
    public void basePageNavigation() throws IOException {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.validateContactText().isDisplayed());
        log.info("Successfully validated Navigation Bar.");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

}

