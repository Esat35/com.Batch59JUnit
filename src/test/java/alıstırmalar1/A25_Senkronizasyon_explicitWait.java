package alıstırmalar1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class A25_Senkronizasyon_explicitWait extends TestBase {

    //2. Bir metod olusturun : isEnabled()
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Textbox’in etkin olmadigini(enabled) dogrulayın
    //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    //7. Textbox’in etkin oldugunu(enabled) dogrulayın.


    @Test
    public void isanabled() {
        //2. Bir metod olusturun : isEnabled()
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBoxElementi=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBoxElementi.isEnabled());
        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement itsEnabledElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's enabled!\"]")));
        Assert.assertTrue(itsEnabledElementi.isDisplayed());

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
       Assert.assertTrue(textBoxElementi.isEnabled());
    }
}
