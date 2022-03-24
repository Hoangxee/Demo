package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Init {
    public WebDriver driver;
    @BeforeTest
    void beforeClass(){
        System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Downloads/Downloads/IntelliJ/browserDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();  //mo rong chrome
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5)); //doi page load trong 5s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));//doi cac step load trong 3s
        driver.get("https://dev.omegatheme.com/shopify/feed-google/server.php?shop=hoangxe-test-1.myshopify.com&hmac=1e8337188381ca80b60c3c25184f8eba61d196ef0b9dad607ac3c6df8ff249b3&forceRedirect=0");
        //driver.switchTo().;
        //hàm chờ có điều kiện (check alert message,...)
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("...")));
    }
    @AfterTest
    void afterClass() throws InterruptedException {
//        Thread.sleep(5000);
//        driver.quit();
    }
}
