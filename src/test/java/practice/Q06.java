package practice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;


public class Q06 {
      /*
      ...Exercise6...
   // 1. Amazon.com'a gidelim.
   // 2. DropDown üzerinde Books secelim.(All yazan yerde)
   //    kategorilerin hepsini konsola yazdiralim
   // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
   // 4. Sonuc sayisini ekrana yazdiralim.
   // 5. Sonucların Les Miserables i icerdigini assert edelim
   */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test() {
        // 2. DropDown üzerinde Books secelim.(All yazan yerde)
        //    kategorilerin hepsini konsola yazdiralim
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        List<WebElement> ddmList = select.getOptions();
        ddmList.stream().map(WebElement::getText).forEach(System.out::println);
        // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Les Miserables");
        aramaKutusu.submit();

        // 4. Sonuc sayisini ekrana yazdiralim.
        WebElement sonucSayısıElementi=driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        System.out.println(sonucSayısıElementi.getText());

        // 5. Sonucların Les Miserables i icerdigini assert edelim

        String sonucSayısı = sonucSayısıElementi.getText();
        String aranacakCumle="Les Miserables";
        Assert.assertTrue(sonucSayısı.contains(aranacakCumle));
    }
}
