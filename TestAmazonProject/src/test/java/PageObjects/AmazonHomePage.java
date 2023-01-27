package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomePage {
	
	private WebDriver driver;	
	private By dropDownBook = By.xpath("//option[contains(text(),'Books')]");
	private By searchField = By.xpath("//input[@id='twotabsearchtextbox']");

	
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public FilterItembyCustomerReviewPage searchforAutomation() throws Exception{
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			//select Book from drop down
			driver.findElement(dropDownBook).click();
			
			//search the books using Automation keyword
			WebElement search = driver.findElement(searchField);
			search.findElement(searchField);
			search.sendKeys("Automation");
			search.sendKeys(Keys.ENTER);
					
			return new FilterItembyCustomerReviewPage(driver);
		} catch (Exception e) {
			throw e;
		}
	}
	
	


}
