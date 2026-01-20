package stepDefinations;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverManager;
import utils.ExcelUtilities;

public class LoginClass {

	
	 private WebDriver driver;
	 private String heading; 
	 
	 private Object[][] credentials;
	 private int rowIndex = 0;
	 
	 public LoginClass() {
			    this.driver = DriverManager.getDriver();

			}

	    // Step-level Before hook: runs after global Hooks
//	    @Before(order=1)
//	    public void initDriver() {
//	        driver = DriverManager.getDriver(); // get driver initialized by Hooks
//	    }
	    
	 @Given("user is on the login page")
	    public void user_is_on_the_login_page() {
		
		 driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		 
		 
	 }
	 
	 @When("user enters valid {string} and {string}")
	 public void enterCreds(String userName, String password) {
		 driver.findElement(By.cssSelector("#username")).sendKeys(userName);
		 driver.findElement(By.cssSelector("#password")).sendKeys(password);
	 }
	 
	 @And("clicks on the login button")
	 public void clickLogin() {
		 driver.findElement(By.cssSelector("#terms")).click();
		 driver.findElement(By.id("signInBtn")).click();
	 }
	 
	 @Then("user should be redirected to the dashboard")
	 public void getdashboardHeading() {
		 heading = driver.findElement(By.cssSelector("nav a.navbar-brand")).getText();
		 
	 }
	 
	 @And("a welcome message should be displayed {string}")
	 public void validateStatusMessage(String status) throws InterruptedException {
		 Assert.assertEquals(heading, status);
		 Thread.sleep(10000);
		 
	 }
	 
	 
	
	 
	 @Given("user data {string} and {string}")
	    public void printData(String userName, String password) {
		 
		 System.out.println(userName + "  -  " + password);
	    }
}
