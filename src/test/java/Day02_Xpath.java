import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day02_Xpath {
   static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test1()  {


        driver.get("http://a.testaddressbook.com/");
        WebElement signInLinki=driver.findElement(By.linkText("Sign in"));
        signInLinki.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        List<WebElement> tumLinkler=driver.findElements(By.tagName("a"));
                                                      //By.xpath("//a");  seklinde de olabilir

        for(WebElement w:tumLinkler){
            System.out.println(w.getText());
        }


      //  <a id="sign-in" class="nav-item nav-link" data-test="sign-in" href="/sign_in">Sign in</a>
    }

    @Test
    public  void test2(){

      WebElement kullaniciAdi=  driver.findElement(By.cssSelector("#session_email"));
      kullaniciAdi.sendKeys("testtechproed@gmail.com");

        WebElement sifre=driver.findElement(By.cssSelector("#session_password"));
sifre.sendKeys("Test1234!");

        WebElement giris=driver.findElement(By.cssSelector(".btn.btn-primary"));
        giris.click();

//        List<WebElement> tumElementler=driver.findElements(By.xpath("//*"));
//        for (WebElement w:tumElementler){
//            System.out.println(w.getText());

        WebElement tumYazilar=driver.findElement(By.tagName("body"));
        System.out.println(tumYazilar.getText());
        }




    @AfterClass
    public static void tearDown(){
        driver.quit();
    }



}
