package alıstırmalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v99.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class A22_KeyBoardActions extends TestBase {
    //1- Bir Class olusturalim KeyboardActions2
    //2- https://html.com/tags/iframe/ sayfasina gidelim
    //3- video’yu gorecek kadar asagi inin
    //4- videoyu izlemek icin Play tusuna basin
    //5- videoyu calistirdiginizi test edin


    @Test
    public void test01() throws InterruptedException {

        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //3- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //4- videoyu izlemek icin Play tusuna basin
        WebElement iframeElementi = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframeElementi);
        WebElement oynatmaButonu = driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
        oynatmaButonu.click();
        //5- videoyu calistirdiginizi test edin
        WebElement youtubeLogoElementi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeLogoElementi.isEnabled());
        Thread.sleep(1000);
    }
}
