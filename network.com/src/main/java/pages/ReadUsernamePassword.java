package pages;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadUsernamePassword extends BasePage{

    public ReadUsernamePassword(WebDriver driver) {
        super(driver);
    }

    //Lütfen çalıştığınız bilgisayarda aşağıdaki path'leri düzenleyiniz.

    //Oluşturulan csv dosyasından username'i çektiğim metod
    public  String username() throws IOException{
        Path filePathUsername=Path.of("C:\\Users\\...\\Desktop\\network.com\\src\\main\\resources\\username - password files\\Username.csv");
        return Files.readString(filePathUsername);
    }

    //Oluşturulan csv dosyasından password'ü çektiğim metod
    public  String password() throws IOException{
        Path filePathPassword=Path.of("C:\\Users\\...\\Desktop\\network.com\\src\\main\\resources\\username - password files\\Password.csv");
        return Files.readString(filePathPassword);
    }


}