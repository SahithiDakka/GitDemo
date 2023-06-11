package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import utils.TextContext;

public class OfferPageStepDef {
	public String offerPageProductName;
	
	TextContext textContextt;
	public OfferPageStepDef(TextContext textContext) {
		this.textContextt=textContext;
	}
	@Then("User search for {string} Shortname in offers page")
	public void user_search_for_shortname_in_offers_page_to_check_the_product_exist_with_same_name(String shortName)throws InterruptedException {
	   System.out.println("search for same product in offfers page");
	   switchToOffersPage();
	   textContextt.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	   Thread.sleep(2000);
	offerPageProductName=textContextt.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();  
	}
	//for loosely coupled and reusability of code
	public void switchToOffersPage() {
		//break point
		//if you are already switched to child
//		if(textContextt.driver.getCurrentUrl().equalsIgnoreCase(https://rahulshettyacademy.com/seleniumPractise/#/offers)){
//	}
		textContextt.driver.findElement(By.linkText("Top Deals")).click();
		   Set<String> s1=textContextt.driver.getWindowHandles();
		   Iterator<String> i1=s1.iterator();
		   String parentWindow=i1.next();
		   String childWindow=i1.next();
		   textContextt.driver.switchTo().window(childWindow);
	}
	@Then("Validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page()throws InterruptedException {
	    System.out.println("validation step");
	    Assert.assertEquals(offerPageProductName, textContextt.landingPageProductName);
	    Thread.sleep(2000);
	    textContextt.driver.quit();
	}
}
