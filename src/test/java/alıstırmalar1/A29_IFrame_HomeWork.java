package alıstırmalar1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class A29_IFrame_HomeWork extends TestBase {
    //Iframe H ome W ork

    //1.“https://webdriveruniversity.com/” sayfasina gidin
    //Iframe i tıklayın
    //2.“Our Products” butonuna basin
    //3.“Cameras product”i tiklayin
    //Popup mesajini yazdirin
    //5.“close” butonuna basin
    //6."WebdriverUniversity.com IFrame )" linkini tiklayin
    //7."https://webdriveruniversity.com/index.htm" adresine gittigini test edin

    @Test
    public void test01() {


        //1.“http://webdriveruniversity. IFrame /index.html” sayfasina gidin
        driver.get("https://webdriveruniversity.com/");
        String ilkSayfaWindowHandleKodu = driver.getWindowHandle();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//h1[text()='IFRAME']")).click();
        Set<String> tumWindowHandleKumesi = driver.getWindowHandles();
        String ikinciSayfaWindowHandleDegeri = "";
        for (String each : tumWindowHandleKumesi
        ) {
            if (!each.equals(ilkSayfaWindowHandleKodu)) {
                ikinciSayfaWindowHandleDegeri = each;
            }

        }
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);
        //2.“Our Products” butonuna basin
        WebElement iframeElementi = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframeElementi);
        driver.findElement(By.xpath("//a[text()='Our Products']")).click();
        //3.“Cameras product”i tiklayin
        driver.findElement(By.xpath("//p[text()='Cameras']")).click();
        //Popup mesajini yazdirin
        String popupMesajı = driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
        //5.“close” butonuna basin
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]")).click();

        //6."WebdriverUniversity.com IFrame )" linkini tiklayin
        driver.switchTo().window(ilkSayfaWindowHandleKodu);
        driver.findElement(By.xpath("(//a[@class='navbar-brand'])[1]")).click();
        //7."https://webdriveruniversity.com/index.htm" adresine gittigini test edin
        String expectedUrl="https://webdriveruniversity.com/index.html";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);


    }
}
