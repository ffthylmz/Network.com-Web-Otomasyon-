package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class SelectAndAddPage extends BasePage {

    SelectAndAddPage selectAndAddPage;
    ReadUsernamePassword readUsernamePassword;

    Logs log;

    public SelectAndAddPage(WebDriver driver) {
        super(driver);
    }

    //İlk indirimli ürün için hover yapılan div ve beden seçim metodu
    public void hoverToFirstDiscountProduct() {  //"Ceket" aramasındaki ilk indirimli ürün elementine hover yap.
        Actions action = new Actions(driver);

        WebElement we = driver.findElement(By.xpath("//div[@class='product js-product-133579 gtm-added']"));
        action.moveToElement(we).build().perform();

        driver.findElement(By.xpath("//label[@extcode='1080890006']")).click();
    }


    //Sepete Git butonu için yazılan metod
    public void goToShoppingBox() {

        selectAndAddPage = new SelectAndAddPage(driver);
        waitFor(2);
        driver.findElement(By.xpath("//a[text()='Sepete Git']")).click();

    }

    //Aranan ürün ile sepete eklenen ürünün beden kontrolü metodu
    public String checkBoxSize() {
        waitFor(1);
        return driver.findElement(By.xpath("//div[@class='cartItem__attr -size']/span[2]")).getText();
    }

    //Aranan ürün ile sepete eklenen ürünün fiyat kontrolü metodu
    public String checkBoxPrice() {
        waitFor(1);
        return driver.findElement(By.xpath("//span[@class='cartItem__price -sale']")).getText();
    }


    //Bu metodda indirimli fiyat ile indirimsiz fiyatın aralarında yapılan karşılaştırmayı yazmaya çalıştım.
    public boolean checkTheDiscountedPrice() {
        String actualValue = driver.findElement(By.xpath("//span[@class='cartItem__price -old -labelPrice']")).getText();

        //log4j kütüphanesini spesifik olarak bu string ifadeyi logladım.
        log.info(actualValue);

        String discountedValue = driver.findElement(By.xpath("//span[@class='cartItem__price -sale']")).getText();
        //"replace()" metodunu kullanma sebebim şahsi bilgisayarımda ondalıklı sayıları "." ile ayırdığı içindir.
        double actualPrice = Double.parseDouble(actualValue.substring(0, actualValue.length() - 3).replace(".", "").replace(",", "."));
        double discountedPrice = Double.parseDouble(discountedValue.substring(0, discountedValue.length() - 3).replace(".", "").replace(",", "."));

        if (actualPrice > discountedPrice)
            return true;
        else
            return false;
    }

    //Devam Et butonuna taklanılan metod
    public void clickToMoveOnButton() {
        driver.findElement(By.xpath("//button[@class='continueButton n-button large block text-center -primary']")).click();
    }


    //ReadUsernamePassword classında oluşturduğum metodlarım ile müşteri hesap email'ini yazdırdım.
    public void fillTheUsernameInfo() throws IOException {
        waitFor(1);
        readUsernamePassword = new ReadUsernamePassword(driver);
        WebElement weUsername = driver.findElement(By.xpath("//input[@id='n-input-email']"));
        weUsername.sendKeys(readUsernamePassword.username());
    }

    //ReadUsernamePassword classında oluşturduğum metodlarım ile müşteri hesap şifre'sini yazdırdım.
    public void fillThePasswordInfo() throws IOException {
        waitFor(1);
        readUsernamePassword = new ReadUsernamePassword(driver);
        WebElement wePassword = driver.findElement(By.xpath("//input[@id='n-input-password']"));
        wePassword.sendKeys(readUsernamePassword.password());
    }

    //Network logosuna tıklanılan metod
    public void clickToNetworkLogo() {
        waitFor(1);
        driver.findElement(By.xpath("//a[@class='headerCheckout__logo']")).click();

    }

    //Anasayfadaki sepetim logosuna tıklanılan metod
    public void clickShoppingBoxLogo() {
        waitFor(1);
        driver.findElement(By.xpath("//button[@class='header__basketTrigger js-basket-trigger -desktop']")).click();
    }

    //Sepetteki ürünün kaldırılması için yazılan metod
    public void clickRemoveItem() {
        waitFor(1);
        driver.findElement(By.xpath("//div[@class='header__basketProductBtn header__basketModal -remove']")).click();
        waitFor(0.5);
        driver.findElement(By.xpath("//button[@class='btn -black o-removeCartModal__button']")).click();
        waitFor(0.5);
        driver.findElement(By.xpath("//button[@class='header__basketTrigger js-basket-trigger -desktop']")).click();
        waitFor(3);
    }

    //Alışveriş sepetinin boş olduğunun kontrol metodu
    public void isItEmpty() {

        WebElement isItEmpty = driver.findElement(By.xpath("//span[@class='header__emptyBasketText']"));
        if (isItEmpty.isDisplayed())
            System.out.println("Alışveriş Sepeti Boştur.");
        else
            System.out.println("Alışveriş Sepeti Doludur!.");

    }


}
