

package alıstırmalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class A23_HomeWork extends TestBase {

    @Test
    public void test01() {
        //Test01:
        //1 amazon gi din
        driver.get("https://www.amazon.com");
        //2 Arama kutusunun solundaki drop down menuyu handle edip listesini ekrana yazdırın
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        List<WebElement> tumOptions = select.getOptions();
        tumOptions.stream().map(WebElement::getText).forEach(System.out::println);
        //3 drop down menude 28 eleman olduğunu doğrulayın
        int menuListsayı = tumOptions.size();
        Assert.assertTrue(menuListsayı == 28);
    }
    @Test
    public void test02() throws InterruptedException {
        //Test02
        driver.get("https://www.amazon.com");
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Electronics");
        //2 arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırı n
        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("iphone" + Keys.ENTER);
        //3 sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String sonucSyısı = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        String aranacakKelime = "iphone";
        Assert.assertTrue(sonucSyısı.contains(aranacakKelime));
        //4 ikinci ürüne relative locater kullanarak tıklay in
        WebElement ilkUrun = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]"));
        driver.findElement(RelativeLocator.with(By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']")).below(ilkUrun)).click();
        Thread.sleep(5000);
        //5 ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String title = driver.getTitle();
        WebElement yazı = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-price'])[1]"));
        Assert.assertTrue(yazı.isDisplayed());
        driver.findElement(By.xpath("//a[@title='Add to List']")).click();
    }

    @Test
    public void test3() throws InterruptedException {

        driver.switchTo().newWindow(WindowType.TAB);
        //1 yeni bir sekme açarak amazon a nasayfaya gid in
        driver.get("https://www.amazon.com");

        //2 dropdown’dan bebek bölümüne secin
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Baby");

        //3 bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("baby stroller"+ Keys.ENTER);
        String [] resultString=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText().split(" ");
        System.out.println(resultString[3]);

        //4 sonuç yazsının puset içerdiğini te st edin
        String actualResultString=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        String expectedResultString="stroller";
        Assert.assertTrue(actualResultString.contains(expectedResultString));
        //5 üçüncü ürüne relative locater kullanarak tıklay in
        WebElement firstProduct = driver.findElement(By.xpath("//img[@data-image-index='1']"));
        WebElement secondProduct=driver.findElement(RelativeLocator.with(By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']")).below(firstProduct));
        secondProduct.click();
        Thread.sleep(5000);

        //6 title ve fiyat bilgilerini assign edelim ve ürünü sepete ekley in
        String actualTitle=driver.getTitle();
        WebElement priceElement=driver.findElement(By.xpath("(//span[@aria-hidden='true'])[4]"));
        String priceStroller=priceElement.getText();
        String actualName=driver.findElement(By.xpath("//span[@class='a-size-large product-title-word-break']")).getText();
        int priceStrollerNumber=Integer.parseInt(priceStroller.replaceAll("\\D",""));
        System.out.println("Bebek arabası fiyatı :"+priceStroller+ " Title bilgisi :"+actualTitle);

        if(priceElement.isDisplayed()){
            WebElement addCart=driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']"));
            addCart.click();
        }else{
            System.out.println("Price bilgisi bulunamadi");
            driver.quit();
        }

        //price bilgisi yok ise test hata veriyor

        //1sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

        WebElement gotocart=driver.findElement(By.xpath("//a[@href='/gp/cart/view.html?ref_=sw_gtc']"));
        gotocart.click();
        WebElement cartPrice=driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-buybox']"));
        String priceCart=cartPrice.getText();
        int priceCartNumber=Integer.parseInt(priceCart.replaceAll("\\D",""));
        System.out.println(priceCartNumber+" "+priceStrollerNumber);
        Assert.assertEquals(priceCartNumber,priceStrollerNumber);
        String expectedName=driver.findElement(By.xpath("//span[@class='a-truncate-cut']")).getText();
        Assert.assertEquals(expectedName,actualName);

    }

}
