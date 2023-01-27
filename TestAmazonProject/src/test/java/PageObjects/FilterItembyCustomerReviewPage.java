package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterItembyCustomerReviewPage{

	private WebDriver driver;
	private By customerReview = By.id("p_72/1250221011");
	private By language = By.id("p_n_feature_nine_browse-bin/3291437011");
	public FilterItembyCustomerReviewPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public FilterItembyLanguagePage selectCustomerReview() throws Exception{
		try {
			//filter using Customer Review
			driver.findElement(customerReview).click();
			//wait until Loading English language
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(language));
			return new FilterItembyLanguagePage(driver);
			
		} catch (Exception e) {
			throw e;
		}
	}

}
