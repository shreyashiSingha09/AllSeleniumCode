package Assignment3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {
    public static void main(String... args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qaclickacademy.com/practice.php");
        //Select the checkbox
        driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
    //grab the level of the selected checkbox
        String option= driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
        //Select the option in drop down. Selected option should come from step 2
        WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
        Select st=new Select(dropdown);
        st.selectByVisibleText(option);
        //enter the step2 grabbed label text in alert edit box
        driver.findElement(By.cssSelector("input[placeholder='Enter Your Name']")).sendKeys(option);
        //Click on alert
        driver.findElement(By.id("alertbtn")).click();
        //grabbed the text coming in the alert pop -up
     String text=driver.switchTo().alert().getText();
     //verify the step 2 grabbed lebel text should present in the alert pop up message
        if(text.contains(option)){
            System.out.println("Alert Text is matching");
        }
        else {
            System.out.println("Test failed! Alert text is not matched");
        }
    }
}
