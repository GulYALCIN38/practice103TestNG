package tests.Cross;

import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class CrossTest01 extends TestBaseCross {
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        driver.get("https://www.facebook.com/");
        Thread.sleep(3);
    }
}
