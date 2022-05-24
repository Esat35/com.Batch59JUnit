package alıstırmalar1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class A28_Task_HomeWork extends TestBase {
    //Notes: It may also be necessary to write code to accept the accept cookies warning.
    //1. Go to 'https://www.amazon.com.tr/'
    //2. Search iPhone13 512
    //3. Check that the results are listed
    //4. Click iPhone13 at the top of the list
    //5. Log the following values for each size
    //.Size information .Price .Color .Stock status
    //We expect an output similar to this screenshot.


    @Test
    public void test01() {
        //Notes: It may also be necessary to write code to accept the accept cookies warning.
        //1. Go to 'https://www.amazon.com.tr/'
        driver.get("https://www.amazon.com.tr/");

        WebElement cerezler=driver.findElement(By.xpath("//input[@name='accept']"));
        cerezler.click();
        //2. Search iPhone13 512
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone 13 512 gb"+ Keys.ENTER);

        //3. Check that the results are listed
        String aramaSonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String aranacakKelime="iphone 13 512 gb";
        Assert.assertTrue(aramaSonucYazisi.contains(aranacakKelime));

        //4. Click iPhone13 at the top of the list
        driver.findElement(By.xpath("//a[@class='a-link-normal s-no-outline']")).click();

        //5. Log the following values for each size
        //.Size information .Price .Color .Stock status
        //We expect an output similar to this screenshot.
        String baslık=driver.findElement(By.id("productTitle")).getText();
        System.out.println(baslık);
        String fiyat=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();

        System.out.println("fiyat :"+fiyat);

        String stokDurumu=driver.findElement(By.xpath("//div[@id='availability']")).getText();
        System.out.println(stokDurumu);

    }
}
