package AppiumProject;

import org.testng.Assert;
import org.testng.annotations.*;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class NativeApp {
	
	WebDriverWait wait;
	AndroidDriver driver;
	
	@BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
		UiAutomator2Options caps=new UiAutomator2Options();
		File appFile=new File("src/test/resources/ts-todo-list-v1.apk");
		caps.setPlatformName("android");
		caps.setAutomationName("UiAutomator2");
		caps.setApp(appFile.getAbsolutePath());
		caps.noReset();
 
        // Server Address
        URL serverURL = new URI("http://localhost:4723").toURL();
 
        // Driver Initialization
        driver = new AndroidDriver(serverURL, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	
	@Test (priority = 1)
	
	public void todoList_Create() {
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("To-Do List"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/fab_new_task"))).click();
		WebElement name = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.app.todolist:id/et_new_task_name\"]"));
		name.click();
		name.sendKeys("Complete Activity 1");
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/tv_new_task_priority"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"High\"]"))).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.app.todolist:id/bt_new_task_ok\"]")).click();
		WebElement text1 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Complete Activity 1')]")));
	    String actualtext1=text1.getText();
	
	        Assert.assertEquals(actualtext1, "Complete Activity 1");
	    
	    wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/fab_new_task"))).click();
	    WebElement name2 = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.app.todolist:id/et_new_task_name\"]"));
		name2.click();
		name2.sendKeys("Complete Activity 2");
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/tv_new_task_priority"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Medium\"]"))).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.app.todolist:id/bt_new_task_ok\"]")).click();
		WebElement text2 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Complete Activity 2')]")));
		String actualtext2=text2.getText();
		
		     Assert.assertEquals(actualtext2, "Complete Activity 2"); 
		     
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/fab_new_task"))).click();
		WebElement name3 = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.app.todolist:id/et_new_task_name\"]"));
		name3.click();
		name3.sendKeys("Complete Activity 3");
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/tv_new_task_priority"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Low\"]"))).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.app.todolist:id/bt_new_task_ok\"]")).click();
		WebElement text3 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Complete Activity 3')]")));
		String actualtext3=text3.getText();
				
			Assert.assertEquals(actualtext3, "Complete Activity 3"); 
				     
	    }

@Test (priority = 2)
   public void todoList_Edit() {
	//wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Predicted app: To-Do List"))).click();
	WebElement firsttask = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("text(\"Complete Activity 1\")")));
	((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) firsttask).getId(), "duration", 2000));
	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit To-Do Task\"]"))).click();
	WebElement dedline = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_todo_list_deadline\"]"));
	dedline.click();
	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Next month\"]"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@content-desc=\"03 January 2026\"]"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.app.todolist:id/bt_deadline_ok\"]"))).click();
	driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.app.todolist:id/bt_new_task_ok\"]")).click();
	WebElement desc_check = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_deadline\" and @text=\"Deadline: 03.01.2026\"]")));
	String actual_desc_text=desc_check.getText();
			
		Assert.assertEquals(actual_desc_text, "Deadline: 03.01.2026"); 
}

@Test (priority = 3)
    public void todoList_comp() {
	//wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Predicted app: To-Do List"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id=\"com.app.todolist:id/cb_task_done\"])[1]"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id=\"com.app.todolist:id/cb_task_done\"])[2]"))).click();
	driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"More options\"]")).click();
	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/title\" and @text=\"Completed tasks\"]"))).click();
	
	WebElement text1= wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Complete Activity 1\"]")));
	String actual_text1=text1.getText();
	
	Assert.assertEquals(actual_text1, "Complete Activity 1"); 
	
	WebElement text2= wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Complete Activity 2\"]")));
	String actual_text2=text2.getText();
	
	Assert.assertEquals(actual_text2, "Complete Activity 2"); 
	
	driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"More options\"]")).click();
	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/title\" and @text=\"All tasks\"]"))).click();
	WebElement firsttask = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("text(\"Complete Activity 3\")")));
	((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) firsttask).getId(), "duration", 2000));
	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit To-Do Task\"]"))).click();
	
	WebElement progress = driver.findElement(AppiumBy.id("com.app.todolist:id/sb_new_task_progress"));
	int startX = progress.getLocation().getX();
	int startY= progress.getLocation().getY();
	int width = progress.getSize().getWidth();
	
	PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	Sequence dragToMiddle = new Sequence(finger,1);
	int center = startX + (width/2);
	dragToMiddle.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX,startY));
	dragToMiddle.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	dragToMiddle.addAction(finger.createPointerMove(Duration.ofMillis(1000),PointerInput.Origin.viewport(),center,startY));
	dragToMiddle.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	
	driver.perform(Collections.singletonList(dragToMiddle));
	driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.app.todolist:id/bt_new_task_ok\"]")).click();
	
}
	
@AfterClass
	
	public void tearDown() {
		driver.quit();
	}

}



