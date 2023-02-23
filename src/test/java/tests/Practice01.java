package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.Dhtmlpage;
import utilities.ConfigReader;
import utilities.Driver;

public class Practice01 {
    /*
--http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html adresine gidiniz
--Tüm ülkeleri yazdırınız
--Ülkeler ile şehirleri eşleştiriniz
 */
    @Test
    public void test01(){
        //--http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("dhtmlUrl"));
        //--Tüm ülkeleri yazdırınız
        Dhtmlpage obj=new Dhtmlpage();
        for(WebElement w: obj.ulkeler){
            System.out.println(w.getText());
        }
        //--Ülkeler ile şehirleri eşleştiriniz

        Actions actions= new Actions(Driver.getDriver());
       /* for (int i = 1; i <8 ; i++) {
            actions.dragAndDrop(Driver.getDriver().findElement(By.id("box"+i)), Driver.getDriver().findElement(By.id("box10"+i))).perform();
        }*/

        actions.dragAndDrop(obj.Seoul,obj.Korea).
                dragAndDrop(obj.oslo,obj.Norway).
                dragAndDrop(obj.Stockholm,obj.Sweden).
                dragAndDrop(obj.Washington,obj.abd).
                dragAndDrop(obj.Rome,obj.Italy).
                dragAndDrop(obj.Madrid,obj.Spain).
                dragAndDrop(obj.Copenhagen,obj.Denmark).perform();


    }

}
