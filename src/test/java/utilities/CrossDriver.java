package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class CrossDriver {
    private CrossDriver() {
        // constracter private yapildi  boylece burdan obje olusturulamaz
    }

    /*
            Driver daki temel mantık extents yöntemiyle değil yani TestBase class'ına extent etmek yerine
        Driver class'ından statik methodlar kullanarak driver oluştururuz.
        1-İlk olarak public static WebDriver getDriver() methodu oluşturmak. Bu method bize bir driver getirecek
        2-Driver'i kapatacağımız zaman da public static void closeDriver() methodu oluşturmak. İstediğimiz zaman
        bu methodla driver'i kapatacağız
         */
    static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        browser=(browser==null)? ConfigReader.getProperty("browser") : browser;
        //eger browser a bir deger atanmadi ise configreader daki browser calissin

        if (driver == null) {//eger driver bossa deger ata eger deger atanmissa driver i ayni sayfada return yap
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }
        return driver;

    }

    public static void closeDriver() {
        if (driver != null) {//driver a deger atanmissa
            driver.close();
            driver=null;
        }
    }
    public static void quitDriver() {
        if (driver != null) {//driver a deger atanmissa
            driver.quit();
            driver=null;
        }
    }
}