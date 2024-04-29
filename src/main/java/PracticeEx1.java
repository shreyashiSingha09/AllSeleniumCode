import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class PracticeEx1 {
    public static void main(String... args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qaclickacademy.com/practice.php");
        //how to know the number of links present in this page
        System.out.println(driver.findElements(By.tagName("a")).size());
        //How many links are present in the footer section of the page
        //first select the footer section
        WebElement footersection = driver.findElement(By.id("gf-BIG"));
        //get the cunts
        System.out.println(footersection.findElements(By.tagName("a")).size());
        //How many links are present in the footer area's first column only
        //first select the first column
        WebElement columSec = footersection.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        //get the counts of the links
        System.out.println(columSec.findElements(By.tagName("a")).size());

        //Click on the each links of the column and check if they are opening
        //we do it dynamically so that in future number of links are changed the code is working
        for (int i = 1; i < columSec.findElements(By.tagName("a")).size(); i++) {

            //open the each links in the separate tabs otherwise we get the error
            String subTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columSec.findElements(By.tagName("a")).get(i).sendKeys(subTab);
            Thread.sleep(5000L);

        }
        //To print the title of the each link we need to go to each window
        //for that switch the browser to window
            Set<String> abc = driver.getWindowHandles();//4
            Iterator<String> it = abc.iterator();

            while (it.hasNext()) {

                driver.switchTo().window(it.next());
                System.out.println(driver.getTitle());

            }


        }
    }

