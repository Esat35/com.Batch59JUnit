package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class Q03 {

        /*
         ...Exercise3...
        // http://the-internet.herokuapp.com/add_remove_elements/
        // click on the "Add Element" button 100 times

        // write a function that takes a number, and clicks the "Delete" button
        // given number of times, and then validates that given number of
        // buttons was deleted

        1.method : createButtons(100)
        2.deleteButtonsAndValidate()
     */

    static WebDriver driver;
    Scanner scan = new Scanner(System.in);

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void testtenOnce(){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test
    public void test01(){
        WebElement addElement = driver.findElement(By.xpath("//button[text()='Add Element']"));
        clickonAddElement100times(addElement);

        deleteButtonsAndValidate();
    }

    private void deleteButtonsAndValidate() {
        int silinecekAdet = 50;
        do {
            driver.findElement(By.xpath("(//button[@class='added-manually'])[ " + silinecekAdet + "]")).click();
            silinecekAdet--;
        } while (silinecekAdet>0);

        System.out.println(100 - (driver.findElements(By.xpath("(//button[@class='added-manually'])")).size()) + " adet button silindi." );
    }

    private void clickonAddElement100times(WebElement addElement) {
        for (int i = 0; i < 100; i++) {
            addElement.click();
        }
    }
}