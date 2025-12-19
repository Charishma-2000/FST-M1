package CRM_Project;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Test2 {
	
WebDriver driver = new FirefoxDriver();
	
	@BeforeClass
	
	public void open() {
		
	 driver.get("https://alchemy.hguy.co/crm/");
	    
	}

	
	@Test
	
	public void url() {
		
		WebElement url = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
		String imgurl = url.getAttribute("src");
		
		System.out.println(" url of the header image is: " +imgurl);
		
	}
	
	
    @AfterClass
	
	public void close() {
		
		driver.quit();
	}

}
