import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class FilterSearch {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();
        //Goal is to type some letters in search box when the matching string is found it returs it in result table

        //Search rice in the search box
        driver.findElement(By.id("search-field")).sendKeys("Rice");
        //Need the 1st column as it holds the item name
      List<WebElement> vegName= driver.findElements(By.xpath("//tr/td[1]"));

      //Suppose 5 results will return ,then we need to confirm that in that results are containig the correct string
      List<WebElement> filterList=vegName.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());

      //Compare this two list
        Assert.assertEquals(vegName.size(),filterList.size());

    }
}
