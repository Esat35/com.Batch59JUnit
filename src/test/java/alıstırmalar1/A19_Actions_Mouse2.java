package alıstırmalar1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class A19_Actions_Mouse2 extends TestBase {

    //1- https://demoqa.com/droppable adresine gidelim
    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test() throws InterruptedException {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement dragmeElementi = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHereElementi = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragmeElementi, dropHereElementi).perform();

        Thread.sleep(2000);

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement sonucYazıElementi=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String actualYazı=sonucYazıElementi.getText();
        String expectedYazı="Dropped!";
        Assert.assertEquals(expectedYazı,actualYazı);
    }

}
