package CRM_Project;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class Test8 {

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
	public void Accounts() {
		
		WebElement sale = driver.findElement(By.xpath("//a[text()='Sales']"));
		
		builder.moveToElement(sale)
                .build()
	        	.perform();
		
		WebElement acc = driver.findElement(By.id("moduleTab_9_Accounts"));
		acc.click();
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[contains(@class,'list view table-responsive')]")));
 
		List<WebElement> rows = driver
				.findElements(By.xpath("//table[contains(@class,'list view table-responsive')]/tbody/tr"));
 
		System.out.println("First 5 odd-numbered rows:");
		int count = 0;
		for (int i = 0; i < rows.size(); i++) {
			if ((i + 1) % 2 != 0) {
				WebElement nameCell = rows.get(i).findElement(By.xpath("./td[3]"));
				System.out.println("Row " + (i + 1) + ": " + nameCell.getText());
				count++;
				if (count == 5)
					break;
			}
 
		}
 
	}
        
	
    @AfterClass
    
	public void close() {
		
		driver.quit();
	}
}
