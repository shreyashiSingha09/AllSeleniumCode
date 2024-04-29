import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDownEx1 {
    public static void main(String... args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arunava Shreyashi\\Documents\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //At first we need to identify the Select tag location and store it into webelement datatype variable
        WebElement staticdropdown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        //Invoke the object of Select class(Select class already present in Selenium) and its accept web element as argument
        Select dropdown= new Select(staticdropdown);
        //Select the dropdown value by its Index
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        //Select the dropdown value on its visiable text
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        //Select the dropdown value on its value's attribute
        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());
    }
}
