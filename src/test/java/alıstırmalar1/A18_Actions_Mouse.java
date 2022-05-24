package alıstırmalar1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class A18_Actions_Mouse extends TestBase {
    // 1- Yeni bir class olusturalim: MouseActions1
    //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
    //3- Cizili alan uzerinde sag click yapalim
    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
    //    test edelim.
    //5- Tamam diyerek alert’i kapatalim
    //6- Elemental Selenium linkine tiklayalim
    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    @Test
    public void test() {

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement cizgiliAlanElementi = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlanElementi).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //    test edelim.
        String alertText = driver.switchTo().alert().getText();
        String alertBeklenenText = "You selected a context menu";
        Assert.assertEquals(alertBeklenenText, alertText);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaWindowHandleKodu = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> windowHandles = driver.getWindowHandles();

        String ikinciSayfaWindowHAndleKodu = "";
        for (String each : windowHandles) {
            if (!each.equals(ilkSayfaWindowHandleKodu)) {
                ikinciSayfaWindowHAndleKodu = each;
            }
        }

        driver.switchTo().window(ikinciSayfaWindowHAndleKodu);
        WebElement h1TagiElementi = driver.findElement(By.xpath("//h1"));
        String h1TagiTexti = h1TagiElementi.getText();
        String h1TagıBeklenenText = "Elemental Selenium";
        Assert.assertEquals(h1TagıBeklenenText, h1TagiTexti);

    }


}
