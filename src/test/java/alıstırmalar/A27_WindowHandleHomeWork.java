package alıstırmalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class A27_WindowHandleHomeWork extends TestBase {
    //Window H andle H ome W ork
    //1."http://webdriveruniversity.com/" adresine gidin
    //2."Login Portal" a kadar asagi inin
    //3."Login Portal" a tiklayin
    //4.Diger window'a gecin
    //5."username" ve "password" kutularina deger yazdirin
    //6."login" butonuna basin
    //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
    //8.Ok diyerek Popup'i kapatin
    //9.Ilk sayfaya geri donun
    //10.Ilk sayfaya donuldugunu test edin


    @Test
    public void test01() throws InterruptedException {
        //1."https://www.webdriveruniversity.com/" adresine gidin
        driver.get("https://www.webdriveruniversity.com/");
        //2."Login Portal" a kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);
        //3."Login Portal" a tiklayin
        String ilkSayfaHandleDegeri=driver.getWindowHandle();
        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();
        //4.Diger window'a gecin
        Set<String> tumWindowHandleKumesi=driver.getWindowHandles();

        String ikinciSayfaWindowHandleDegeri="";
        for (String each:tumWindowHandleKumesi
             ) {
            if (!each.equals(ilkSayfaHandleDegeri)){
              ikinciSayfaWindowHandleDegeri=each;
            }
        }
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);
Thread.sleep(5000);
        //5."username" ve "password" kutularina deger yazdirin
        WebElement userNameElementi=driver.findElement(By.xpath("//input[@id='text']"));
        userNameElementi.sendKeys("hasan");

        WebElement passwordElementi=driver.findElement(By.xpath("//input[@id='password']"));
        passwordElementi.sendKeys("12365478994");

        //6."login" butonuna basin
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
        Thread.sleep(5000);

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedYazi="validation failed";
        String actualYazı=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazı);

        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaHandleDegeri);
        //10.Ilk sayfaya donuldugunu test edin
        String expectedIlkSayfaUrl="https://www.webdriveruniversity.com/";
        String actualIlkSayfaUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedIlkSayfaUrl,actualIlkSayfaUrl);

        Thread.sleep(5000);


    }
}
