package alıstırmalar2;

import alıstırmalar1.A31_WebTables;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;


public class A01_WebTables extends TestBase {

    //1. Bir metod oluşturun :
    //printData(int row, int column);
    //a. Satır(row) ve sütun(column) numarasını girdiğinizde,
    //printData metodu bu
    //hücredeki(cell) veriyi yazdırmalıdır.
    //2. Baska bir
    //Test metod u oluşturun: printDataTest(
    //a. Ve bu metodu printData(
    //printData() methodunu cagirmak icin kullanin.
    //b. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi
    //yazdırmalıdır
    //c. yazdirilan datanin olmasi gereken dataya esit oldugunu test edin


    @Test
    public void test01() {
       login();


        //1. Bir metod oluşturun :
        //printData(int row, int column);
        //printData() methodunu cagirmak icin kullanin.
        //b. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi
        //yazdırmalıdır
        int satır=5;
        int sutun=3;
        prıntData(satır,sutun);




    }

    public void prıntData(int satır, int sutun) {
        //a. Satır(row) ve sütun(column) numarasını girdiğinizde,
        //printData metodu bu
        //hücredeki(cell) veriyi yazdırmalıdır.
    WebElement yazılacakElement=driver.findElement(By.xpath("//tbody//tr["+satır+"]//td["+sutun+"]"));
        System.out.println(yazılacakElement.getText());
    }
    public void login() {
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
