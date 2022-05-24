package alıstırmalar1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;


public class A31_WebTables extends TestBase {

    //●login(login() metodun oluşturun ve oturum
    //●https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
    //○Username : manager
    //○Password : Manager 1
    //●table(table() metodu oluşturun
    //○Tüm table body’sinin boyutunu(s utun sayisi ) bulun. /tbody
    //○Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    //●printRows(printRows() metodu oluşturun //tr
    //○table body’sinde bulunan toplam satir(row) sayısını bulun.
    //○Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    //○4.satirdaki(row) elementleri konsolda yazdırın.

    @Test
    public void webTables() {
        //●login(login() metodun oluşturun ve oturum açın
        login();

        //●table(table() metodu oluşturun

        //○Tüm table body’sinin boyutunu(s utun sayisi ) bulun. /tbody
        List<WebElement> bodyLİst = driver.findElements(By.xpath("//thead//tr[1]//th"));
        int bodyBoyut = bodyLİst.size();
        System.out.println("sutun sayisi : " + bodyBoyut);

        //○Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

        //●printRows(printRows() metodu oluşturun //tr
        //○table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satırlarListesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satir sayisi :" + satırlarListesi.size());
        //○Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each:satırlarListesi
             ) {
            System.out.println(each.getText());
        }
        //○4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> dorduncuSatırHucreleriListesi=driver.findElements(By.xpath("//tbody//tr[4]//td"));

        for (WebElement each:dorduncuSatırHucreleriListesi
             ) {
            System.out.println(each.getText());
        }


        //  Email basligindaki tum elementleri(sutun) konsolda yazdırın.
        // once email basliginin kacinci sutunda oldugunu bulalim
        List<WebElement> baslıklarListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        int stunNo=0;
        for (int i = 0; i <baslıklarListesi.size() ; i++) {
            if (baslıklarListesi.get(i).getText().equals("Email")){
                stunNo=i;
            }
        }

        List<WebElement> emailStunListesi=driver.findElements(By.xpath("//tbody//td["+(stunNo+1)+"]"));
        for (WebElement each:emailStunListesi
             ) {
            System.out.println(each.getText());
        }

    }

    public void login() {
        //●https://www.hotelmycamp.com
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        // admin/HotelRoomAdmin adresine gidin
        //○Username : manager
        WebElement userNAmeElementi = driver.findElement(By.xpath("//input[@class='form-control required']"));
        userNAmeElementi.sendKeys("manager");

        //○Password :Manager1!
        WebElement posswordElementi = driver.findElement(By.xpath("//input[@class='form-control required password']"));
        posswordElementi.sendKeys("Manager1!");
        driver.findElement(By.xpath("//input[@class='btn btn-primary py-3 px-5']")).click();
    }
}
