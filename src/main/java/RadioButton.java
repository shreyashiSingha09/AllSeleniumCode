import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class RadioButton {
    public static void main(String... args) {

        WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Arunava Shreyashi\\Documents\\geckodriver.exe");

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //Check the opacity value before choose the round trip
       System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        //Choose the round trip option using radio button
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        //Use the getAttribute() to check the return Date is enabled or not when we choose round trip
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
            System.out.println("It is enabled");
            Assert.assertTrue(true);

        }
        else {
            System.out.println("It is not enabled");
            Assert.assertTrue(false);
        }
    }
}
