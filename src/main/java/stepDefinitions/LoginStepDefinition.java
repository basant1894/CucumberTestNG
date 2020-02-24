package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition {
	
	//ChromeDriver driver;
	WebDriver driver;
	
	@Given("^user is already on Login Page$")
	public void user_is_already_on_Login_Page(){
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.freecrm.com/");
	}
	@When("^title of Login page is Free CRM$")
	public void title_of_Login_page_is_Free_CRM(){
		String title=driver.getTitle();
		System.out.println(title);
	}
	@Then("^user enters username and password$")
	public void user_enters_username_and_password(String username, String password){
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("username")).sendKeys(password);	
	}
	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button(){
		WebElement loginbtn= driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input")); //here we can directly use .click() 
		JavascriptExecutor jsx=(JavascriptExecutor)driver;
		jsx.executeScript("arguments[0].click():", loginbtn);
	}
	@Then("^user is on home page$")
	public void user_is_on_home_page(){
		String title=driver.getTitle();
		System.out.println("Home Page Title :"+title);
		
	}

}



