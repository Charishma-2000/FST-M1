package Example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Activity10 {
  public static void main(String[] args) {
	  
    WebDriver driver = new FirefoxDriver();
    Actions builder = new Actions(driver);
    
    driver.get("https://training-support.net/webelements/drag-drop");
   
    System.out.println("Title is: "+driver.getTitle());
    
    WebElement ball = driver.findElement(By.id("ball"));
    System.out.println("found the ball");
    WebElement dz1 = driver.findElement(By.id("dropzone1"));
    builder.clickAndHold(ball).dragAndDrop(dz1,ball).build().perform();
    String message = driver.findElement(By.cssSelector("span.dropzone-text")).getText();
	System.out.println(message);
	
	WebElement dz2 = driver.findElement(By.id("dropzone2"));
	builder.clickAndHold(ball).dragAndDrop(dz2,dz1).build().perform();
	message = driver.findElement(By.cssSelector("span.dropzone-text")).getText();
	System.out.println("Verifying that the ball has entered Dropzone 2: ");
	System.out.println(message);
    
    driver.quit();
  }
}