package day11_faker_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.
        /*
        bu islemi selenium la yapma sansimiz yok cunku web tabanli bir uygulama degil
        bu durumda sendKeys() imdadimiza yetisir
        eger choosFile butonuna var olan bir dosyanin dosya yolunu yollarsaniz
        secme islemi otomatik olarak yapilmis olacaktir
         */
        //1.adim cjhoose file butonunu locate edelim
        WebElement dosyaSecButonu= driver.findElement(By.id("file-upload"));
        //2.adim yuklenecek dosyanin dosya yolunu olusturalim
        // biz masaustundeki text.txt dosyasini yukleyelim
        String farkliKisim= System.getProperty("user.home");
        String ortakKisim= "\\OneDrive\\Desktop\\text.txt";
        String yuklenecekDosya= farkliKisim+ortakKisim;
        //3.adim sendKeys ile dosya yolunu, secme butonuna yollayalim
        dosyaSecButonu.sendKeys(yuklenecekDosya);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement yaziElementi= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(yaziElementi.isDisplayed());

        Thread.sleep(2000);
    }
}
