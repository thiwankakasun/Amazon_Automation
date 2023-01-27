package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
	
	private WebDriver driver;
	private By gotoCartBtn= By.xpath("//a[contains(text(),'Go to Cart')]");
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
	}

public CartClearPage clickOnGotoCart() {
		try {
			//go back to the cart
			driver.findElement(gotoCartBtn).click();
			return new CartClearPage(driver);
			
		} catch (Exception e) {
			throw e;
		}
	}
}
