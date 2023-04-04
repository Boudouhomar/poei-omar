package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {

    WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstResult(){

        WebElement firstResult = driver.findElement(By.cssSelector(".a-size-base-plus.a-color-base.a-text-normal"));
        return firstResult.getText() ;

    }

    public ProductPage openFirstReslt(){
        driver.findElement(By.cssSelector(".a-size-base-plus.a-color-base.a-text-normal")).click();
        return new ProductPage(driver);
    }
}
