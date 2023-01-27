package PageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilterItembyLanguagePage {
	
	private WebDriver driver;
	private By language = By.id("p_n_feature_nine_browse-bin/3291437011");
	private By secondBook = By.xpath("//span[contains(text(),'Network Programmability and Automation: Skills for')]");
	public FilterItembyLanguagePage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public FilteredProductListPage selectLanguage() throws Exception{
		try {
			//filter using language
			driver.findElement(language).click();
			
			return new FilteredProductListPage(driver);
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	
	public String getSecondBook() throws Exception {
		try {
			//get the book title from the filtered list
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			String bookName = driver.findElement(secondBook).getText();
			return bookName;
		} catch (Exception e) {
			throw e;
		}
		 
	}	

}
