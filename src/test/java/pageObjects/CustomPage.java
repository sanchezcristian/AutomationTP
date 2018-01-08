package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class CustomPage {
	
	private By searchResult = By.className("search-count");
	private WebDriver driver;
	
	public CustomPage (WebDriver driver) {
		this.driver = driver;
	}

	
	public int assertSearch () {
		int results = Integer.valueOf(driver.findElement(searchResult).getText());
		Assert.assertTrue(results > 0);
		return results;
	}
	
	public void printResults () {
		System.out.print("Test Results" + assertSearch());
	}
}
