package Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class Activity13 {
	
	public static void main(String[] args) {
		  
		   WebDriver driver = new FirefoxDriver();
				    
		   driver.get("https://training-support.net/webelements/tables");
				   
		   System.out.println("Title is: "+driver.getTitle());
		   
		   List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		   System.out.println("Number of rows: " +rows.size());
		   
		   List<WebElement> cols = driver.findElements(By.xpath("//table/thead/tr/th"));
		   System.out.println("Number of columns: " +cols.size());
		   
		   List<WebElement> rows3 = driver.findElements(By.xpath("//table/tbody/tr[3]"));
		   
		   for (WebElement row3:rows3) {
			   
		   System.out.println("3rd row of the table : " +row3.getText());
		   
		   }
		   
		   WebElement cellValue = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
	       System.out.println("Second row, second column value: " + cellValue.getText());
		   
		   
	driver.quit();
	}

}
