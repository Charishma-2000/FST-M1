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

public class Activity4 {

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
        options.setCapability("unicodeKeyboard", true);
        options.setCapability("resetKeyboard", true);
        options.noReset();
 
        // Server Address
        URL serverURL = new URI("http://localhost:4723").toURL();
 
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	
	@Test
	
	public void contact() {
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Contacts"))).click();
	      wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Create contact"))).click();
	  
	      wait.until(ExpectedConditions.elementToBeClickable(
	             AppiumBy.xpath("//android.widget.EditText[@text='First name']")));

	        driver.findElement(AppiumBy.xpath(
	                "//android.widget.EditText[@text='First name']"
	        )).sendKeys("Aaditya");
	        driver.findElement(AppiumBy.xpath(
	                "//android.widget.EditText[@text='Last name']"
	        )).sendKeys("Varma");
	    WebElement phone= wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text=\"+1\"]/android.view.View[3]")));
	    phone.click();
	    phone.clear();
	    
	    Actions action = new Actions(driver);
	    action.sendKeys("999148292").perform();
	    
	    driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.Button")).click();
	 
	    wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.contacts:id/large_titleM2")));
	 
	      
	        String contactName = driver.findElement(AppiumBy.id("com.google.android.contacts:id/large_titleM2")).getText();
	        Assert.assertEquals(contactName, "Aaditya Varma");
	    }
	
	
@AfterClass
	
	public void tearDown() {
		driver.quit();
	}

}
