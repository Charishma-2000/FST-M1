package CRM_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test6 {

WebDriver driver = new FirefoxDriver();
	
	@BeforeClass
	
	public void open() {
		
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
	public void Activities() {
		
		driver.findElement(By.xpath("//a[text()='Activities']")).click();
	}
	
    @AfterClass
	
	public void close() {
		
		driver.quit();
	}
}
