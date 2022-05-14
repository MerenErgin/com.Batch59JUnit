package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test(){
        /* Eger test methodumuzda hicbir test yoksa, test calistiktan sonra
           hic bir problemle karsilasilmadigini raporlamak icin "tests passed" yazisi cikar

           Eger testleri if ile yaparsak
           test failed olsa bile kodlar problemsiz calistigi icin
           kod calismasi bittiginde
           ekranin sol alt kisminda test passed yazacaktir
         */
        driver.get("https://amazon.com");

        // url'in https://www.facebook.com oldugunu test edin
/*
        if (driver.getCurrentUrl().equals("https://www.facebook.com")){
            System.out.println("Url testi PASSED");
        }else {
            System.out.println("Url testi FAILED");
        }
*/

        String expectedUrl = "https://www.facebook.com";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("HATAA VAAR!",expectedUrl,actualUrl);
        /*
        Assert ile yaptigimiz testlerde assertion failed olursa
        Java kodlarin calismasini durdurur ve Assert clas'i
        bizi hata konusunda bilgilendirir

            org.junit.ComparisonFailure: HATAA VAAR!
            Expected :https://www.facebook.com
            Actual   :https://www.amazon.com/
            <Click to see difference>

        boylece hatanin ne oldugunu arastirmamiza gerek kalmadan
        JUnit bize raporlamis olacak
         */

    }
}
