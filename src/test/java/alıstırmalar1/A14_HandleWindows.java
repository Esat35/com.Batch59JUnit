package alıstırmalar1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class A14_HandleWindows {

    // 1- amazon ana sayfaya gidin
    // 2- nutella icin arama yaptirin
    // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
    // 4- yeni tab'da acilan urunun title'ini yazdirin
    // ilk sayfaya gecip url'i yazdiralim
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {

        // 1- amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");
        String amazonWindowHandleKod = driver.getWindowHandle();
        // 2- nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect']")).click();
        // 4- yeni tab'da acilan urunun title'ini yazdirin
        String yeniPencereTitle = driver.getTitle();
        System.out.println("yeniPencereTitle = " + yeniPencereTitle);
        // ilk sayfaya gecip url'i yazdiralim
        driver.switchTo().window(amazonWindowHandleKod);
        String amazonActualUrl = driver.getCurrentUrl();
        System.out.println("amazonActualUrl = " + amazonActualUrl);
    }

}
