package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.client5.http.protocol.RedirectLocations;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Q02 {
        /*
    ...Exercise2...
    http://www.bestbuy.com 'a gidin,
    Sayfa basliginin "Best" icerdigini(contains) dogrulayin
    Ayrica Relative Locator kullanarak;
        logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
        mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
    */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.bestbuy.com");
    }

    @Test
    public void titleTest(){
        Assert.assertTrue("title best kelimesi icermiyor", driver.getTitle().contains("Best"));
    }

    @Test
    public void logoTest(){
        //WebElement logoBestBuy= driver.findElement(By.xpath("//img[@class='logo']"));
        WebElement helloHeading= driver.findElement(By.xpath("//div[@class='heading']"));//Relative Locator
        WebElement logoBestBuy= driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHeading));
        Assert.assertTrue(logoBestBuy.isDisplayed());
    }

    @Test
    public void mexicoLinkTest(){
        WebElement usLink= driver.findElement(By.xpath("//img[@alt='United States'] [1]"));
        WebElement mexicoLink= driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(usLink));
        Assert.assertTrue(mexicoLink.isDisplayed());
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
