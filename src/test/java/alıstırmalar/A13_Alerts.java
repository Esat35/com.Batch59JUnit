package alıstırmalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class A13_Alerts {
    //● Bir class olusturun: Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //● Bir metod olusturun: acceptAlert
    //      ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //      “You successfully clicked an alert” oldugunu test edin.
    //● Bir metod olusturun: dismissAlert
    //      ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //      “successfuly” icermedigini test edin.
    //● Bir metod olusturun: sendKeysAlert
    //      ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    //      OK butonuna     tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Before
    public void once() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    //● Bir metod olusturun: acceptAlert
    @Test
    public void acceptAlert() {
        //      ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //      “You successfully clicked an alert” oldugunu test edin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

        String actualResaultMesaji=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResaultMesji="You successfully clicked an alert";
        Assert.assertEquals(expectedResaultMesji,actualResaultMesaji);



    }


    //● Bir metod olusturun: dismissAlert
    @Test
    public void dismissAlert(){

        //      ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //      “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String actualResaultMesaji=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String unExpectedResaulMesaji="successfuly";
        Assert.assertFalse(actualResaultMesaji.contains(unExpectedResaulMesaji));
    }

    //● Bir metod olusturun: sendKeysAlert
    @Test
    public void sendKeysAlert(){
        //      ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
        //      OK butonuna     tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Esat");
        driver.switchTo().alert().accept();

        String actualResaultMesaji=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResaultMesji="Esat";

        Assert.assertTrue(actualResaultMesaji.contains(expectedResaultMesji));
    }

}
