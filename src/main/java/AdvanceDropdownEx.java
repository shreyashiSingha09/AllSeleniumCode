import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvanceDropdownEx {
    public static void main(String... args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arunava Shreyashi\\Documents\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
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

    }

}
