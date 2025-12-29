package Example;

import org.testng.Assert;
import org.testng.annotations.*;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class Activity5 {

	WebDriverWait wait;
	AndroidDriver driver;
	
	@BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.contacts");
        options.setAppActivity("com.android.contacts.activities.PeopleActivity");
        options.noReset();
 
        // Server Address
        URL serverURL = new URI("http://localhost:4723").toURL();
 
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	
	@Test
	
	public void SMS() {
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Messages"))).click();
		WebElement search = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Search messages\"]"));
		search.click();
		Actions action = new Actions(driver);
	    action.sendKeys("Aaditya Varma").perform();
	  
	      wait.until(ExpectedConditions.elementToBeClickable(
	             AppiumBy.xpath("//android.widget.TextView[@content-desc=\"+ One Nine Nine Nine One Four Eight Two Nine Two \"]"))).click();
	      wait.until(ExpectedConditions.elementToBeClickable(
		             AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.apps.messaging:id/conversation_snippet\"]"))).click();
	      WebElement click = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id(
	    		"com.google.android.apps.messaging:id/compose_message_text"
	        )));
	    		 click.click();
	    		 click.clear();
	    		 action.sendKeys("Hello from Appium").perform();
	        driver.findElement(AppiumBy.xpath(
	                "//android.view.View[@content-desc=\"Send SMS\"]"
	        )).click();
	    
	    WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Hello from Appium')]")));
	    String actualtext=text.getText();
	
	        Assert.assertEquals(actualtext, "Hello from Appium");
	    }
	
	
@AfterClass
	
	public void tearDown() {
		driver.quit();
	}

}
