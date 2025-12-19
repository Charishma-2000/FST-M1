package CRM_Project;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test4 {
	
WebDriver driver = new FirefoxDriver();
	
	@BeforeClass
	
	public void open() {
		
	 driver.get("https://alchemy.hguy.co/crm/");
	 String title = driver.getTitle();
	 Assert.assertEquals(title, "SuiteCRM");
	 
	}

	
	@Test
	public void login_page() {
		
		WebElement username=driver.findElement(By.id("user_name"));
		WebElement password=driver.findElement(By.id("username_password"));
		WebElement login=driver.findElement(By.id("bigbutton"));
		
		username.sendKeys("admin");
		password.sendKeys("pa$$w0rd");
		login.click();
		
		String pageTitle = driver.getTitle();
        System.out.println("Page Title After Login: " + pageTitle);
		
	}
	
    @AfterClass
	
	public void close() {
		
		driver.quit();
	}


}
