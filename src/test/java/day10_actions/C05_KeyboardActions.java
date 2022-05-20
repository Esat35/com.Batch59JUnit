package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.awt.*;

public class C05_KeyboardActions extends TestBase {

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.amazon.com");


        //once arama kutusuna klık yapıp sonra harf harf Nutella yazısını yollayalım.
        //sonra da enter tusuna basalım

        Actions actions = new Actions(driver);
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(aramaKutusu).perform();
        actions.keyDown(Keys.SHIFT).
                sendKeys("n")
                .keyUp(Keys.SHIFT)
                .sendKeys("u")
                .sendKeys("t")
                .sendKeys("e")
                .sendKeys("l")
                .sendKeys("l")
                .sendKeys("a")
                .sendKeys(Keys.ENTER).perform();


        Thread.sleep(5000);


    }
}
