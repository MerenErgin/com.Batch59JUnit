package day09_handleWindows_tstBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindows {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test01(){
        //1- Amazon anasayfasina gidin ve handle degeri'ni alin
        driver.get("https://www.amazon.com/");
        String ilkSayfaHanleDegeri= driver.getWindowHandle();

        //2- nutella icin arama yaptirirn
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

        /*
        CDwindow-03E77C800EF3863B22DB5D89051E1EBC
        BU kod acilan sayfanin unique hash kodudur.
        Selenium sayfalar arasi geciste bu window handle degerini kullanir

        Eger sayfalar arasinda driver'imizi gezdiriyorsak ve herhangi bir sayfadan
        suanda bulundugumuz sayfaya gecmek istiyorsak
        driver.switchTo().window("CDwindow-03E77C800EF3863B22DB5D89051E1EBC");
        bu sayfanin window handle degerini girerek bu sayfaya gecis saglanabilir
         */

        //3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        Bu kodu kullandigimizda driver otomatik olarak olusturulan
        new Tab'a gecer
        yeni tab'da gorevi gerceklestirmek icin
        adimlari bastan almamiz gerekir
         */
        System.out.println("driverin URL'i"+driver.getCurrentUrl());

        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

        WebElement ilkUrunResmi= driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect'][1]"));
        ilkUrunResmi.click();

        //4- yeni bir tag da olan urunun fiyatini yazdiririn
        WebElement urunTitle= driver.findElement(By.xpath("//span[@id=\"productTitle\"]"));
        System.out.println(urunTitle.getText());
        System.out.println(driver.getCurrentUrl());

        //5- ilk sayfaya gecip Url'i yazdiralim
        driver.switchTo().window(ilkSayfaHanleDegeri);
        System.out.println(driver.getCurrentUrl());

    }

}
