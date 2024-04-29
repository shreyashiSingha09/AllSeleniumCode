import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class WebtableSort {

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();

        //Click on the column
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //Capture all the web elements into list
        List<WebElement> list1 = driver.findElements(By.xpath("//tr/td[1]"));

        //Capture text of all web elements into new list
        List<String> list2 = list1.stream().map(WebElement::getText).collect(Collectors.toList());

        //Sort on the original list of step3
        List<String> sortedList = list2.stream().sorted().collect(Collectors.toList());

        //Compare original list vs sortedList
        Assert.assertTrue(sortedList.equals(list2));
        List<String> price;
        do {
            //Scan the column and get the Text,when beans is found get me the price
            //Capture all the web elements into list
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice")).
                    map(s -> vegPrice(s)).collect(Collectors.toList());
            price.forEach(System.out::println);

            //If the item is not present in first page, need to perform pagination using do-while loop
            if (price.isEmpty()) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }while (price.isEmpty());
    }

    private static String vegPrice(WebElement s) {
      String priceValue= s.findElement(By.xpath("following-sibling::td[1]")).getText();
      return priceValue;
    }
}
