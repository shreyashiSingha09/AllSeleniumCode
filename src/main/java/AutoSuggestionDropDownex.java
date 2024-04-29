import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class AutoSuggestionDropDownex {
    public static void main(String... args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arunava Shreyashi\\Documents\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //Mention the drop down location and input ind to show auto suggestion
        driver.findElement(By.id("autosuggest")).sendKeys("IND");
        Thread.sleep(3000);
        //we need to store the all suggestion into a list type variable and use a generic css selctor relationship to  get suggestions
       List<WebElement> optinos= driver.findElements(By.cssSelector("li[class ='ui-menu-item'] a"));
       //Enhanced for loop to iterate the list
        {
            for ( WebElement option:optinos){
                if(option.getText().equalsIgnoreCase("INDIA")){
                    option.click();
                    break;
                }
            }
        }    }
}

