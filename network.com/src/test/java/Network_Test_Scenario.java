import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.SearchProductPage;
import pages.SelectAndAddPage;

import java.io.IOException;

public class Network_Test_Scenario extends Test_Base {

    SearchProductPage search;
    SelectAndAddPage selectAndAddPage;


    @Test
    @Order(1)
    public void clickCookies() {
        BasePage basePage = new BasePage(driver);
        basePage.cookies();
    }

    @Test
    @Order(2)
    public void searchProduct() {
        search = new SearchProductPage(driver);
        search.searchProduct("ceket");
    }

    @Test
    @Order(3)
    public void scrollToMoreDetails() throws InterruptedException {
        search = new SearchProductPage(driver);
        search.scrollToMoreDetails();
    }

    @Test
    @Order(4)
    public void turnPage2() {
        //Bu kodda verilen hatada url'yi "https://www.network.com.tr/search?searchKey=ceket" ile değiştirince alttaki gibi istiyor, çözüm üretemedim !
        Assertions.assertEquals("https://www.network.com.tr/search?searchKey=ceket&page=2", driver.getCurrentUrl());
    }


    @Test
    @Order(5)
    public void hoverToFirstItem() {
        selectAndAddPage = new SelectAndAddPage(driver);
        selectAndAddPage.hoverToFirstDiscountProduct();

    }

    @Test
    @Order(6)
    public void clickToGotoBox() {
        selectAndAddPage = new SelectAndAddPage(driver);
        selectAndAddPage.goToShoppingBox();
    }

    @Test
    @Order(7)
    public void checkSizeAndPrice() {
        selectAndAddPage = new SelectAndAddPage(driver);
        Assertions.assertEquals("54/6N", selectAndAddPage.checkBoxSize());
        Assertions.assertEquals("1.799,00 TL", selectAndAddPage.checkBoxPrice());

    }

    @Test
    @Order(8)
    public void checkTheDiscountedPrice() {
        System.out.println(selectAndAddPage.checkTheDiscountedPrice());
    }

    @Test
    @Order(9)
    public void clickToMoveOnButton() {
        selectAndAddPage.clickToMoveOnButton();
    }

    @Test
    @Order(10)
    public void fillTheAccountInfo() throws IOException {
        selectAndAddPage.fillTheUsernameInfo();
        selectAndAddPage.fillThePasswordInfo();
    }


    @Test
    @Order(11)
    public void clickToNetworkLogo(){
        selectAndAddPage.clickToNetworkLogo();
    }

    @Test
    @Order(12)
    public void clickToShoppingBoxLogo(){
        selectAndAddPage.clickShoppingBoxLogo();
    }


    @Test
    @Order(13)
    public void clickToRemoveItem(){
        selectAndAddPage.clickRemoveItem();
    }

    @Test
    @Order(14)
    public void isItEmpty(){
        selectAndAddPage.isItEmpty();
    }
}

