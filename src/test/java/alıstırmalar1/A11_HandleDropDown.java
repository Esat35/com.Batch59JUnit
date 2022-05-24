package alıstırmalar1;

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

public class A11_HandleDropDown {
    //1.
    //http ://zero.webappsecurity .com Adresine gidin
    //2. Sign in butonuna basin
    //3. Login kutusuna “username” yazin
    //4. Password kutusuna “password.” yazin
    //5. Sign in tusuna basin
    //6. Pay Bills sayfasina gidin
    //7. “Purchase Foreign Currency” tusuna basin
    //8. “Currency” drop down menusunden Eurozone’u secin
    //9. “amount” kutusuna bir sayi girin
    //10. “US Dollars” in secilmedigini test edin
    //11. “Selected currency” butonunu secin
    //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

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
        //1.
        //http://zero.webappsecurity.com Adresine gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        //4. Password kutusuna “password.” yazin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@name='submit']")).click();

      driver.navigate().back();



        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Eurozone (euro)");

        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("9");

        //10. “US Dollars” in secilmedigini test edin
        WebElement dollarsRadioButtonElementi = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(dollarsRadioButtonElementi.isSelected());

        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();

        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.xpath("(//div[@class='pull-right'])[2]")).click();


        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='alert_content']")).isDisplayed());

    }
}
