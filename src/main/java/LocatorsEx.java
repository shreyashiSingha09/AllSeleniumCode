import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class LocatorsEx {
    public static void main(String... args) throws InterruptedException {

        //WebDriver driver = new FirefoxDriver();
        //System.setProperty("webdriver.gecko.driver","\\Users\\Arunava Shreyashi\\Documents\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arunava Shreyashi\\Documents\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       //Open the URL in Browser
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        //asking the driver object to find the web element by Id locators  and place Associated attribute value of ID here and selenium place the cursor on this input field
        //After finding the element selenium perform some actions by Sendkeys
        //User Implicitwait mechanism for wait some time ,if within the given time it does not work then throw error
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("inputUsername")).sendKeys("Shreyashi");
        driver.findElement(By.name("inputPassword")).sendKeys("Hello123");
        driver.findElement(By.className("signInBtn")).click();
       //2nd way Css locator
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        //Using Xpath we are enter username in Reset password page
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Mampu");
        //Customized CSS Selector is used to type email(3rd way css locator)
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Mampu@www.com");
        //clear the wrong email using Xpath indexing
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        //Provide correct email using Css Selector Indexing
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("Mampu@gmail.com");
        //Parent to child traverse using Xpath and enter the phone number
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("8759896645");
        //Using Css selector we are click on reset login button(we are using 2nd way to generate css selector)
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
       System.out.println(driver.findElement(By.cssSelector("form p")).getText());
       //From forget your password button come back to login page using customized traverse xpath locator and indexing
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

        sleep(1000);
       //Enter correct username using CSS Selector 1st way(Tagname#ID)
       driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("Shreyashi");
       //Enter correct password general password using CSS regular expression
      driver.findElement(By.cssSelector("input[type*= 'pass']")).sendKeys("rahulshettyacademy");
      //Click on the checkox using Id Locators
        driver.findElement(By.id("chkboxOne")).click();
        //Click on the Sign In button using Xpath Regular expression
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

    }
}

