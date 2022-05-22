package alıstırmalar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class A26_ActionClass_HomeWork extends TestBase {
    //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2. "Hover over Me First" kutusunun ustune gelin
    //3. "Link 1" e tiklayin
    //4. Popup mesajini yazdirin
    //5. Popup'i tamam diyerek kapatin
    //6. "Click and hold" kutusuna basili tutun
    //7. "Click and hold" kutusunda cikan yaziyi yazdirin
    //8. "Double click me" butonunu cift tiklayin


    @Test
    public void test01() throws InterruptedException {
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2. "Hover over Me First" kutusunun ustune gelin
        Actions action=new Actions(driver);
        WebElement hoverOverelementi=driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        action.moveToElement(hoverOverelementi).perform();

        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("//a[text()='Link 1']")).click();

        //4. Popup mesajini yazdirin
        String alertYazısı=driver.switchTo().alert().getText();
        System.out.println("alertYazısı = " + alertYazısı);

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement clickSndHoldElementi=driver.findElement(By.xpath("//div[@id='click-box']"));
        action.clickAndHold(clickSndHoldElementi).perform();
        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        String clickAndHoldYazısı=clickSndHoldElementi.getText();
        System.out.println("clickAndHoldYazısı = " + clickAndHoldYazısı);
        action.release().perform();
        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickElementi=driver.findElement(By.tagName("h2"));
        action.doubleClick(doubleClickElementi).perform();

        Thread.sleep(5000);

    }
}
