package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class SearchProductPage extends BasePage {

    //Constructor metodum
    public SearchProductPage(WebDriver driver) {
        super(driver);
    }

    //Anasayfada "ceket" için arama yapan metod
    public void searchProduct(String text) {
        driver.findElement(By.id("search")).sendKeys(text, Keys.ENTER);
    }

    //Detayları görüntüle butonuna kadar scroll hareketi metodu
    public void scrollToMoreDetails()  {
        WebElement element = driver.findElement(By.xpath("//button[@class='button -secondary -sm relative']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

}


