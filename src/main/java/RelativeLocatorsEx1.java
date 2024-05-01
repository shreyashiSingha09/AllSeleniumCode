import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorsEx1 {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        //Need to know the level of the text which is above the Name textbox
        //1st find the name textbox position with locatars
       WebElement labelTag= driver.findElement(By.cssSelector("[name='name']"));

       //Use the relative locator above() to know the level of the text field called Name

       System.out.println(driver.findElement(with(By.tagName("label")).above(labelTag)).getText());

       //Print the input field text value below of DOB fields
        WebElement labeltag2=driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(labeltag2)).click();

        //Check the checkbox based upon the level of the check box and this box present left of the text
        WebElement labeltag3=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(labeltag3)).click();

        //How to get the text of the field which is right of the radio button
        WebElement labelTag4=driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(labelTag4)).getText());
    }
}
