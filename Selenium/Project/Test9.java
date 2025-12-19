package CRM_Project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Test9 {

WebDriver driver = new FirefoxDriver();
Actions builder = new Actions(driver);
WebDriverWait wait;
	
	@BeforeClass
	
	public void open() {
		
	 wait = new WebDriverWait(driver, Duration.ofSeconds(5));	
	 driver.get("https://alchemy.hguy.co/crm/");
	 String title = driver.getTitle();
	 Assert.assertEquals(title, "SuiteCRM");
	 
	 WebElement username=driver.findElement(By.id("user_name"));
	 WebElement password=driver.findElement(By.id("username_password"));
	 WebElement login=driver.findElement(By.id("bigbutton"));
		
		username.sendKeys("admin");
		password.sendKeys("pa$$w0rd");
		login.click();
	 
	}

	
	@Test
	public void Sales() {
		
		WebElement sale = driver.findElement(By.xpath("//a[text()='Sales']"));
		
		builder.moveToElement(sale)
                .build()
	        	.perform();
		
		WebElement leads = driver.findElement(By.id("moduleTab_9_Leads"));
		leads.click();
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@class,'table-responsive')]")));
		
		List<WebElement> names = driver.findElements(By.xpath("//table[contains(@class,'table-responsive')]/tbody/tr/td[3]"));
		List<WebElement> users = driver.findElements(By.xpath("//table[contains(@class,'table-responsive')]/tbody/tr/td[8]"));
		
		System.out.println("First 10 names and user:");
		
		for (int i = 0; i <10; i++) {
		    String nameText = names.get(i).getText();
		    String userText = users.get(i).getText();
		    System.out.println("Name: " + nameText + ", User: " + userText);
		
		}
	}
	
    @AfterClass
    
	public void close() {
		
		driver.quit();
	}
}
