package alıstırmalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class A15_HandleWindows {
    // 1- amazon anasayfaya gidelim
    // 2- url'in  amazon icerdigini test edelim
    // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
    // 4- title'in Best Buy icerdigini test edelim
    // 5- ilk sayfaya donup sayfada java aratalim
    // 6- arama sonuclarinin Java icerdigini test edelim
    // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
    // 8- logonun gorundugunu test edelim

    WebDriver driver;

@Before
    public  void setup() {
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}

@After
    public  void tearDown(){
  driver.quit();
}


@Test
    public void test() {
    // 1- amazon anasayfaya gidelim
    driver.get("https://www.amazon.com");
    String amazonWindowHandleKod= driver.getWindowHandle();
    // 2- url'in  amazon icerdigini test edeli
    String actualAmazonUrl=driver.getCurrentUrl();
    String aranacakKelime="amazon";
    Assert.assertTrue(actualAmazonUrl.contains(aranacakKelime));

    // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
    driver.switchTo().newWindow(WindowType.WINDOW);
    driver.get("https://www.bestbuy.com");
    String bestBuyWindowHandleDegeri=driver.getWindowHandle();

    // 4- title'in Best Buy icerdigini test edelim
    String actualBestBuyTitle=driver.getTitle();
    aranacakKelime="Best Buy";
    Assert.assertTrue(actualBestBuyTitle.contains(aranacakKelime))
    ;
    // 5- ilk sayfaya donup sayfada java aratalim
    driver.switchTo().window(amazonWindowHandleKod);
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

    // 6- arama sonuclarinin Java icerdigini test edelim
    WebElement aramasonuclarıElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
    String aramasonucları=aramasonuclarıElementi.getText();
    aranacakKelime="Java";
    Assert.assertTrue(aramasonucları.contains(aranacakKelime));
    // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
    driver.switchTo().window(bestBuyWindowHandleDegeri);
    // 8- logonun gorundugunu test edelim
    WebElement logoElementi=driver.findElement(By.xpath("//img[@class='logo']"));
    Assert.assertTrue(logoElementi.isDisplayed());


}

}
