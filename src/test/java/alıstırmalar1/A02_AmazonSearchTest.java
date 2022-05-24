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

public class A02_AmazonSearchTest {
    //Cass W ork A mazon S earch T est
    //1 https://www.amazon.com/ sayfasina gidelim
    //2 arama kutusunu locate edelim
    //3--“Samsung headphones” ile arama yapalim
    //4 Bulunan sonuc sayisini yazdiralim
    //5 Ilk urunu tiklayalim
    //6 Sayfadaki tum basliklari yazdiralim

    WebDriver driver;

    @Before
    public  void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public  void down() {
        driver.close();
    }



    @Test
    public  void test01(){
        //1 https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com");
        //2 arama kutusunu locate edelim
        WebElement aramakutusuElementi=driver.findElement(By.id("twotabsearchtextbox"));

        //3--“Samsung headphones” ile arama yapalim
        aramakutusuElementi.sendKeys("Samsung headphones"+ Keys.ENTER);

        //4 Bulunan sonuc sayisini yazdiralim
        WebElement aramaSonucSayısıElementi=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println(aramaSonucSayısıElementi.getText());
        //5 Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]")).click();
        //6 Sayfadaki tum basliklari yazdiralim
      String baslıklar=driver.getTitle();
        System.out.println("baslıklar = " + baslıklar);
    }



}
