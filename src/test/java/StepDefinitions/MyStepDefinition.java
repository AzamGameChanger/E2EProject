package StepDefinitions;

import Resources.base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pageObjects.CoursesPage;
import pageObjects.LandingPage;
import pageObjects.PortalHomePage;

import java.io.IOException;

public class MyStepDefinition extends base {
    CoursesPage coursesPage;

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws IOException {
        driver = initializeDriver();

    }

    @Given("^Navigate to the \"([^\"]*)\" website$")
    public void navigate_to_the_website(String arg1) {
        driver.get(arg1);

    }

    @Given("^Click on Login link in home page to land on Secure sign in Page$")
    public void click_on_Login_link_in_home_page_to_land_on_Secure_sign_in_Page() {
        LandingPage landingPage = new LandingPage(driver);
        if  (landingPage.getPopUpSize()>0){
            landingPage.getPopUp().click();
        }
        coursesPage = landingPage.getCourses();
        coursesPage.loginCourses().click();

    }
    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) {
        coursesPage.enterID().sendKeys(username);
        coursesPage.enterPass().sendKeys(password);
        coursesPage.clickLogin().click();
    }

    @Then("^Verify that user is successfully logged in$")
    public void verify_that_user_is_successfully_logged_in() {
        PortalHomePage p = new PortalHomePage(driver);
        Assert.assertTrue(p.getSearchBox().isDisplayed());
    }
    @And("^Close browsers$")
    public void close_browsers(){
        driver.quit();
    }

}
