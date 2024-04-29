import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicDropDownEx {
    public static void main(String... args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Arunava Shreyashi\\Documents\\geckodriver.exe");

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //At first open the departure city drop down by its id's value
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        //Choose the departure city as Bengalore
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        //Choose the arrival  city as Chennai
        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        //Use parent-child relationship xpath to choose chennai into arrival city
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        //After departure city and arrival city is selected then only from date calendar will be opened.Here we select current date only.
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();


    }
}