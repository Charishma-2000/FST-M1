package Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity18 {

	public static void main(String[] args) {
		  
		   WebDriver driver = new FirefoxDriver();
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				    
		   driver.get("https://training-support.net/webelements/alerts");
				   
		   System.out.println("Title is: "+driver.getTitle());
		   
		   driver.findElement(By.id("simple")).click();
		   
		   wait.until(ExpectedConditions.alertIsPresent());
		   
		   Alert alert = driver.switchTo().alert();
		   
		   System.out.println(alert.getText());
		   
		   alert.accept();
		   
		   System.out.println(driver.findElement(By.id("result")).getText());
		   
		   driver.quit();
		   
	}
}
