package day08_alert_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
    /*
    ● Bir class olusturun: Alerts
    ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    ● Bir metod olusturun: acceptAlert
        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        “You successfully clicked an alert” oldugunu test edin.
    ● Bir metod olusturun: dismissAlert
        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        “successfuly” icermedigini test edin.
    ● Bir metod olusturun: sendKeysAlert
        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    //    ● Bir metod olusturun: acceptAlert
    //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //        “You successfully clicked an alert” oldugunu test edin.
    @Test
    public void acceptAlert(){
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        String expectedstr="You successfully clicked an alert";
        String actualstr= driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(actualstr,expectedstr);
    }

    //    ● Bir metod olusturun: dismissAlert
    //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //        “successfuly” icermedigini test edin.
    @Test
    public  void dismissAlert(){
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        String expectedstr = "successfuly";
        WebElement sonucYazisi =driver.findElement(By.xpath("//p[@id='result']"));
        String actualstr = sonucYazisi.getText();
        Assert.assertFalse(expectedstr.contains(actualstr));
    }

    //    ● Bir metod olusturun: sendKeysAlert
    //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    @Test
    public void sendKeysAlert(){
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        String isim="Eren";
        driver.switchTo().alert().sendKeys(isim+ Keys.ENTER);
        String expectedstr=isim;
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualstr=sonucYazisiElementi.getText();
        Assert.assertTrue(actualstr.contains(expectedstr));
    }


}
