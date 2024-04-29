import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SslCertificateEx {
    public static void main(String... args) {
        //Create object of ChromeOptions Class
        FirefoxOptions options=new FirefoxOptions();
        //with help of "setAcceptInsecureCerts" method set the behaviour of the brower
        options.setAcceptInsecureCerts(true);
        WebDriverManager.firefoxdriver().setup();
        //pass this chrome behaviour into driver
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
    }
}
