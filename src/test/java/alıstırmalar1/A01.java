package alıstırmalar1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class A01 {
    /*
    1 C01_TekrarTesti isimli bir class olusturun
    2 https://www.amazon.com/ adresine gidin
    3 Browseri tam sayfa yapin
    4 Sayfayi “refresh” yapin
    5 Sayfa basliginin “Spend less” ifadesi icerdigini test edin
    6 Gift Cards sekmesine basin
    7 Birthday butonuna basin
    8 Best Seller bolumunden ilk urunu tiklayin
    9 Gift card details’den 25 $’i secin
    10 Urun ucretinin 25$ oldugunu test edin
    10 Sayfayi kapatin
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teraDown() {
        driver.close();
    }


    @Test
    public void test01() {

        // 2 https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com");
        // 3 Browseri tam sayfa yapin
        driver.manage().window().fullscreen();
        // 4 Sayfayi “refresh” yapin
        driver.navigate().refresh();
        // 5 Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String sayfaBaslıgı = driver.getTitle();
        String baslıktaAranacakDeger = "Spend less";

        if (sayfaBaslıgı.contains(baslıktaAranacakDeger)) {
            System.out.println("Sayfa baslıgı testi PASSED");
        } else {
            System.out.println("Sayfa baslıgı testi FAILED");
        }
        // 6 Gift Cards sekmesine basin
        driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
        driver.findElement(By.xpath("(//a[@tabindex='0'])[8]")).click();
        // 7 Birthday butonuna basin
        driver.findElement(By.xpath("//img[@alt='Birthday gift cards']"));

        // 8 Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//span[@class='nav-a-content'])[2]")).click();
        driver.findElement(By.xpath("(//img[@alt='Amazon.com eGift Card'])[1]")).click();
        // 9 Gift card details’den 25 $’i secin
        WebElement urunUcretiElementi = driver.findElement(By.xpath("//span[@id='a-autoid-28']"));
        urunUcretiElementi.click();
        // 10 Urun ucretinin 25$ oldugunu test edin
        if (urunUcretiElementi.getText().equals("$25")) {
            System.out.println("urun ucreti testi PASSED");
        } else {
            System.out.println("urun ucreti testi FAILED");
        }

        // 10 Sayfayi kapatin


    }
}
