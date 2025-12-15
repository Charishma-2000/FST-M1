package Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
//import org.openqa.selenium.WebElement;

public class Activity4{

 public static void main(String[] args) {
		  
   WebDriver driver = new FirefoxDriver();
		    
   driver.get("https://training-support.net/webelements/target-practice");
		   
   System.out.println("Title is: "+driver.getTitle());
   
   //using Xpath
   
   String message = driver.findElement(By.xpath("//h3[contains(text(), 'Heading')]")).getText();
   System.out.println(message);
   
   String textcolor = driver.findElement(By.xpath("//h5[contains(text(), '#5')]")).getCssValue("color");
   System.out.println("Color as RGB: " + textcolor);
   String fifthcolor = Color.fromString(textcolor).asHex();
   System.out.println("Color as Hex: " + fifthcolor);
   
   // Using any locators
   String element = driver.findElement(By.xpath("//button[text()='Purple']")).getDomAttribute("class");
   System.out.println("Purple button class:" +element);
   
   String slateButtonText = driver.findElement(By.xpath("//button[contains(@class, 'slate')]")).getText();
   System.out.println(slateButtonText);
   
   driver.quit();
   
   
   
 }
}