package Example;

import org.testng.Assert;
import org.testng.annotations.*;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class Activity1 {
	
	WebDriverWait wait;
	AndroidDriver driver;
	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options caps=new UiAutomator2Options();
		File appFile=new File("src/test/resources/Calculator.apk");
		caps.setPlatformName("android");
		caps.setAutomationName("UiAutomator2");
		caps.setApp(appFile.getAbsolutePath());
		caps.noReset();
		URL serverurl=new URI("http://localhost:4723").toURL();
		driver = new AndroidDriver(serverurl,caps);		
	}
	
	@Test
	
	public void testMethod() {
		
		driver.findElement(AppiumBy.id("digit_4")).click();
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();
		driver.findElement(AppiumBy.id("digit_1")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String result = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
		System.out.println("result: " +result);
		Assert.assertEquals(result, "40");
	}
	
	
	@AfterClass
	
	public void tearDown() {
		driver.quit();
	}

}
