package Learn;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class RobotClass {
    ChromeDriver driver;
    @Test(priority = 1)
    void examples() throws AWTException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Downloads/Downloads/IntelliJ/gecko/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://polaris.shopify.com/components/forms/autocomplete");
        //river.manage().window().maximize();  //mo rong chrome
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15)); //doi page load trong 5s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//doi cac step load trong 3s
        Thread.sleep(3000);

        //action
        WebElement examples = driver.findElement(By.xpath("//select[@aria-labelledby='ExamplesLabel']"));
        Actions action = new Actions(driver);
        action.click(examples).sendKeys(Keys.ENTER).build().perform();

        Select select  = new Select(driver.findElement(By.xpath("//select[@aria-labelledby='ExamplesLabel']")));
        select.selectByVisibleText("Basic autocomplete");
        Thread.sleep(3000);
    }
    @Test(priority = 2)
    void tag() throws AWTException, InterruptedException {
        driver.findElement(By.xpath("//label[@for='component-view-tab-properties']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='component-view-tab-result']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='Polaris-TextField__Prefix']/following-sibling::input")).sendKeys("ok");


    }

    @Test(priority = 0)
    void dragDrop() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Downloads/Downloads/IntelliJ/gecko/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        // Element which needs to drag.
        WebElement From = driver.findElement(By.xpath("//*[@id='credit2']/a"));
        // Element on which need to drop.
        WebElement To = driver.findElement(By.xpath("//*[@id='bank']/li"));

        Actions action = new Actions(driver);
        Thread.sleep(1000);
        // Dragged and dropped.
        action.dragAndDrop(From, To).build().perform();

        Thread.sleep(1000);
        // Drag and Drop by Pixel.
        WebElement from_5000 = driver.findElement(By.xpath("//*[@id='fourth']/a"));
        action.dragAndDropBy(from_5000, 228, 40).build().perform();

        Thread.sleep(3000);
        action.dragAndDropBy(driver.findElement(By.xpath("//a[normalize-space()='SALES']")),230, 40).build().perform();

        WebElement country = driver.findElement(By.xpath("//div[contains(@class,'css-1hwfws3')]"));
        action.click(country).sendKeys("viet nam").sendKeys(Keys.ENTER).build().perform();
    }

}
