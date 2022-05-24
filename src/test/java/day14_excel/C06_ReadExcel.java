package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {
        //excel dosyasindaki tum verileri class'imiza alip
        //bir java objesine store edelim
        // boylece her seferinde excel'e ulasip satir, sutun vs... ugrasmayalim

        // Database yapisinda olan excel'i
        // koyabilecegimiz en uygun java objesi map'dir

        Map<String,String> ulkelerMap= new HashMap<>();

        String dosyaYolu= "src/resources/ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        int sonSatirIndex=workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i < sonSatirIndex; i++) {
            // key i. satirdaki 0 indexindeki data olacak
            String key= workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            //value ise i. satirdaki 1,2, ve 3. indexteki datalarin birlesimi olacak
            String value= workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key, value);

        }
        System.out.println(ulkelerMap);

        // Listede Ghana oldugunu test edelim
        Assert.assertTrue(ulkelerMap.keySet().contains("Ghana"));

    }
}
