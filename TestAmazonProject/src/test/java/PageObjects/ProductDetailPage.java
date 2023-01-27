package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ProductDetailPage {
	
	private WebDriver driver;
	private By unitPrice = 
	By.xpath("");
	private By productTitle= By.id("productTitle");
	private By addCartBtn= By.xpath("//input[@id='add-to-cart-button']");
	
	
	
	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getUnitPrice() throws Exception {
		try {
			//get the unit price
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			String bookPrice = driver.findElement(unitPrice).getText();
			return bookPrice;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public WebElement getQuantity() throws Exception {
		try {
			//get the quantity
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Select drpQty = new Select(driver.findElement(By.name("quantity")));
			WebElement firstSelectedOption = drpQty.getFirstSelectedOption();
			 return firstSelectedOption;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String getProductTitle() throws Exception {
		try {
			//get the product title
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			String bookTitle = driver.findElement(productTitle).getText();
			return bookTitle;
		 }
		catch (Exception e) {
			throw e;
		}
	}
	
public ShoppingCartPage clickOnAddtoCart() throws Exception{
		
		try{
			//select the 2 items from the dropdown
			Select drpQty = new Select(driver.findElement(By.name("quantity")));
			drpQty.selectByVisibleText("2");
			//add the items to cart
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(addCartBtn).click();
			return new ShoppingCartPage(driver);
		}catch(Exception e) {
			throw e;
		}
		
	}

}
