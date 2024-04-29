import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

import static java.lang.Thread.sleep;


public class LocatorsEx2 {
    public static void main(String... args) throws InterruptedException {
          //store the enter username in string variable and use this variable in everywhere
        String name= "Mampu";

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arunava Shreyashi\\Documents\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       //Run the same code in firefox
       // System.setProperty("WebDriver.gecko.driver","C:\\Users\\Arunava Shreyashi\\Documents\\geckodriver.exe");
        //WebDriver driver= new FirefoxDriver();
        //Here we call the new method for extract password and store it into a string
        String Pass= getPass(driver);
        //Open the URL in Browser
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("inputUsername")).sendKeys(name);
        //Here we use the pass string and input the password dynamically
        driver.findElement(By.name("inputPassword")).sendKeys(Pass);
        driver.findElement(By.className("signInBtn")).click();
        sleep(2000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
//Here We use assertion for Testng to compare the result.
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");

        //Here we user another assertion to check the username enter and user name display is same or not
       Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello " +name+",");
       //Here we use xpath based on the button text to log out from the application(1st syntax)
       driver.findElement(By.xpath("//button [text()='Log Out']")).click();
      // driver.findElement(By.xpath("//*[text()='Log Out']")).click();(2nd syntax using * instead of tagname)
       //close the browser
        driver.close();



    }
    public static String getPass( WebDriver driver) throws InterruptedException {
        //Get the URL
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        //Click on the frogot your password link
        driver.findElement(By.linkText("Forgot your password?")).click();
        sleep(1000);
        //Click on the reset your password link
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        //get the password text and store it into a string
        String PasswordText= driver.findElement(By.cssSelector("form p")).getText();
        //Now we split the string based on the "'" and store it into a string array.
        //Please use temporary password 'rahulshettyacademy' to Login.
      String[] passTextArray=  PasswordText.split("'");
      //It splits the text into two parts Please use temporary password [0] it is 0th index text and
        //rahulshettyacademy' to Login.[1] it is 1st index
        //again we split the [1]st index string as it holds the password
        String Password= passTextArray[1].split("'")[0];
        return Password;
    }
}
