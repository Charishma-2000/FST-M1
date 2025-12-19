package CRM_Project;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test3 {
	
WebDriver driver = new FirefoxDriver();
	
	@BeforeClass
	
	public void open() {
		
	 driver.get("https://alchemy.hguy.co/crm/");
	    
	}

	
	@Test
	
	public void footer_text() {
		
		WebElement text = driver.findElement(By.id("admin_options"));
		
		System.out.println(" The first copyright text in the footer: " +text.getText());
		
	}
	
	
    @AfterClass
	
	public void close() {
		
		driver.quit();
	}

}
