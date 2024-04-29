import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsEx3 {
    public static void main(String... args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arunava Shreyashi\\Documents\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //Using relative xpath locators and parent-child and sibling-sibling traverse
     System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
     //Go to the same login button using parent-child and child-parent-again child traverse
      System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());

    }
}