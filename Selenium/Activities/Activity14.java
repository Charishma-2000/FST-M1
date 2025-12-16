package Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import java.util.List;

public class Activity14 {
	
	public static void main(String[] args) {
		  
		   WebDriver driver = new FirefoxDriver();
				    
		   driver.get("https://training-support.net/webelements/tables");
				   
		   System.out.println("Title is: "+driver.getTitle());
		
		   List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		   System.out.println("Number of rows: " +rows.size());
		   
		   List<WebElement> cols = driver.findElements(By.xpath("//table/thead/tr/th"));
		   System.out.println("Number of columns: " +cols.size());
		   
		   WebElement row5 = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
	       System.out.println("Book Name in the 5th row is: " + row5.getText());
	       
	       driver.findElement(By.xpath("//th[text()='Price']")).click();
	       
	       System.out.println("Clicked on header of the Price column");
	       
	       row5 = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
	       System.out.println("Book Name in the 5th row is: " + row5.getText());
	       
	       driver.quit();
	}
}

