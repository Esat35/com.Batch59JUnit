package alıstırmalar1;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class A12_IFrameTest {
  //●Bir class olusturun: IframeTest

  //●https://the-internet.herokuapp.com/iframe adresine gidin.
  //●Bir metod olusturun: iframeTest
  //○“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
  //○Text Box’a “Merhaba Dunya!” yazin.
  //○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
  //dogrulayin ve konsolda yazdirin.
     WebDriver driver;


    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //●https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
    }



    //●Bir metod olusturun: iframeTest
    @Test
    public void iframeTest() {
        //○“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin
        WebElement iFrameTextElementi=driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));

        Assert.assertTrue(iFrameTextElementi.isEnabled());
        System.out.println(iFrameTextElementi.getText());

        //○Text Box’a “Merhaba Dunya!” yazin.

        WebElement iframeElementi=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElementi);
        WebElement textBoxElementi=driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBoxElementi.click();
        textBoxElementi.clear();

        textBoxElementi.sendKeys("Merhaba dunya!");

        //○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //dogrulayin ve konsolda yazdirin.
        driver.switchTo().parentFrame();
        WebElement elementalSelenıumElementi=driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        Assert.assertTrue(elementalSelenıumElementi.isDisplayed());
        System.out.println(elementalSelenıumElementi.getText());

    }

    @After
    public void tearDown() {
        driver.close();
    }

}
