import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotEx {
    public static void main(String... args) throws IOException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        //convert the driver object so that it can take screenshot
     File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     //From the src object copy the ss and place it into local machine
        FileUtils.copyFile(src,new File("C:\\Users\\Arunava Shreyashi\\screenshot.png"));
    }
}
