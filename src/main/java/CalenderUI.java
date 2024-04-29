import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CalenderUI {
    public static void main(String... args)  {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        //store the year,month,date which you need to choose
        String year= "2025";
        String day= "23";
        String month ="6";
        String[] list={month,day,year};
        //click on the date field so that calender is open
        driver.findElement(By.cssSelector(".react-date-picker__calendar-button")).click();
        //On the first it goes to year field
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        //On the same click 2nd time year list is displayed
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        //Now select the year 2025 but pass the variable do not date the value from webelement text
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        //select the month
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
        //Select the day
        driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
        //get the date which is visible in the date box
      List<WebElement> actualDate= driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
      for(int i=0;i<actualDate.size();i++) {
          System.out.println(actualDate.get(i).getAttribute("value"));

          Assert.assertEquals(actualDate.get(i).getAttribute("value"),list[i] );
      }



    }
}
