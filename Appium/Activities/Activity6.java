package Example;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 {
	
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
 
		driver.get("https://training-support.net/webelements/sliders");
	}
	
    @Test
	
	public void test25(){
    	//wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));
    	//Get the screen size...
		Dimension dims = driver.manage().window().getSize();
		System.out.println(dims.getWidth()+ "," +dims.getHeight());
		
		// calculating the start and end point..
		int startx= (int) (0.50*dims.getWidth());
		int starty= (int) (0.77*dims.getHeight());
		
		Point start = new Point(startx,starty);
		
		int endx=(int) (0.33*dims.getWidth());
		int endy=(int) (0.77*dims.getHeight());
		
		Point end = new Point(endx,endy);
		
		//perform swipe......,,
		
		ActionsBase.doSwipe(driver,start,end,2000);
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		String text = driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text, '%')]")).getText();
		Assert.assertEquals(text, "25%");
				
	}
    
    @Test
	
   	public void test75() {
    	//wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));
    	//Get the screen size...
    			Dimension dims = driver.manage().window().getSize();
    		//	System.out.println(dims.getWidth()+ "," +dims.getHeight());
    			
    			// calculating the start and end point..
    			int startx= (int) (0.50*dims.getWidth());
    			int starty= (int) (0.77*dims.getHeight());
    			
    			Point start = new Point(startx,starty);
    			
    			int endx=(int) (0.67*dims.getWidth());
    			int endy=(int) (0.77*dims.getHeight());
    			
    			Point end = new Point(endx,endy);
    			
    			//perform swipe......,,
    			
    			ActionsBase.doSwipe(driver,start,end,1500);
    			
    			String text = driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text, '%')]")).getText();
    			Assert.assertEquals(text, "75%");
   	}
	
	
	@AfterClass
	
	public void tearDown() {
		driver.quit();
	}

}



