package Example;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {
	
	public static void main(String[] args) {
		  
		   WebDriver driver = new FirefoxDriver();
				    
		   driver.get("https://training-support.net/webelements/selects");
				   
		   System.out.println("Title is: "+driver.getTitle());
		   
		   WebElement dropdown = driver.findElement(By.tagName("select"));
		   Select select = new Select(dropdown);
		   
		   List<WebElement> options = select.getOptions();
		   
		   select.selectByVisibleText("Two");
		   
		  WebElement Sec_option = driver.findElement(By.xpath("//p[text()='You have selected: Two']"));
		  System.out.println("Second option: " +Sec_option.getText());
		  
		  select.selectByIndex(3);
		  WebElement third_option = driver.findElement(By.xpath("//p[text()='You have selected: Three']"));
		  System.out.println("Third option: " +third_option.getText());
		  
		  select.selectByValue("four");
		  WebElement Fourth_option = driver.findElement(By.xpath("//p[text()='You have selected: Four']"));
		  System.out.println("Fourth option: " +Fourth_option.getText());
		  
		  List<WebElement> allSelected = select.getOptions();
		  System.out.println("All option:");
		  for(WebElement option : allSelected) {
	            System.out.println(option.getText());
	        }
		  
		driver.quit();   
	}

}
