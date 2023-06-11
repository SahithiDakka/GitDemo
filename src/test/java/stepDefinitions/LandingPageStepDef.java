package stepDefinitions;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TextContext;

public class LandingPageStepDef {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	
	TextContext textContextt;
	public LandingPageStepDef (TextContext textContext) {
		this.textContextt=textContext;
	}

@Given("User is on GreenCart landing page")
public void user_is_on_green_cart_landing_page()throws InterruptedException{
    System.out.println("User is on greencart landing page");
    //basic to invoke web driver
    System.setProperty("webdriver.chrome.driver","C:\\Users\\sahit\\OneDrive\\Documents\\chromedriver_win32\\chromedriver.exe");
    textContextt.driver=new ChromeDriver();
    textContextt.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
}
@When("User searched with Shortname {string} and extract actual name of product")
public void user_searched_with_shortname_and_extract_actual_name_of_product(String shortName)throws InterruptedException {
	
  System.out.println("search for a product"); 
  textContextt.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
  Thread.sleep(2000);
  textContextt.landingPageProductName=textContextt.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
  Thread.sleep(2000);
  System.out.println("Product name extarcted from home page "+textContextt.landingPageProductName);
}

}
