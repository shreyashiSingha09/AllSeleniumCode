package shoppingEx;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ShoppingEx {
    public static void main(String... args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //use implicit wait mechanicham
      //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //explicit wait using webDriverWait object
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        //Store all the available vegetables names into an array
        String[] itemsavl = {"Brocolli", "Cucumber", "Beetroot"};
        Thread.sleep(3000);
        addItems(driver, itemsavl);
        //after adding the products open the cart icon
        driver.findElement(By.cssSelector(".cart-icon")).click();
        //click the checkout button to proceed
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        //use explicit wait
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("[placeholder='Enter promo code']"))));
        //Enter the promocode in text box
        driver.findElement(By.cssSelector("[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
        //apply the promocode and click apply button
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        //apply the explicit wait for visibility of the text
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
        //check the code is applied or not and get the text
       System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());

    }

    public static void addItems(WebDriver driver, String[] itemsavl) {
        int j = 0;

        //At first collect all the available products and store them into webelement type variable in list structure.
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        //itirate the products list go
        for (int i = 0; i <= products.size(); i++) {
            //get the products names and store it into a string
            //Split the product name based on "-" so that we get proper name
            //name[0]=brocolli, name[1]=1 Kg(it is not needed)
            String[] name = products.get(i).getText().split("-");
            //trim the white spaces and store the name varibale into another variable
            String formatedName = name[0].trim();
            //We convert the array into arraylist and check whether the name you extracted is present in the array or not
            List itemsNeeded = Arrays.asList(itemsavl);
            if (itemsNeeded.contains(formatedName)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                //we want to add 3products so make sure loop is itirated 3 times only,otherwise it is excuted 30 times which is not needed.
                //For this we used another if block and check whenever j==size of the procuts present in the array loop is must be break
                if (j == itemsavl.length) {
                    break;
                }

            }


        }
    }

}
