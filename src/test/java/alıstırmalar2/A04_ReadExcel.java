package alıstırmalar2;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class A04_ReadExcel {
    //Yeni bir test method olusturalim readExcel2( )
    //-1.satirdaki 2.hucreye gidelim ve yazdiralim
    //-1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
    //-2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
    //-Satir sayisini bulalim
    //-Fiziki olarak kullanilan satir sayisini bulun
    //-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim


    @Test
    public void readExcel2() throws IOException {

        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        //-1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));

        //-1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String str1=workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println("str1 = " + str1);

        //-2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String expectedYazi="Kabil";
        String actualYazi=workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        Assert.assertEquals(expectedYazi,actualYazi);

        //-Satir sayisini bulalim
        int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("sonSatir = " + sonSatir+1);

        //-Fiziki olarak kullanilan satir sayisini bulun
        int  doluSatirSayisi=workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("doluSatirSayisi = " + doluSatirSayisi);

        //-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        Map<String,String> ingilzceUlkeIsımleriVeBaskentleri= new HashMap<>();
        String key="";
        String value="";
        for (int i = 0; i <=workbook.getSheet("Sayfa1").getLastRowNum(); i++) {
             key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            ingilzceUlkeIsımleriVeBaskentleri.put(key,value);

       }

        Set<String> keySetListesi=ingilzceUlkeIsımleriVeBaskentleri.keySet();
        for (String each:keySetListesi
             ) {
            System.out.println(each+": "+ingilzceUlkeIsımleriVeBaskentleri.get(each));
        }

    }
}
