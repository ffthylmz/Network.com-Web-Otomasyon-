package pages;


import java.io.FileWriter;
import java.io.IOException;

public class WriteUsernamePassword {

    public static void main(String[] args) {

        //Kullanıcı Adı ve Şifreyi "csv" formatında 2 farklı dosya ile belirtilen path'e (Masaüstü) yazdırıyorum. (Path'i kontrol etmelisiniz.)
        //Kendi path'inizi yazarken dosya isimlerini değiştirmemelisiniz.
        //Rastgele bir email ve şifre veriyorum.

        //Oluşturduğum network.com/src/main/resources/username-password files klasörünün içinde yer almaktadır, ekstra oluşturmanıza gerek yok !

        try {
            FileWriter writeUsername = new FileWriter("C:\\Users\\...\\Desktop\\network.com\\src\\main\\resources\\username - password files\\Username.csv");

            writeUsername.append("example@mail.com");
            writeUsername.flush();
            writeUsername.close();

            FileWriter writer = new FileWriter("C:\\Users\\...\\Desktop\\network.com\\src\\main\\resources\\username - password files\\Password.csv");

            writer.append("123456789");
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
