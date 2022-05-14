package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//1. Bir class oluşturun : RadioButtonTest
public class C03_RadioButton {
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
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
    public void test() throws InterruptedException {
        //-https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //-Cookies’i kabul edin
        //-“Create an Account” button’una basin
        driver.findElement(By.xpath("//*[text()='Create New Account']")).click();

        //-“radio buttons” elementlerini locate edin
        WebElement fealeButton= driver.findElement(By.xpath("//input[@value='1']"));
        WebElement maleButton= driver.findElement(By.xpath("//input[@value='2']"));
        WebElement customButton= driver.findElement(By.xpath("//input[@value='-1']"));

        //-Secili degilse cinsiyet butonundan size uygun olani secin

        if (!maleButton.isSelected()){
            maleButton.click();
        }
        Thread.sleep(2000);

    }




}
