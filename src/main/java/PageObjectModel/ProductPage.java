package PageObjectModel;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    final static int TIMEOUT_SIDE_PANEL = 5;
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPrice() {

        String actualPrice = driver.findElement(By.cssSelector("span.a-price.aok-align-center > span span.a-price-whole")).getText();
        actualPrice = actualPrice + "." + driver.findElement(By.cssSelector("span.a-price.aok-align-center > span span.a-price-fraction")).getText();

        return actualPrice;
    }

    public String getAvailableDate() {
        String availability = driver.findElement(By.id("availability")).getText();;

        return availability;
    }

    public ProductPage addToCart(){
        driver.findElement(By.id("add-to-cart-button")).click();
        return new ProductPage(driver);
    }

    public ProductPage refuseInsurance(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.a-button-input[aria-labelledby=\"attachSiNoCoverage-announce\"]"))).click();
        return new ProductPage(driver);
    }

    public CartPage openCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#attach-sidesheet-view-cart-button"))).click();
        return new CartPage(driver);
    }

    public void getProductTitle(int index){

    }
}
