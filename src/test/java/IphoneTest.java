import PageObjectModel.CartPage;
import PageObjectModel.HomePage;
import PageObjectModel.ProductPage;
import PageObjectModel.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IphoneTest {

    WebDriver driver;



    @BeforeMethod
    public void testGoogle(){
        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr");
    }

    @Test
    public void testOne() {
        String keyword = "iPhone 13";

        HomePage homePage = new HomePage(driver);
        homePage.closeCookiePopup();
        String name = homePage.search(keyword)
                        .openFirstReslt()
                        .addToCart()
                        .refuseInsurance()
                        .openCart()
                        .getFirstArticle();
        Assert.assertTrue(name.contains(keyword),"L'article recherché ne figure pas dans le panier");

    }
}
