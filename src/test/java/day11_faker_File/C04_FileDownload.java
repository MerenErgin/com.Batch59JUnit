package day11_faker_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;


public class C04_FileDownload extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. dummy.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='dummy.txt']")).click();
        Thread.sleep(5000);
        //4. dosyanın başarıyla indirilip indirilmediğini test edelim
        //dosya downloads'a indirilecektir, bize downloads'un dosya yolu lazim

        String farkliKisim= System.getProperty("user.home");
        String ortakKisim= "\\OneDrive\\Desktop\\dummy.txt";

        String arananDosyaYolu= farkliKisim+ortakKisim;

        //geriye o dosyanin
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));

    }


}
