package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HerokuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Practice02 {
    @DataProvider
    public static Object[][] kullanici() {
        return new Object[][]{{ConfigReader.getProperty("email1"),ConfigReader.getProperty("password1")},
                {ConfigReader.getProperty("email2"),ConfigReader.getProperty("password2")},
                {ConfigReader.getProperty("email3"),ConfigReader.getProperty("password3")}  };
    }
    //    Negative Test
//    1.  https://id.heroku.com/login sayfasina gidin
//    2.  Data provider kullanarak mail adres ve passwordleri giriniz
//    3.  Login butonuna tiklayiniz
//    4.  "There was a problem with your login." texti gorunur olduğunu test edin
//    5.  sayfalari kapatiniz

    @Test(dataProvider = "kullanici")//bunu yazinca ustune gel data provider methodunu otomatik yapiyor
    public void test01(String email,String password ) throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("herokuUrl"));
        Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler")).click();
        HerokuPage obj=new HerokuPage();
        obj.email.sendKeys(email);
        Thread.sleep(2000);
        obj.password.sendKeys(password);
        Thread.sleep(2000);
        obj.login.click();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(obj.yazi.isDisplayed());
        Driver.closeDriver();
        softAssert.assertAll();
    }

    @Test
    public void test2() {
    }

    @Test
    public void test1() {
    }
}
