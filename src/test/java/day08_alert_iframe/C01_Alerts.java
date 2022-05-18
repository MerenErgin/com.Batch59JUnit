package day08_alert_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test01(){
        /*  herhangi bir web sitesine girince veya
            bir websitede herhangi bir islem yaptigimizda ortaya cikan uyarilara alert diyoruz

            Eger bir alert inspect yapilabiliyorsa, o alert otomasyon ile kullanilabilir.
            bu tur alert'lere HTML alert denir ve bunlar icin ekstra bir islem yapmaya gerek yoktur
            tum webelementler gibi locate edip istedigimiz islemleri yapabiliriz

            Ancak web uygulamalarinda HTML alert yaninda java script alert de bulunabilir
            Js alertler locate edilemezler

            Selenium'da JS alertler icin ozel bir yontem gelistirilmistir

         */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        //alet'te OK tusuna basin ve
        driver.switchTo().alert().accept();
        //result kisminda "You successfully clicked an alert" yazdigini test edin

        String expectedResult= "You successfully clicked an alert";
        WebElement sonucYazisiElementi= driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultYazisi=sonucYazisiElementi.getText();
        Assert.assertEquals(expectedResult,actualResultYazisi);

    }

}
