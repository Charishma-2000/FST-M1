package stepDefinition;

import java.time.Duration;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.*;


public class Fixtures extends Base {
    @BeforeAll
    public static void setUp() {
        // Initialize Firefox Driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    @AfterAll
    public static void tearDown() {
        // Close the browser
        driver.quit();
    }
}