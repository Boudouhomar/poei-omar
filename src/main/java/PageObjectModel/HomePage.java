package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    final static int TIMEOUT_SIDE_PANEL = 5;
    By menuHamburger = By.cssSelector("nav-hamburger-menu");
    public HomePage(WebDriver driver) {
        this.driver = driver;

    }

    public void goToGamesAndConsolesPage(){

        driver.findElement(menuHamburger).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        WebElement buttonMenuJeuxVideo = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-menu-id='12']")));
        buttonMenuJeuxVideo.click();
        WebElement toutLesJeuxVideo = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("ul.hmenu.hmenu-visible.hmenu-translateX > li:nth-child(3) > a"))));
        toutLesJeuxVideo.click();

    };

    public SearchResultPage search(String keyword){
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(keyword + Keys.ENTER);
        return new SearchResultPage(driver);
    };

    public void closeCookiePopup(){
        driver.findElement(By.id("sp-cc-accept")).click();
    };
}
