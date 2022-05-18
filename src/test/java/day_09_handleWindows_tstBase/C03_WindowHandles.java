package day_09_handleWindows_tstBase;

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
import java.util.Set;

public class C03_WindowHandles {

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
        //● Tests package’inda yeni bir class olusturun: WindowHandle2
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfadakiYaziElementi= driver.findElement(By.xpath("//h3"));
        String expectedYazi= "Opening a new window";
        String actualYazi= sayfadakiYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle= "The Internet";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        /*
        eger kontrolsuz acilan bir tab veya window varsa
        o zaman sayfalarin window handle degerlerini elde etmem gerekir
        oncelikle 2. sayfa acilmadan once
        ilk sayfanin window handle degerini bir String'e atayalim
         */
        String ilkSayfaWindowHandleDegeri=driver.getWindowHandle();

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        /*
            switchTo().newWindow() demeden link tiklayarak yeni tab veya window olustugunda
            biz driver'a yeni sayfaya gec demedikce, driver eski sayfada kalir
            ve yeni sayfada drier'i clistirmak istersek
            once driver'i yeni sayfaya yollamaliyiz
         */
        /*
            yeni sayfaya gecebilmek icin oncelikle ilkSayfaWindowHandleDegeri'ni bulmamiz gerekir
            bunun icin driver.getWindowHandles() method'u kullanarak
            acik olan tum sayfalarin window handle degerlerini alip bir set'e assign ederiz

            ilk sayfa
         */
        Set<String > windowHandleseti= driver.getWindowHandles();
        System.out.println(windowHandleseti);

        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleseti
             ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }

        //artik ikinci sayfanin window handle degerini biliyoruz
        //rahatlikla sayfalar arasi gecis yapabiliriz
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String expectedIkinciTitle="New Window";
        String actualIkinciTitle= driver.getTitle();
        Assert.assertEquals(expectedIkinciTitle,actualIkinciTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikinciSayfaYaziElementi= driver.findElement(By.xpath("//h3"));
        String expectedIkinciYazi="New Window";
        String actualIkinciYazi=ikinciSayfaYaziElementi.getText();
        Assert.assertEquals(expectedIkinciYazi,actualIkinciYazi);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        String oncekiSayfaTitle= driver.getTitle();
        String expectedoncekiSayfaTitle= "The Internet";
        Assert.assertEquals(expectedoncekiSayfaTitle,oncekiSayfaTitle);

    }


}
