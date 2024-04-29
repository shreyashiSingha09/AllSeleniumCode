import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Alert_Handling {

    public static void main(String... args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Arunava Shreyashi\\Documents\\geckodriver.exe");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String text="Shreyashi";
        //Enter the name using ID locator in the text box
        driver.findElement(By.id("name")).sendKeys(text);
        //click on the alert button to see the alert, used customized CSSSelector
        driver.findElement(By.cssSelector("[id='alertbtn']")).click();
        TimeUnit.SECONDS.sleep(5);
        //Grap the text which is coming in the alert box
        System.out.println(driver.switchTo().alert().getText());
        //Handle the alert
        driver.switchTo().alert().accept();
        TimeUnit.SECONDS.sleep(3);
        //Click on the confirm button to see the confirmbox alert
        driver.findElement(By.id("confirmbtn")).click();
        TimeUnit.SECONDS.sleep(5);
        //Grap the text which is coming in the alert box
        System.out.println(driver.switchTo().alert().getText());
        //Click on the cancel button to dismiss the alert
        driver.switchTo().alert().dismiss();
    }
}
