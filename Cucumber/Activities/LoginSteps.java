package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.jupiter.api.Assertions;

import io.cucumber.java.en.*;

public class LoginSteps extends Base {

	WebDriver driver = new FirefoxDriver();
	
	@Given("the user is on the login page")
	public void openHomepage() {
		
		driver.get("https://training-support.net/webelements/login-form");
	}
	
	@When("the user enters username and password")
	public void enterCredentials() {
		
		WebElement element1 = driver.findElement(By.id("username"));
		   
		   element1.sendKeys("admin");
		   
		   WebElement element2 = driver.findElement(By.id("password"));
		   
		   element2.sendKeys("password");
	}
	
	@And("clicks the submit button")
	public void clickButton() {
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
	
	@Then("get the confirmation message and verify it")
	public void confirmationMsg() {
		String message = driver.findElement(By.xpath("//h1[contains(text(), 'Success')]")).getText();
		   System.out.println(message);
		   
		   Assertions.assertEquals(message, "Login Success!");
		driver.quit();
		
	}
}
