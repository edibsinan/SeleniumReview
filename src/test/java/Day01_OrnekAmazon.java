import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.management.snmp.jvmmib.JVM_MANAGEMENT_MIBOidTable;

import java.util.concurrent.TimeUnit;

public class Day01_OrnekAmazon {



    @Test
    public void test1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.amazon.com/");
        WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Baby Stroller"+ Keys.ENTER);
        driver.findElement(By.xpath("//span[contains(text(),'Summer Myria Modular Travel System with The Affirm')]")).click();

        WebElement fiyat=driver.findElement(By.xpath("//span[@id='priceblock_ourprice']"));
        System.out.println(fiyat.getText());


           }


    @Test
    public void test2(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("http://google.com");
        WebElement search=driver.findElement(By.name("q"));
        search.sendKeys("Kemal ozden");
        search.submit();
        WebElement sonuc=driver.findElement(By.id("result-stats"));
        System.out.println(sonuc.getText());






           }
}
