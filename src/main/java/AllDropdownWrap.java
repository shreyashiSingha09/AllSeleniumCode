import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class AllDropdownWrap {
    public static void main(String... args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Arunava Shreyashi\\Documents\\geckodriver.exe");
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //It is always select one way
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        //At first open the departure city drop down by its id's value
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        //Choose the departure city as Bangalore
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);

        //Use parent-child relationship xpath to choose chennai into arrival city
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        //After departure city and arrival city is selected then only from date calendar will be opened.Here we select current date only.
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        //Check return date is enabled or not
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
            System.out.println("It is disabled");
          //  Assert.assertTrue(true);

        }
        else {
            System.out.println("It is enabled");
          //  Assert.assertTrue(false);
        }
        //Add the passenger
        //At first we need to identify the dropdown
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        //Click on the + button to add the passenger
        //We want to add 4 more passengers
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        int i=1;
        while (i<5) {

            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        //Click on the done button
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        //Select the checkbox using CSSLocators with regular expression
        driver.findElement(By.cssSelector("input[id*='chk_IndArm']")).click();
        //At first we need to identify the Select tag location and store it into webelement datatype variable
        WebElement staticdropdown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        //Invoke the object of Select class(Select class already present in Selenium) and its accept web element as argument
        Select dropdown= new Select(staticdropdown);
        //Select the dropdown value by its Index
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        //click on the search button
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
    }
}
