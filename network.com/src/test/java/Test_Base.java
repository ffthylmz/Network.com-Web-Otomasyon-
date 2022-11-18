import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@ExtendWith(TestResultLogger.class)

public class Test_Base {
    WebDriver driver;


    @BeforeAll
    public void setUp() {

        WebDriverManager.chromedriver().setup(); //Tarayıcıyı ayağa kaldırıyorum.
        driver= new ChromeDriver();

        driver.get("https://www.network.com.tr"); // Verilen site url'sine gidiyorum.
        driver.manage().window().maximize();      // Tarayıcı ekranını genişlettim.
        String expectedUrl= "https://www.network.com.tr/";
        Assertions.assertEquals(expectedUrl, driver.getCurrentUrl()); // URL'in doğru olup olmadığı kontrolünü yapıyorum.
    }



    @AfterAll
    public void shutDown() {
        driver.quit(); // Tüm testler bittikten sonra tarayıcıyı kapatıyorum.
    }

}
