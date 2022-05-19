package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        //once arama kutusuna klık yapıp sonra harf harf Nutella yazısını yollayalım.
        //sonra da enter tusuna basalım

        Actions actions=new Actions(driver);
        actions.click(aramaKutusu).perform();








    }
}
