package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.en.*;

public class TSHomepageSteps extends Base{
	
	WebDriver driver = new FirefoxDriver();
	WebElement element;
	
	@Given("user is on the TS homepage")
	public void openHomepage() {
		
		driver.get("https://training-support.net");
	}

	@When("the user clicks on the About Us link")
	public void click() {
		
		element = driver.findElement(By.linkText("About Us"));
	    element.click();
	}

	@Then("they are redirected to another page")
	public void newPage() {
		String title = driver.getTitle();
		System.out.println("Title of new page: " +title);
		//Assert.asserEquals("About Training Support",title);
		driver.quit();
		
	}

}
