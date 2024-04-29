import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActivity {


    public static void main(String... args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arunava Shreyashi\\Documents\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //View the page in maximize mode
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        //Navigate from goggle to another url
        driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
        //Come back to the google page
        driver.navigate().back();
        //Forward the page into rahulshetty page
        driver.navigate().forward();
    }
}
