import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String... args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        //use the actions class and pass the driver so that actions class object an access the driver
        Actions a=new Actions(driver);
        WebElement move=driver.findElement(By.cssSelector(".-dOa_b.L_FVxe"));
        //Moves to the specific element and perform the action
        a.moveToElement(move).build().perform();
        //we move the mouse on the search box,type the hello in capital letter and to type in caps we need to press the shift button and type the keyword and upon double click on it select the keyword
        a.moveToElement(driver.findElement(By.cssSelector("input[placeholder='Search for Products, Brands and More']"))).click().
                keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        //we can right click on a element so that the pop up is open and we achive the right click with help of ContextClick()
        a.contextClick(move).build().perform();
    }
}
