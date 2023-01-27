package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartClearPage {
	
	private WebDriver driver;
	private By itemName = 
	By.xpath("//body/div[@id='a-page']/div[2]/div[3]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[2]/ul[1]/li[1]/span[1]/a[1]/span[1]/span[1]");
	private By currentQuantity = By.xpath("//span[@id='a-autoid-0-announce']");
	private By totalPrice= By.xpath("//span[@id='sc-subtotal-amount-activecart']");
	private By deleteBtn = 
			By.xpath("//body/div[@id='a-page']/div[2]/div[3]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/span[2]/span[1]");

	
	public CartClearPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public String getItemName() throws Exception {
		try {
			//get book title from Cart Clear Page
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			String bookTitle = driver.findElement(itemName).getText();
			return bookTitle;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String getTotalPrice() throws Exception {
		try {
			//get Total price from Cart Clear Page
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			String bookPrice = driver.findElement(totalPrice).getText();
			return bookPrice;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public String getCurrentQuantity() throws Exception {
		try {
			//get book quantity from Cart Clear Page
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			String bookQuantity = driver.findElement(currentQuantity).getText();
			return bookQuantity;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public FinalPage itemDelete() throws Exception{
		try {
			//Delete the item from the cart
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(deleteBtn).click();
			
			return new FinalPage(driver);
		} catch (Exception e) {
			throw e;
		}
	}
	

}
