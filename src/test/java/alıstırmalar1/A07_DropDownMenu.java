package alıstırmalar1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class A07_DropDownMenu {
    /* amazon'a gidip
       dropdown'dan books secenegini secip
       Java aratalim

       ve arama sonuclarinin Java icerdigini test edelim
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }


    @After
    public void tearDown() {
        driver.close();
    }


    @Test
    public void test() {
        //amazon'a gidip
        driver.get("https://www.amazon.com");

        //dropdown'dan books secenegini secip
        WebElement dropDownMenuElementi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDownMenuElementi);
        select.selectByValue("search-alias=stripbooks-intl-ship");


        //Java aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);

        //ve arama sonuclarinin Java icerdigini test edelim
        WebElement aramaSonuclarıElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String aramaSonuclari = aramaSonuclarıElementi.getText();
        String aranacakKelime = "Java";
        Assert.assertTrue(aramaSonuclari.contains(aranacakKelime));

        System.out.println(aramaSonuclarıElementi.getText());

    }

}