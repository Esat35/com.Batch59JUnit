package alıstırmalar1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class A32_WebTables extends TestBase {

    //●login(login() metodun oluşturun ve oturum

    @Test
    public void test01() {
        login();

        //○Tüm table body’sinin boyutunu(s utun sayisi ) bulun. /tbody
        List<WebElement> tumBodyListesi=driver.findElements(By.xpath("//tbody"));
        for (WebElement each:tumBodyListesi
             ) {
            System.out.println(each.getText());
        }
        //○Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        List<WebElement> baslıklarListesi=driver.findElements(By.xpath("//thead//tr//th"));
        for (WebElement each:baslıklarListesi
        ) {
            System.out.println(each.getText());
        }
        //●printRows(printRows() metodu oluşturun //tr
        //○table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satırListesi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("toplam satır sayisi : "+satırListesi.size());

        //○Table body’sinde bulunan satirlari(rows) konsolda yazdırın.

        for (WebElement each:satırListesi
        ) {
            System.out.println(each.getText());
        }
        //○4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> dorduncuSatirHücreleri=driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each:dorduncuSatirHücreleri
        ) {
            System.out.println(each.getText());
        }
        //●printCells(printCells() metodu oluşturun //td
        //○table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        //○Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        List<WebElement> hucreSayilari=driver.findElements(By.xpath("//tbody//tr//td"));
        System.out.println("toplam hucre sayisi : "+hucreSayilari.size());
        for (WebElement each:hucreSayilari
        ) {
            System.out.println(each.getText());
        }
        //●printColumns(printColumns() metodu oluşturun
        //○table body’sinde bulunan toplam sutun(column) sayısını bulun.
        //○Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        List<WebElement> sutunListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("sutun sayısı : "+sutunListesi.size());
        for (WebElement each:sutunListesi
        ) {
            System.out.println(each.getText());
        }

        //○5.column daki elementleri konsolda yazdırın.
        List<WebElement> besinciSutun=driver.findElements(By.xpath("//tbody//tr//td[5]"));

        for (WebElement each:besinciSutun
        ) {
            System.out.println(each.getText());
        }


    }

    private void login() {
        //●https://www.hotelmycamp.com/Account/Logon adresine gidin
        driver.get("https://www.hotelmycamp.com/Account/Logon");

        //○Username : manager
        Actions actions = new Actions(driver);
        WebElement usernameElementi = driver.findElement(By.xpath("//input[@id='UserName']"));


        actions.click(usernameElementi).sendKeys("manager").sendKeys(Keys.TAB).
        sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();


        // ○Password : Manager2!
    }



}
