package Example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Activity3{

 public static void main(String[] args) {
		  
   WebDriver driver = new FirefoxDriver();
		    
   driver.get("https://training-support.net/webelements/login-form/");
		   
   System.out.println("Title is: "+driver.getTitle());
		    
   driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
   
 //  element1.sendKeys("admin");
   
   driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
   
   //element2.sendKeys("password");
   
   driver.findElement(By.xpath("//button[text()='Submit']")).click();
   
   //element3.click();
   
   String message = driver.findElement(By.xpath("//h1[contains(text(), 'Success')]")).getText();
   System.out.println(message);
   
   System.out.println("Closing the browser");
   
   driver.quit();
}
}
