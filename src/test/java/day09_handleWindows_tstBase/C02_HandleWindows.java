package day09_handleWindows_tstBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindows {

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
        // 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com/");
        String ilkSayfaWindowHandleDegeri= driver.getWindowHandle();

        // 2- url'in  amazon icerdigini test edelim
        String amazonUrl= driver.getCurrentUrl();
        String urlIstenenKelime="amazon";
        Assert.assertTrue(amazonUrl.contains(urlIstenenKelime));

        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaWindowHandleDegeri= driver.getWindowHandle();

        // 4- title'in Best Buy icerdigini test edelim
        String besBuyTitle= driver.getTitle();
        String titleIstenenKelime= "Best Buy";
        Assert.assertTrue(besBuyTitle.contains(titleIstenenKelime));

        // 5- ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java"+ Keys.ENTER);

        // 6- arama sonuclarinin Java icerdigini test edelim
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisiStr= sonucYaziElementi.getText();
        String aradigimizKelime="java";
        Assert.assertTrue(sonucYazisiStr.contains(aradigimizKelime));

        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        // 8- logonun gorundugunu test edelim
        WebElement logoElementi= driver.findElement(By.xpath("//span[@class='nav-sprite nav-logo-base']"));
        Assert.assertTrue(logoElementi.isDisplayed());

    }
}
