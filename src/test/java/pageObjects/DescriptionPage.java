package pageObjects;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DescriptionPage {
	
	private WebDriver driver;	
	
	public DescriptionPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkDescriptionPage () throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//String text = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div[1]/div[2]/h2")).getAttribute("innerText");
		//System.out.print("--------HERE----------->>>> " + text);
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div[1]/div[2]/h2")).getAttribute("innerText").equals("Description"));
	}

}
