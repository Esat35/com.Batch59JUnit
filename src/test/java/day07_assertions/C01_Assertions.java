package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
    amazon ana sayfaya gidin.
    3 farklı test methodu olusturarak asagıdakı gorevlerı yapın

    1- Url in amazon içerdiğinı test edin
    2- title ın facebook icermedıgını test edın
    3- sol ust kosede amazon logosunun gorundugunu test edın

     */


    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void tearDown() {
      driver.close();
    }


  // 1- Url in amazon içerdiğinı test edin
    @Test
    public void test01() {

       String actualUrl= driver.getCurrentUrl();
       String ararnanKelime="amazon";
        Assert.assertTrue(actualUrl.contains(ararnanKelime));

    }
  // 2- title ın facebook icermedıgını test edın
    @Test
    public void test02() {
        String istenmeyenKelime="facebook";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }
  // 3- sol ust kosede amazon logosunun gorundugunu test edın
    @Test
    public void test03() {
    WebElement logoElementi=driver.findElement(By.id("nav-logo-sprites"));
    Assert.assertTrue(logoElementi.isDisplayed());
    }



}
