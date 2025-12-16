package Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;

public class Activity9 {
	
	public static void main(String[] args) {
		  
		   WebDriver driver = new FirefoxDriver();
		   Actions builder = new Actions(driver);
				    
		   driver.get("https://training-support.net/webelements/keyboard-events");
				   
		   System.out.println("Title is: "+driver.getTitle());
		   
		   builder.sendKeys("Charishma").sendKeys(Keys.RETURN).build().perform();
	        
	        String pageText = driver.findElement(By.cssSelector("h1.mt-3")).getText();
	        System.out.println(pageText);
		  
	     
		   driver.quit();
	}
}
