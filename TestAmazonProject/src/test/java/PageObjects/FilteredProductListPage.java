package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilteredProductListPage {
	
	private WebDriver driver;
	private By secondBook = By.xpath("//span[contains(text(),'Network Programmability and Automation: Skills for')]");
	
	
	public FilteredProductListPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public ProductDetailPage clickSecondBook() throws Exception{
		try {
			//go to the second item in filtered product list
			driver.findElement(secondBook).click();
			
			return new ProductDetailPage(driver);
		} catch (Exception e) {
			throw e;
		}
		
	}

}
