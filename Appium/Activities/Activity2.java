package Example;

import org.testng.Assert;
import org.testng.annotations.*;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;


public class Activity2 {
	
	WebDriverWait wait;
	AndroidDriver driver;
	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
	
		URL serverURL = new URI("http://localhost:4723").toURL();
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 
		driver.get("https://training-support.net");
	}
	
	@Test
	
	public void testMethod() {
		
		String pageTitle = driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text=\"Training Support\"])[1]")).getText();
		System.out.println("Heading: " + pageTitle);
		driver.findElement(AppiumBy.className("android.view.View")).click();
		WebElement pageTitle2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"About Us\"]"));
		System.out.println("New page heading: " +pageTitle2.getText());
	}
	
	
	@AfterClass
	
	public void tearDown() {
		driver.quit();
	}

}
