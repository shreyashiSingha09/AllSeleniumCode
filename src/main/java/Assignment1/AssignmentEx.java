package Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AssignmentEx {
    public static void main(String... args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Arunava Shreyashi\\Documents\\geckodriver.exe");
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        String name="Shreyashi";
        String email="shreya.singha@gmail.com";
        //Enter the name in the textbox
        driver.findElement(By.name("name")).sendKeys(name);
        //Enter the email in the textbox
        driver.findElement(By.name("email")).sendKeys(email);
        //Enter the password in the textbox
        driver.findElement(By.cssSelector("[id='exampleInputPassword1']")).sendKeys("mampu21");
        TimeUnit.SECONDS.sleep(3);
        //Click on the checkbox
        driver.findElement(By.id("exampleCheck1")).click();
        //choose the gender from static drop dpwn
        WebElement dropdown= driver.findElement(By.id("exampleFormControlSelect1"));
        Select gender=new Select(dropdown);
        gender.selectByVisibleText("Female");
        TimeUnit.SECONDS.sleep(3);
        //Choose the employement status using radio button
        driver.findElement(By.id("inlineRadio2")).click();
        //choose the date of birth from calender
       driver.findElement(By.name("bday")).sendKeys("10/09/1997");

        //Click on the submit button
        driver.findElement(By.cssSelector(".btn-success")).click();
        //grap the successful message and print it
      System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
    }
}
