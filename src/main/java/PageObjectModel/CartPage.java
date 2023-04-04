package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;
    By firstArticle = By.cssSelector(".a-truncate-cut");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstArticle(){
        String name = driver.findElement(firstArticle).getText();
        return name;
    }
}
