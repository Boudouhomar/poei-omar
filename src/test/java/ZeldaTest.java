import PageObjectModel.GamesAndConsolesPage;
import PageObjectModel.HomePage;
import PageObjectModel.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ZeldaTest {

    WebDriver driver;



    @BeforeMethod
    public void testGoogle(){
        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr");
    }

    @Test
    public void testOne(){
        HomePage homePage = new HomePage(driver);

        homePage.closeCookiePopup();
        homePage.goToGamesAndConsolesPage();

        GamesAndConsolesPage gamesAndConsolesPage = new GamesAndConsolesPage(driver);

        String nameOfGame = gamesAndConsolesPage.getTitleBestSeller();
        Assert.assertEquals("The Legend of Zelda : Tears of the Kingdom",nameOfGame);

        gamesAndConsolesPage.openBestSeller();

        ProductPage productPage = new ProductPage(driver);
        String price = productPage.getPrice();
        Assert.assertEquals("54.99",price,"The price is not 54.99");
        String availability = productPage.getAvailableDate();
        Assert.assertTrue(availability.contains("Cet article paraîtra le 12 mai 2023"),"La date de dispo n'est pas celle attendu");
    }
}
