package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BiforeClass_AfterClass {
    /*
    @BeforeClass ve @AfterClass notasyonlari sadece static methodlar icin calisir
    */
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        // Before method call var gibi
        driver.get("https://www.amazon.com");
        // After method call var gibi
    }

    @Test
    public void test02(){
        driver.get("https://www.techproeducation.com");
    }

    @Test
    public void test03(){
        driver.get("https://www.facebook.com");
    }

}
