package steps;


import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.CustomPage;
import pageObjects.HomePage;
import utils.Context;

public class SearchBook {
	private HomePage homePage;
	private Context context;
	private WebDriver driver;	
	private CustomPage customPage;
	
	public SearchBook (Context context) {
		this.context = context;
		driver = context.getDriver();
		homePage = new HomePage(driver);
		customPage = new CustomPage(driver);
	}

	@Given("^I enter search (.*)")
	public void i_enter_search (String bookName) {
	    homePage.enterSearch(bookName);

	}

	@When("^I click Search button")
	public void i_click_Search_button() {
	    homePage.searchButton();
	    
	}

	@Then("^The search result must be greater than cero")
	public void the_search_result_must_be_greater_than_cero () {
	    customPage.assertSearch();
	    System.out.println("Test Results: " + customPage.assertSearch());
		//System.out.print("RESULTS");
	   
	}
}
