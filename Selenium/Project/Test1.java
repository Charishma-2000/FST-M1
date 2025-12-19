package CRM_Project;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test1 {
	
WebDriver driver = new FirefoxDriver();
	
	@BeforeClass
	
	public void open() {
		
	 driver.get("https://alchemy.hguy.co/crm/");
	    
	}

	
	@Test
	
	public void title() {
		
		String title = driver.getTitle();
		System.out.println("Title of the website is: "+title);
		
		Assert.assertEquals(title, "SuiteCRM");
	}
	
	
    @AfterClass
	
	public void close() {
		
		driver.quit();
	}
}
