package CRM_Project;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test5 {
	
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
	public void colors() {
		
		WebElement toolbar =driver.findElement(By.id("toolbar"));
		String colorrgb = toolbar.getCssValue("background-color");
		String hexcolor = Color.fromString(colorrgb).asHex();
		System.out.println("RGB color is: " +colorrgb);
		System.out.println("Hex color is: " +hexcolor);
		
	}
	
    @AfterClass
	
	public void close() {
		
		driver.quit();
	}

}
