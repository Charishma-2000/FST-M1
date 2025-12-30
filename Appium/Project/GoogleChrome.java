package AppiumProject;

import org.testng.Assert;
import org.testng.annotations.*;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;


public class GoogleChrome {
	
	WebDriverWait wait;
	AndroidDriver driver;
	
	@BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
 
		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();
 
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
		// Open the page in Chrome
		driver.get("https://training-support.net/webelements");
    }
	
	@Test (priority = 1)
	
	public void test1() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.view.View")));
		String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
		List<WebElement> imageElements = driver.findElements(AppiumBy.className("android.view.View"));
		WebElement imageText = driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward(25)"));
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]"))).click();
		
		WebElement text1 = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]"));
		text1.click();
		text1.sendKeys("Add tasks to list");
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@resource-id=\"todo-add\"]"))).click();
		
		WebElement text2 = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]"));
		text2.click();
		text2.sendKeys("Get number of tasks");
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@resource-id=\"todo-add\"]"))).click();
		
		WebElement text3 = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]"));
		text3.click();
		text3.sendKeys("Clear the list");
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@resource-id=\"todo-add\"]"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.ListView/android.view.View[3]/android.view.View/android.widget.CheckBox"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.ListView/android.view.View[4]/android.view.View/android.widget.CheckBox"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.ListView/android.view.View[5]/android.view.View/android.widget.CheckBox"))).click();
		imageElements = driver.findElements(AppiumBy.className("android.widget.CheckBox"));
		Assert.assertEquals(imageElements.size(), 5);
	}
	
@Test (priority = 2)
	
	public void test2_login_sucess() {
	
	    driver.get("https://training-support.net/webelements");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.view.View")));
		String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
		List<WebElement> imageElements = driver.findElements(AppiumBy.className("android.view.View"));
		WebElement imageText = driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward(25)"));
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]"))).click();
		WebElement user1 = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]"));
		user1.click();
		user1.sendKeys("admin");
		WebElement pswd1 = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]"));
		pswd1.click();
		pswd1.sendKeys("password");
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]"))).click();
		WebElement page2 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Success!\"]")));
		String finalpage2 = page2.getText();
		Assert.assertEquals(finalpage2, "Login Success!");		
}

@Test (priority = 3)

public void test2_login_unsucess() {

    driver.get("https://training-support.net/webelements");
    wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.view.View")));
	String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
	List<WebElement> imageElements = driver.findElements(AppiumBy.className("android.view.View"));
	WebElement imageText = driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward(25)"));
	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]"))).click();
	WebElement user2 = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]"));
	user2.click();
	user2.sendKeys("admin");
	WebElement pswd2 = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]"));
	pswd2.click();
	pswd2.sendKeys("passwor");
	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]"))).click();
	WebElement page1 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Invalid credentials']")));
	String finalpage1 = page1.getText();
	Assert.assertEquals(finalpage1, "Invalid credentials");		
}

@Test (priority = 4)

public void test3() {
	driver.get("https://training-support.net/webelements");
	wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.view.View")));
	List<WebElement> textElements = driver.findElements(AppiumBy.className("android.view.View"));
	String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
	wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward(65)")));
	WebElement text = driver.findElement(AppiumBy
			.androidUIAutomator(UiScrollable + ".scrollForward(25)"));
	wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Popups\"]")));
  driver.findElement(AppiumBy.xpath(
		  "//android.widget.TextView[@text=\"Popups\"]")).click();	
  wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@resource-id=\"launcher\"]")));
  driver.findElement(AppiumBy.xpath(
		  "//android.widget.Button[@resource-id=\"launcher\"]")).click();	
 wait.until(ExpectedConditions.elementToBeClickable( AppiumBy.androidUIAutomator("new UiSelector().text(\"Popups\")")));
  WebElement allow = new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(
  AppiumBy.androidUIAutomator("new UiSelector().text(\"Popups\")")));
  allow.click();

  driver.findElement(AppiumBy.xpath( "//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");
  driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();
  wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Success!\"]")));
  String messageText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Success!\"]")).getText();		
  Assert.assertEquals(messageText,"Login Success!");
}

@AfterClass
	
	public void tearDown() {
		driver.quit();
	}

}



