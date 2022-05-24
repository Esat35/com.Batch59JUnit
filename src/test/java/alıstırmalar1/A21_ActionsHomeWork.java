package alıstırmalar1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class A21_ActionsHomeWork extends TestBase {
    //Yeni Class olusturun ActionsClassHomeWork
    //1-"http://webdriveruniversity.com/Actions" sayfasina gidin
    //2 Hover over Me First" kutusunun ustune gelin
    //3 Link 1" e tiklayin
    //4 P opup mesajini yazdirin
    //5 P opup'i tamam diyerek kapatin
    //6-“Click and hold" kutusuna basili tutun
    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
    //8-“Double click me" butonunu cift tiklayin
    @Test
    public void test() throws InterruptedException {
        //1-"http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2 Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoverOverElementi=driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(hoverOverElementi).perform();

        //3 Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")).click();
        //4 Popup mesajini yazdirin
       String alertText=driver.switchTo().alert().getText();
        System.out.println(alertText);
        //5 P opup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6-“Click and hold" kutusuna basili tutun
        WebElement clikAndHoldElementi=driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clikAndHoldElementi).perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdırın
        String clikAndHoldTexti=clikAndHoldElementi.getText();
        actions.release().perform();
        System.out.println(clikAndHoldTexti);
       // 8-“Double click me" butonunu cift tiklayin

        WebElement doubleClikElementi=driver.findElement(By.xpath("//h2"));
        actions.doubleClick(doubleClikElementi).perform();

        Thread.sleep(5000);
    }
}
