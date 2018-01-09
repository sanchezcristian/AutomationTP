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

	@Given("^I click Search button")
	public void i_click_Search_button() {
	    homePage.searchButton();
	    
	}
	
	@When("^I sort the list results by (.*)$")
	public void i_sort_the_list_result_by (String orderType) throws InterruptedException{
		customPage.iSortTheSearch(orderType);
	}

	@Then("^The search results must be ordered by (.*)$")
	public void the_search_results_must_be_ordered_by (String orderType) {
	    customPage.assertSearch(orderType);
	    //System.out.println("Test Results: " + customPage.assertSearch(orderType));
		//System.out.print("RESULTS");
	   
	}
}
