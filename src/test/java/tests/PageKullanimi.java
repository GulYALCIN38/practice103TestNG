package tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class PageKullanimi {

    @Test(groups = "gp1")
    public void test() {
        Driver.getDriver().get("https://amazon.com");

        AmazonPage amazonPage = new AmazonPage();
        //iphon aratalim
        amazonPage.aramaKutusu.sendKeys("iphone", Keys.ENTER);
        //sonuc yazısının iphone içerdiğini test edelim
        assert amazonPage.sonucYazisi.getText().contains("iphone");
    }
}
