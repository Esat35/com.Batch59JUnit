package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01 {

    /*
    ...Exercise1...
    BeforeClass ile driver ı olusturun ve class icinde static yapin
    Maximize edin, 15 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatın
 */
  static   WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.google.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Before
    public void testtenonce() {
        driver.get("http://www.google.com");
    }

    @Test
    public  void test01() {
       // arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Green Mile"+ Keys.ENTER);

    }

    @After
    public void testtenSonra() {
        WebElement aramaSonucları=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("aramaSonucları.getText() = " + aramaSonucları.getText());
    }

    @Test
    public void test02() {
       // arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
      WebElement aramaKutusu=  driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
      aramaKutusu.sendKeys("Premonition");
      aramaKutusu.submit();


    }

    @Test
    public void test03() {
        //arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
        WebElement aramaKutusu=  driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        aramaKutusu.sendKeys("The Curious Case of Benjamin Button");
        aramaKutusu.submit();
    }
}
