package alıstırmalar1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class A30_Cookies extends TestBase {
    //Cookies C lass W ork
    //Yeni bir class olusturun : cookiesAutomation
    //1 Amazon anasayfaya gidin
    //2 tum cookie’leri listeleyin
    //3 Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    //4 ismi i18n prefs olan cookie degerinin USD oldugunu test edin
    //5 ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
    //6 eklediginiz cookie’nin sayfaya eklendigini test edin
    //7 ismi skin olan cookie’yi silin ve silindigini test edin
    //8 tum cookie’leri silin ve silindigini test edin


    @Test
    public void cookiesAutomation() {
        //1 Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2 tum cookie’leri listeleyin
        Set<Cookie> cookieSet = driver.manage().getCookies();
        int coockieNo = 1;
        for (Cookie each : cookieSet) {
            System.out.println(coockieNo + ". cookie  : " + each);
            System.out.println(coockieNo + ". cookie adi : " + each.getName());
            coockieNo++;
        }
        //3 Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi = cookieSet.size();
        Assert.assertTrue(cookieSayisi > 5);
        //4 ismi i18n prefs olan cookie degerinin USD oldugunu test edin

        for (Cookie each : cookieSet) {
            if (each.getName().equals("i18n prefs")) {
                Assert.assertEquals("USD", each.getValue());
            }
        }

        //5 ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        System.out.println();
        Cookie yeniCookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(yeniCookie);
        cookieSet=driver.manage().getCookies();
        coockieNo = 1;
        for (Cookie each : cookieSet) {
            System.out.println(coockieNo + ". cookie  : " + each);
            System.out.println(coockieNo + ". cookie adi : " + each.getName());
            coockieNo++;
        }
        //6 eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSet = driver.manage().getCookies();
        for (Cookie each : cookieSet) {
            if (each.getName().equals("en sevdigim")) {
                Assert.assertEquals("cikolatali", each.getValue());
            }
        }
        //7 ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookieSet.contains("skin"));


        //8 tum cookie’leri silin ve silindigini test edin

        driver.manage().deleteAllCookies();
        cookieSet = driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty());
    }
}
