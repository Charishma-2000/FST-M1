package Example;

//import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {
	
	public static void main(String[] args) {
		  
	    WebDriver driver = new FirefoxDriver();
	  //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    driver.get("https://training-support.net/webelements/dynamic-attributes");
	   
	    System.out.println("Title is: "+driver.getTitle());
	    
	    driver.findElement(By.xpath("//input[starts-with(@id, 'full-name')]")).sendKeys("Charishma");
	    
	    driver.findElement(By.xpath("//input[contains(@id, 'email')]")).sendKeys("abc@gmail.com");
	    
	    driver.findElement(By.xpath("//input[contains(@name, 'event-date')]")).sendKeys("2025-12-18");
	    
	    driver.findElement(By.xpath("//textarea[contains(@id, 'additional-details')]")).sendKeys("Entered details");
	    
	    driver.findElement(By.xpath("//button[text()='Submit']")).click();
	    
	    //String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")))
         //       .getText();
	    
	    WebElement message = driver.findElement(By.id("action-confirmation"));
	    
	    System.out.println("Success msg:" +message.getText());
	    
	    driver.quit();
	}

}
