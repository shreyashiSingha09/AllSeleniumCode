import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Assignment3 {
    public static void main(String... args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> windowids=windows.iterator();
        String parentid= windowids.next();
        String childid=windowids.next();
       driver.switchTo().window(childid);
       System.out.println(driver.findElement(By.tagName("h3")).getText());
       driver.switchTo().window(parentid);
       System.out.println(driver.findElement(By.tagName("h3")).getText());
    }
}
