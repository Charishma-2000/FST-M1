package Example;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {
	
	public static void main(String[] args) {
		  
		   WebDriver driver = new FirefoxDriver();
				    
		   driver.get("https://training-support.net/webelements/selects");
				   
		   System.out.println("Title is: "+driver.getTitle());
		   
		   WebElement selectElement = driver.findElement(By.cssSelector("select.h-80"));
		    Select select = new Select(selectElement);
		   
		   List<WebElement> options = select.getOptions();
		   
		   select.selectByVisibleText("HTML");
		   
		  WebElement Text1 = driver.findElement(By.xpath("//Option[text()='HTML']"));
		  System.out.println("Text 1: " +Text1.getText());
		  
		  select.selectByIndex(4);
		  select.selectByIndex(5);
		  select.selectByIndex(6);
		  
		  select.selectByValue("nodejs");
		  WebElement Text2 = driver.findElement(By.xpath("//Option[text()='Node']"));
		  System.out.println("Text 2: " +Text2.getText());
		  
			
		  select.deselectByIndex(5);
		  
		driver.quit();   
	}

}
