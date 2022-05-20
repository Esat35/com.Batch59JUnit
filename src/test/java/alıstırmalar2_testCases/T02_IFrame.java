package alıstırmalar2_testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T02_IFrame extends TestBase {
    @Test
    public void test01() {

        //1- https://www.rediff.com/   a git
        //2- money linkıne tıklayın
        WebElement moneyIframeElementi=driver.findElement(By.xpath("//iframe[@id='moneyiframe']"));
      driver.switchTo().frame(moneyIframeElementi);
        System.out.println(driver.findElement(By.xpath("//div[@class='div_container']")).getText());
    }


}
