package alıstırmalar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class A20_KeyBoardActionsFaceBook extends TestBase {
    // facebook anasayfaya gidip
    // yeni kayit olustur butonuna basin
    // isim kutusunu locate edip,
    // geriye kalan alanlari TAB ile dolasarak
    // formu doldurun


    @Test
    public void test01() throws InterruptedException {
        // facebook anasayfaya gidip
        driver.get("https://www.facebook.com");
        // yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        // isim kutusunu locate edip,
        // geriye kalan alanlari TAB ile dolasarak
        // formu doldurun
        WebElement isimKutusuElementi = driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']"));
        Actions actions=new Actions(driver);
        actions.click(isimKutusuElementi).
        sendKeys("hasan").
        sendKeys(Keys.TAB).
        sendKeys("Sert")
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("12")
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys("2020")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        Thread.sleep(5000);
    }
}
