package alıstırmalar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
       WebElement yeniKayıtButonuElementi=driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        Actions actions=new Actions(driver);
        actions.click(yeniKayıtButonuElementi).perform();
        // isim kutusunu locate edip,
        // geriye kalan alanlari TAB ile dolasarak
        // formu doldurun
        WebElement isimKutusuElementi = driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']"));

        actions.click(isimKutusuElementi)
                .sendKeys("Ahmet"+ Keys.TAB)
                .sendKeys("Kaya"+Keys.TAB)
                .sendKeys("3235353535"+Keys.TAB)
                .sendKeys("sfdsdf@dfdfg.com"+Keys.TAB+Keys.TAB)

                .sendKeys("12"+Keys.TAB)
                .sendKeys("May"+Keys.TAB)
                .sendKeys("1987"+Keys.TAB+Keys.TAB)
                .sendKeys(Keys.RIGHT).moveToElement(driver.findElement(By.xpath("(//button[@type='submit'])[2]")))
                .click()


                .perform();





        Thread.sleep(5000);
    }
}
