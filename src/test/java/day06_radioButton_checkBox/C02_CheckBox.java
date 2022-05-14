package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//1. Bir class oluşturun : CheckBoxTest
public class C02_CheckBox {
    //2.Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    WebDriver driver ;
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

    @Test
    public void test() throws InterruptedException {
        //a. Verilen web sayfasına gidin.
        //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement Checkbox1Elementi= driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement Checkbox2Elementi= driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!Checkbox1Elementi.isSelected()){
            Checkbox1Elementi.click();
        }
        Thread.sleep(2000);
        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!Checkbox2Elementi.isSelected()){
            Checkbox2Elementi.click();
        }
        Thread.sleep(2000);
    }





}
