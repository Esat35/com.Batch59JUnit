package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_TumSayfaScreenShot extends TestBase {
    @Test
    public void tumSayfaScreanShot() throws IOException {
        //amazon sayfasına gıdıp tum sayfanın fotografını cekelım.
        driver.get("https://www.amazon.com");

        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmmss");

        LocalDateTime date=LocalDateTime.now();
      String tarih=  date.format(dtf);
        System.out.println("tarih = " + tarih);

        TakesScreenshot ts= (TakesScreenshot) driver;
        File tumSayfaResim=new File("target/ekranGoruntuleri/tumSayfa"+tarih+".jpeg");
        File geciciResim=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,tumSayfaResim);






    }
}
