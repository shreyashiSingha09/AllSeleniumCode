import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandel {
    public static void main(String... args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        //Click on the link on the first window which is redirect to the second window
        driver.findElement(By.cssSelector(".blinkingText")).click();
        //We grab the parent and child window ids with help of getWindowHandles()
      Set<String> windows= driver.getWindowHandles();
      //separate the both ids with help of iterator()
        Iterator<String> ids= windows.iterator();
        //store it in a variable and with help of next() points to the first window and then child window
        String parentId= ids.next();
        String childId= ids.next();
        //switch from parent to child
        driver.switchTo().window(childId);
        //grab the email and spilt and trim it
        String emailid=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        //switch the window from child to parent
        driver.switchTo().window(parentId);
        //print the email id in the username field
        driver.findElement(By.id("username")).sendKeys(emailid);
    }
}
