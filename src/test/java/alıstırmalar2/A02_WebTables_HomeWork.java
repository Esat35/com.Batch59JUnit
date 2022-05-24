package alıstırmalar2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class A02_WebTables_HomeWork extends TestBase {

    //1. https://demoqa.com/webtables” sayfasina gidin
    //2. Headers da bulunan department isimlerini yazdirin
    //3. sutunun basligini yazdirin
    //4. Tablodaki tum datalari yazdirin
    //5. Tabloda kac cell (data) oldugunu yazdirin
    //6. Tablodaki satir sayisini yazdirin
    //7. Tablodaki sutun sayisini yazdirin
    //8. Tablodaki 3.kolonu yazdirin
    //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
    //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini
    //girdigimde bana datayi yazdirsin

    @Test
    public void test01() {

        //https://demoqa.com/webtables" sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //2. Headers da bulunan department isimlerini yazdirin
        List<WebElement> headarsList = driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        int departmentsNo = 0;
        for (int i = 0; i < headarsList.size(); i++) {

            if (headarsList.get(i).getText().equals("Department")) {
                departmentsNo = i;
            }
        }
        List<WebElement> departmansList = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][" + (departmentsNo + 1) + "]"));
        //div[@class='rt-tr-group']//div[@class='rt-td'][6]
        departmansList.stream().map(WebElement::getText).forEach(System.out::println);

        //3. sutunun basligini yazdirin
        headarsList.stream().map(WebElement::getText).forEach(System.out::println);
        //4. Tablodaki tum datalari yazdirin
        System.out.println("***********");
        WebElement tumDataPrint = driver.findElement(By.xpath("//div[@class='rt-table']"));
        System.out.println(tumDataPrint.getText());
        //5. Tabloda kac cell (data) oldugunu yazdirin
        List<WebElement> cellSayı = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td']"));
        System.out.println(cellSayı.size());
        int count = 0;
        for (int i = 0; i < cellSayı.size(); i++) {

            if (!cellSayı.get(i).getText().equals(null)) {
                count++;
            }
        }
        System.out.println("cell sayısı: " + count);
        //6. Tablodaki satir sayisini yazdirin
        List<WebElement> satırSayısı = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("tablodaki satır sayısı: " + satırSayısı.size());

        //7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki sutun sayısı: " + headarsList.size());

        //8. Tablodaki 3.kolonu yazdirin
        List<WebElement> kolonYazdır = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][3]"));
        kolonYazdır.stream().map(WebElement::getText).forEach(System.out::println);
        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin

        int salaryNo = 0;
        for (int i = 0; i < headarsList.size(); i++) {

            if (headarsList.get(i).getText().equals("Salary")) {
                salaryNo = i;
            }
        }
        List<WebElement> salaryList = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][" + (salaryNo + 1) + "]"));
        List<WebElement> firstNameList = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][1]"));
        int satır = 0;
        for (int i = 0; i < firstNameList.size(); i++) {
            if (firstNameList.get(i).getText().equals("Kierra")) {
                satır = i;
            }
        }
        String KierraSalary = driver.
                findElement(By.xpath("//div[@class='rt-tr-group'][" + (satır + 1) + "]//div[@class='rt-td'][" + (salaryNo + 1) + "]")).getText();

        System.out.println("KierraSalary = " + KierraSalary);
        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini
        //girdigimde bana datayi yazdirsin
        int satir = 3;
        int sutun = 4;

        dataYazdır(satır, sutun);
    }

    private void dataYazdır(int satır, int sutun) {
        String satırSutunDAtası = driver.findElement(By.xpath("//div[@class='rt-tr-group'][" + (satır) + "]//div[@class='rt-td'][" + (sutun) + "]")).getText();
        System.out.println("satırSutunDAtası = " + satırSutunDAtası);
    }
}
