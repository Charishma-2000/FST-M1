package Example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Activity2{

 public static void main(String[] args) {
		  
   WebDriver driver = new FirefoxDriver();
		    
   driver.get("https://training-support.net/webelements/login-form/");
		   
   System.out.println("Title is: "+driver.getTitle());
		    
   WebElement element1 = driver.findElement(By.id("username"));
   
   element1.sendKeys("admin");
   
   WebElement element2 = driver.findElement(By.id("password"));
   
   element2.sendKeys("password");
   
   WebElement element3 = driver.findElement(By.xpath("//button[text()='Submit']"));
   
   element3.click();
   
   System.out.println("Closing the browser");
   
   driver.quit();
}
}
