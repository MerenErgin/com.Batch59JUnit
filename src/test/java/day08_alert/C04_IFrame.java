package day08_alert;

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

public class C04_IFrame {
    // ● Bir class olusturun: IframeTest
    // ● https://the-internet.herokuapp.com/iframe adresine gidin.
    // ● Bir metod olusturun: iframeTest
    //    ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
    //    ○ Text Box’a “Merhaba Dunya!” yazin.
    //    ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

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
        driver.close();
    }

    // ● Bir metod olusturun: iframeTest
    @Test
    public void IframeTest() throws InterruptedException {
        // ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //    ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement baslikElemnti = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElemnti.isEnabled());
        System.out.println(baslikElemnti.getText());
        //    ○ Text Box’a “Merhaba Dunya!” yazin.
        //textBox'i dogru olarak locate etmemize ragme driver bulamadi
        //bunun uzerine HTML kodlari inceleyince
        //textbox'in bir iFrame icersinde oldugunu gorduk
        //bu durumda once iFrame'i locate edip
        //switchTo() ile o iFrame'e gecmeliyiz
        WebElement iFrameElementi= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElementi);

        WebElement textKutusu= driver.findElement(By.xpath("//body[@id='tinymce']"));
        textKutusu.clear();
        textKutusu.sendKeys("Merhaba Dunya!");

        //    ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        // link yazi elementini dogru locate etmemize ragmen yazdirmadi
        // cunku yukarida iFrame'e gecis yapmistik
        // once oradan cikmamiz lazim
        driver.switchTo().defaultContent();

        WebElement linkYaziElementi= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkYaziElementi.isDisplayed());
        System.out.println(linkYaziElementi.getText());

        Thread.sleep(3000);

    }



}
