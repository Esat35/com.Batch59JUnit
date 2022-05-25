package alıstırmalar2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class A03_HomeWork_CanHca extends TestBase {


    //1. "https://www.saucedemo.com" Adresine gidin
    //2. Username kutusuna "standard_user" yazdirin
    //3. Password kutusuna "secret_sauce" yazdirin
    //4. Login tusuna basin
    //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    //6. Add to Cart butonuna basin
    //7. Alisveris sepetine tiklayin
    //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
    //9. Sayfayi kapatin


    @Test
    public void test01() {
        driver.get("https://www.saucedemo.com");
        WebElement userNameKutusu = driver.findElement(By.id("user-name"));
        Actions actions = new Actions(driver);

        actions.click(userNameKutusu).sendKeys("standard_user")
                .sendKeys(Keys.TAB).sendKeys("secret_sauce").sendKeys(Keys.ENTER).perform();

        String ilkUrunİsmi = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
        System.out.println("ilkUrunİsmi = " + ilkUrunİsmi);
        driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

        String sepettekiUrunAdi = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();

        Assert.assertEquals(ilkUrunİsmi, sepettekiUrunAdi);
    }
}
