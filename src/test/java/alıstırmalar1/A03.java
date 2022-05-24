package alıstırmalar1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class A03 {
    //1 C01_TekrarTesti isimli bir class olusturun
    //2 https://www.google.com/ adresine gidin
    //3 cookies uyarisini kabul ederek kapatin
    //4 Sayfa basliginin “Google” ifadesi icerdigini test edin
    //5 Arama cubuguna “Nutella” yazip aratin
    //6 Bulunan sonuc sayisini yazdirin
    //7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    //8 Sayfayi kapatin
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {

        //2 https://www.google.com/ adresine gidin
        driver.get("https://www.google.com");
        //3 cookies uyarisini kabul ederek kapatin

        //4 Sayfa basliginin “Google” ifadesi icerdigini test edin
        String baslık = driver.getTitle();
        String aranacakDeger = "Google";

        if (baslık.contains(aranacakDeger)) {

            System.out.println("Baslık testı PASSED");
        } else {
            System.out.println("Baslık testı FAILED");
        }

        //5 Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@title='Ara']")).sendKeys("Nutella" + Keys.ENTER);
        //6 Bulunan sonuc sayisini yazdirin
        WebElement sonucSayısı = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("Sonuc sayısı: " + sonucSayısı.getText());
        //7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        String arr[] = sonucSayısı.getText().split(" ");
        System.out.println("arr = " + Arrays.toString(arr));

        int sonucSayısı2 = Integer.parseInt(arr[1].replaceAll("\\D", ""));
        System.out.println("sonuc sayısı : " + sonucSayısı2);
        if (sonucSayısı2 > 10000000) {
            System.out.println("Sonuc sayısı twsti PASSED");
        } else {
            System.out.println("Sonuc sayısı twsti FAILED");
        }

        //8 Sayfayi kapatin
    }
}
