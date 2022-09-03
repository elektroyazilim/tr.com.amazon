package amazon.stepdefinitions.ui;

import amazon.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshots");
            Driver.closeDriver();
        }
        Driver.closeDriver();
    }
}
