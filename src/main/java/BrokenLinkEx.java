import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinkEx {
    public static void main(String... args) throws IOException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //goal is to iterate all the available links and check which link is broken
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

        //Soft Assertion
        SoftAssert a = new SoftAssert();

        for (WebElement link : links) {
            //check which link is broken and get the text and code of this link
            String url2 = link.getAttribute("href");

            HttpURLConnection conn = (HttpURLConnection) new URL(url2).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();

            int rescode2 = conn.getResponseCode();
            System.out.println(rescode2);
            a.assertTrue(rescode2 < 400, "The error page link is: " + link.getText() + "The response code is: " + rescode2);
        }

        a.assertAll();
    }
}

