package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BestBuyAssertions {
    //1)
    //Bir class oluşturun: BestBuy Assertions
    //2)
    //https://www.bestbuy.com/ A dresine gidin farkli test method’lari olusturarak asagidaki
    //testleri yapin
    //○Sayfa URL’inin https://www.bestbuy.com/ com/‘a esit oldugunu test edin
    //○titleTest => Sayfa başlığının “ Rest” içer mediğini(contains) test edin
    //○logoTest => BestBuy logosunun görüntülen digini test edin
    //○Francais LinkTest => Fransizca Linkin görüntüle n diğini test edin
    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }
    @Test
    public void urlTest() {
        // 1- https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin

        //○ Sayfa URL’inin https://www.bestbuy.com/ esit oldugunu test edin
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("url test FAİLED",actualUrl,expectedUrl);
    }
    @Test
    public void titleTest () {
        //○ titleTest => Sayfa başlığının “ Rest” içermediğini(contains) test edin

        String actualTitle = driver.getTitle();
        String istenmeyenKelime = "Rest";
        Assert.assertFalse("baslik Rest kelimesi iceriyor",actualTitle.contains(istenmeyenKelime));
    }
    @Test
    public void logoTest () {
        //○ logoTest => BestBuy logosunun görüntülendigini test edin

        WebElement logoElementi = driver.findElement(By.xpath("(//img[@alt=\"Best Buy Logo\"])[1]"));
        Assert.assertTrue("logo goruntulenmiyor",logoElementi.isDisplayed());
    }
    @Test
    public void fransizcaLinkTesti () {
        //○ Francais LinkTest => Fransizca Linkin görüntülendiğini test edin

        WebElement francaisElementi=driver.findElement(By.xpath("//button[@lang=\"fr\"]"));
        Assert.assertTrue("fransizca link goruntulenmiyor",francaisElementi.isDisplayed());
    }


}
