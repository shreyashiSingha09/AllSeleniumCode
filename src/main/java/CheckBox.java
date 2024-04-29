import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class CheckBox {
    public static void main(String... args)  {
       // System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arunava Shreyashi\\Documents\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Arunava Shreyashi\\Documents\\geckodriver.exe");

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //We Used Assertion to check the result is pass or not
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='chk_IndArm']")).isSelected());
        //Assert.assertFalse(False) it is expecting false if true is return then test case is failed.
        //Select the checkbox using CSSLocators with regular expressiomn
        driver.findElement(By.cssSelector("input[id*='chk_IndArm']")).click();

        //Check the checkbox value is selected or not
      System.out.println(driver.findElement(By.cssSelector("input[id*='chk_IndArm']")).isSelected());
      //Count the total number of checkboxes for this first check the common locators of all the checkboxes and use CSS Selector
       System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

    }
}

