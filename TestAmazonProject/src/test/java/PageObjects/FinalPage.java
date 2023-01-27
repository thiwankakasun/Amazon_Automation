package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinalPage {

	private WebDriver driver;
	private By subTotal= By.xpath("//span[@id='sc-subtotal-amount-activecart']");
	
	public FinalPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getSubTotal() {
		try {
			//get the sub total once remove the added items from the cart
			return driver.findElement(subTotal).getText();

		} catch (Exception e) {
			throw e;
}
	}
}
