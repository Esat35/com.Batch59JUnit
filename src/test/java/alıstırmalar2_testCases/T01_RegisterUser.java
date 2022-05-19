package alıstırmalar2_testCases;

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

public class T01_RegisterUser {
    //Test Case 1: Register User
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'New User Signup!' is visible
    //6. Enter name and email address
    //7. Click 'Signup' button
    //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    //9. Fill details: Title, Name, Email, Password, Date of birth
    //10. Select checkbox 'Sign up for our newsletter!'
    //11. Select checkbox 'Receive special offers from our partners!'
    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    //13. Click 'Create Account button'
    //14. Verify that 'ACCOUNT CREATED!' is visible
    //15. Click 'Continue' button
    //16. Verify that 'Logged in as username' is visible
    //17. Click 'Delete Account' button
    //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        //    driver.close();
    }

    @Test
    public void test() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignUpElementi = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignUpElementi.isDisplayed());

        //6. Enter name and email address
        WebElement nameElementi = driver.findElement(By.xpath("//input[@name='name']"));
        nameElementi.sendKeys("hasan");
        WebElement emailElementi = driver.findElement(By.xpath("(//input[@name='email'])[2]"));
        emailElementi.sendKeys("asgkodhfhd@gmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountElementi = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccountElementi.isEnabled());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//input[@name='title']")).click();

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1235487");

        WebElement dayMenuElelemnti = driver.findElement(By.xpath("//select[@id='days']"));
        Select select = new Select(dayMenuElelemnti);
        select.selectByVisibleText("12");

        WebElement mounthMenuElementi = driver.findElement(By.xpath("//select[@id='months']"));
        select = new Select(mounthMenuElementi);
        select.selectByVisibleText("June");

        WebElement yearMenuElementi = driver.findElement(By.xpath("//select[@id='years']"));
        select = new Select(yearMenuElementi);
        select.selectByVisibleText("2013");

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Hasan");
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("BAKAN");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Techproeducation");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Techpro/ izmir/Turkey");
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("konak /IZMIR");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("konak");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("IZMIR");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("123-145");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("0555-4587878");

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountYazısı=driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(accountYazısı.isDisplayed());

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[text()='Continue']")).click();

      // //16. Verify that 'Logged in as username' is visible
   //   WebElement loggedinAssElementi=dayMenuElelemnti.findElement(By.xpath("(//header/div//li)[9]"));
   //  Assert.assertTrue(loggedinAssElementi.isDisplayed());

        //17. Click 'Delete Account' button
      //  driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button


    }

}
