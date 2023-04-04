package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GamesAndConsolesPage {

    WebDriver driver;
    By bestSell = By.cssSelector("[cel_widget_id='handsfree-browse_OctopusBestSellerAsin'] span.a-list-item");

    public GamesAndConsolesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openBestSeller(){
        WebElement bestSeller = driver.findElement(bestSell);
        bestSeller.click();


    }
    public String getTitleBestSeller(){
        WebElement bestSeller = driver.findElement(bestSell);
        return bestSeller.getText().split("\n")[2];
    }
}
