package day10_TestBaseFirstClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //facebook anasayfaya gidip
        driver.get("https://www.facebook.com");
        // yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        // isim kutusunu locate edip,
        WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));
        //geriye kalanlari TAB ile dolasarak
        // formu doldurun

        Actions actions= new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys("Talha")
                .sendKeys(Keys.TAB)
                .sendKeys("Ustaoglu")
                .sendKeys(Keys.TAB)
                .sendKeys("email@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("1234")
                .sendKeys(Keys.TAB)
                .sendKeys("1234")
                .perform();
        Thread.sleep(2000);
    }
}
