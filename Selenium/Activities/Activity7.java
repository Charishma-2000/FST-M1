package Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {
	
	public static void main(String[] args) {
		  
		   WebDriver driver = new FirefoxDriver();
				    
		   driver.get("https://training-support.net/webelements/dynamic-controls");
				   
		   System.out.println("Title is: "+driver.getTitle());
		   
		   WebElement ip = driver.findElement(By.id("textInput"));
		   
		   System.out.println("Is text field enabled : "+ip.isEnabled());
		   
		   driver.findElement(By.xpath("//button[text()='Enable Input']")).click();
		   
		   System.out.println("Is text field enabled : "+ip.isEnabled());
		   
		   driver.quit();
}
}
