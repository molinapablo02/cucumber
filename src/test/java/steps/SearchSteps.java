package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {

	WebDriver driver;
		
	@Given("the user is in the index page")
	public void theUserIsInTheIndexPage() {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/index.php");
		
	}
	
	@When("^the user enters ([^\"]*) in the search bar$")
	public void theUserEntersDressesInTheSearchBar(String article) {
		driver.findElement(By.id("search_query_top")).sendKeys(article);
		
	}
	
	@When("the user clicks the search button")
	public void theUserClicksTheSearchButton() {
		driver.findElement(By.name("submit_search")).click();
	}
	
	@Then("^the ([^\"]*) page appears$")
	public void theDressesPageAppears(String article) {
		String title = driver.findElement(By.className("lighter")).getText();
		
		Assert.assertEquals("\""+article.toUpperCase()+"\"", title);
	}




}
