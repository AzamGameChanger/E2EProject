package Resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {

        prop = new Properties();

        FileInputStream file = new FileInputStream
                (System.getProperty("user.dir") + "/src/main/java/Resources/data.properties");
        prop.load(file);

        //mvn test -Dbrowser=chrome
        //String browserName = System.getProperty("browser");
        String browserName = prop.getProperty("browser");

        System.out.println(browserName);
        if (browserName.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/Resources/chromedriver");
            ChromeOptions options = new ChromeOptions();
            if  (browserName.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            //webdriver.gecko.driver
        } else if (browserName.equalsIgnoreCase("IE")) {
            driver = new InternetExplorerDriver();
            //webdriver.ie.driver
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }
}
