package alıstırmalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class A10_DropDownAmazon {
    //●Bir class oluşturun: C3_ DropDown Amazon
    //●https://www.amazon.com/ adresine gidin.
    //-
    //Test 1
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28
    //oldugunu test edin
    //-
    //Test 2
    //1.
    //Kategori menusunden Books secenegini secin
    //2.
    //Arama kutusuna Java yazin ve aratin
    //3.
    //Bulunan sonuc sayisini yazdirin
    //4. Sonucun Java kelimesini icerdigini test edin

   static WebDriver driver;

    @BeforeClass
    public  static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");


    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        //Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28
        //oldugunu test edin

        WebElement kategoriMenusuElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(kategoriMenusuElementi);
        int actualKategoriSayisi=select.getOptions().size();
        int expectedKategoriSayisi=28;

        Assert.assertTrue(actualKategoriSayisi==expectedKategoriSayisi);
    }

    @Test
    public void test02() {
        //1.
        //Kategori menusunden Books secenegini secin

        WebElement kategoriMenusuElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(kategoriMenusuElementi);
        select.selectByVisibleText("Books");



        //2.
        //Arama kutusuna Java yazin ve aratin

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

        //3.
        //Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucSayisi.getText());

        //4. Sonucun Java kelimesini icerdigini test edin

        String actualSonucSayısı=sonucSayisi.getText();
        String aranacakKelime="Java";
        Assert.assertTrue(actualSonucSayısı.contains(aranacakKelime));

    }
}
