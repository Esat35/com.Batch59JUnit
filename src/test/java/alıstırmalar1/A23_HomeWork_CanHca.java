

package alıstırmalar1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class A23_HomeWork_CanHca {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.operadriver().setup();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        String falanFilan = "iPhone 13 512 GB";
        //Notes: It may also be necessary to write code to accept the accept cookies warning.

        //1. Go to 'https://www.amazon.com.tr/'
        driver.get("https://www.amazon.com.tr/");

        //accept cookies
        driver.findElement(By.xpath("(//input[@id='sp-cc-accept'])")).click();

        //Search iPhone13 512
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(falanFilan + Keys.ENTER);

        //Check that the results are listed


        //Click iPhone13 at the top of the list
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();




        if (driver.findElement(By.xpath("(//li[@class='swatch-list-item-text inline-twister-swatch a-declarative desktop-configurator-dim-row-0'])[1]")).isDisplayed()) {
            List<WebElement> list = driver.findElements(By.xpath("//li[@class='swatch-list-item-text inline-twister-swatch a-declarative desktop-configurator-dim-row-0']"));
            for (int i = 0; i < list.size(); i++) {
                list.get(i).click();
                System.out.println(driver.findElement(By.id("productTitle")).getText() + " " + "Size : " + driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base inline-twister-dim-title-value a-text-bold'])[2]")).getText());
                System.out.println("Color: " + driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base inline-twister-dim-title-value a-text-bold'])[1]")).getText() + " " + "Price : " + driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText() + "," + driver.findElement(By.xpath("//span[@class='a-price-fraction']")).getText() + "TL");
                System.out.println("Stock: " + driver.findElement(By.xpath("//div[@id='availability']")).getText());
                System.out.println("---------------------------------------------------------------------------------------");
                Thread.sleep(5000);
            }
        } else if(driver.findElement(By.xpath("(//p[@class='a-text-left a-size-base'])")).isDisplayed()) {

            List<WebElement> list = driver.findElements(By.xpath("(//p[@class='a-text-left a-size-base'])"));
            for (int i = 0; i < list.size(); i++) {
                list.get(i).click();
                System.out.println(driver.findElement(By.id("productTitle")).getText() + " " + "Size : " + driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base inline-twister-dim-title-value a-text-bold'])[2]")).getText());
                System.out.println("Color: " + driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base inline-twister-dim-title-value a-text-bold'])[1]")).getText() + " " + "Price : " + driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText() + "," + driver.findElement(By.xpath("//span[@class='a-price-fraction']")).getText() + "TL");
                System.out.println("Stock: " + driver.findElement(By.xpath("//div[@id='availability']")).getText());
                System.out.println("---------------------------------------------------------------------------------------");
                Thread.sleep(5000);
            }

        }else {
            WebElement list0 = driver.findElement(By.id("size_name_0"));
            list0.click();
            //Log the following values for each size
            //.Size information .Price .Color .Stock status
            System.out.println(driver.findElement(By.id("productTitle")).getText() + " " + "Size : " + driver.findElement(By.xpath("(//span[@class='selection'])[1]")).getText());
            System.out.println("Color: " + driver.findElement(By.xpath("(//span[@class='selection'])[2]")).getText() + " " + "Price : " + driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText() + "," + driver.findElement(By.xpath("//span[@class='a-price-fraction']")).getText() + "TL");
            System.out.println("Stock: " + driver.findElement(By.xpath("//div[@id='availability']")).getText());
            System.out.println("---------------------------------------------------------------------------------------");
            WebElement list1 = driver.findElement(By.id("size_name_1"));
            list1.click();
            //Log the following values for each size
            //.Size information .Price .Color .Stock status
            System.out.println(driver.findElement(By.id("productTitle")).getText() + " " + "Size : " + driver.findElement(By.xpath("(//span[@class='selection'])[1]")).getText());
            System.out.println("Color: " + driver.findElement(By.xpath("(//span[@class='selection'])[2]")).getText() + " " + "Price : " + driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText() + "," + driver.findElement(By.xpath("//span[@class='a-price-fraction']")).getText() + "TL");
            System.out.println("Stock: " + driver.findElement(By.xpath("//div[@id='availability']")).getText());
            System.out.println("---------------------------------------------------------------------------------------");
            WebElement list2 = driver.findElement(By.id("size_name_2"));
            list2.click();
            //Log the following values for each size
            //.Size information .Price .Color .Stock status
            System.out.println(driver.findElement(By.id("productTitle")).getText() + " " + "Size : " + driver.findElement(By.xpath("(//span[@class='selection'])[1]")).getText());
            System.out.println("Color: " + driver.findElement(By.xpath("(//span[@class='selection'])[2]")).getText() + " " + "Price : " + driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText() + "," + driver.findElement(By.xpath("//span[@class='a-price-fraction']")).getText() + "TL");
            System.out.println("Stock: " + driver.findElement(By.xpath("//div[@id='availability']")).getText());

        }
        driver.close();
    }
}