package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.FilterItembyLanguagePage;
import PageObjects.CartClearPage;
import PageObjects.FilterItembyCustomerReviewPage;
import PageObjects.ProductDetailPage;
import PageObjects.FilteredProductListPage;
import PageObjects.FinalPage;
import PageObjects.ShoppingCartPage;

public class AmazonTest extends BaseTest {

	@Test
	public void purchaseItemFromAmazon() throws Exception {

		//2. Select ‘Books’ from the Category list 
		//3.Search for the search term “Automation”
		FilterItembyCustomerReviewPage filterItembyCustomerReviewPage= amazonHomePage.searchforAutomation();
		
		//4. Select Customer Reviews as “4 Stars & Up”
		FilterItembyLanguagePage filterItembyLanguagePage= filterItembyCustomerReviewPage.selectCustomerReview();
		
		//5. Select Language as “English” (
		FilteredProductListPage filteredProductListPage= filterItembyLanguagePage.selectLanguage();
		
		//6. Get the name of the second item from the Product List page.
		String bookName= filterItembyLanguagePage.getSecondBook();
		System.out.print("Book Name"+ bookName);

		//7. Click the second item from the Product List page and navigate to the Product Detail page.
		//8. Get the Unit price of the item displayed in the Product Detail page
		ProductDetailPage productDetailPage= filteredProductListPage.clickSecondBook();
		
		//9. Verify whether the item name of the Product Detail page is same as the item name obtained from the Product List page in step 5.
		Assert.assertEquals(filterItembyLanguagePage.getSecondBook(), productDetailPage.getProductTitle());
		
		//10. Set the Quantity to 2.
		//11. Click on Add to Cart.
		ShoppingCartPage ShoppingCartPage= productDetailPage.clickOnAddtoCart();
		
		//String bookQuantity= toString(productDetailPage.getQuantity());
		
		//12. Click on Go to Cart.
		CartClearPage cartClearPage= ShoppingCartPage.clickOnGotoCart();
		
		//13. Verify whether the cart details are correct.
		Assert.assertEquals(cartClearPage.getItemName(), bookName);
		//Assert.assertEquals(cartClearPage.getCurrentQuantity(), bookQuantity);
		//Assert.assertEquals(cartClearPage.getTotalPrice(), productDetailPage.getUnitPrice());
		
		//14. Clear the cart and verify the total amount is equal to $0.00
		FinalPage finalPage= cartClearPage.itemDelete();
		Assert.assertEquals(finalPage.getSubTotal(), " $0.00");

	}

	

}
