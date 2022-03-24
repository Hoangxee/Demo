package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static graphql.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class googleShopping extends Init {

    @Test(priority = 0)
    void openApp() throws InterruptedException{
        WebElement listFeed = driver.findElement(By.id("/feed-list")); //tao doi tuong dung nhieu lan
        listFeed.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='Polaris-Button Polaris-Button--primary']")).click();

        //kiem tra title popup
        Thread.sleep(1000);
        String title = driver.findElement(By.xpath("//h2[contains(text(),'Add Feed')]")).getText();
        assertEquals("Add Feed", title);
        //assertTrue(title.getText().contains("Add Feed"));
        //assertFalse(title.getText().contains("Add Feed"));

    }

    @Test(priority = 1)
    void channel(){
        WebElement googleShopping = driver.findElement(By.xpath("//span[normalize-space()='Google Shopping']"));
        googleShopping.click();
            assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Select Google account']")).getText().equals("Select Google account"));
            assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Feed status & title']")).getText().equals("Feed status & title"));
            assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Map product types with Google categories']")).getText().equals("Map product types with Google categories"));
            assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Select products']")).getText().equals("Select products"));
            assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Select country of sale']")).getText().equals("Select country of sale"));
            assertTrue(driver.findElement(By.xpath("//p[normalize-space()='SSelect language']")).getText().equals("Select language"));
            assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Select currency']")).getText().equals("Select currency"));
            assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Select schedule sync']")).getText().equals("Select schedule sync"));

        driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
        WebElement backBtn = driver.findElement(By.xpath("//div[@data-polaris-scrollable='true']//button[1]"));
        assertTrue(backBtn.isEnabled());


    }

    @Test(priority = 2)
    void FeedStatusTitle(){
        driver.findElement(By.xpath("//input[@id='title']")).sendKeys("hoangnh", Keys.RETURN);
        Select ageGroup = new Select(driver.findElement(By.id("age_group")));
        ageGroup.selectByVisibleText("Newborn");
        Select gender = new Select(driver.findElement(By.id("gender")));
        gender.selectByVisibleText("Unisex");
        driver.findElement(By.xpath("//*[@class='MuiButtonBase-root MuiButton-root MuiButton-contained jss13']")).click();
    }

    @Test(priority = 3)
    void MapProduct() throws InterruptedException{
        driver.findElement(By.id("PolarisTextField4")).click();
        WebElement mapProduct = driver.findElement(By.id("PolarisTextField4"));
        mapProduct.sendKeys("Animals & Pet Supplies > Live Animals");
        mapProduct.sendKeys(Keys.ARROW_DOWN);
        mapProduct.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained jss13']")).click();;
        Thread.sleep(500);
    }

    @Test(priority = 4)
    void SelectProducts() throws InterruptedException{
        driver.findElement(By.xpath("//button[@class='Polaris-Button']")).click();
        WebElement collection = driver.findElement(By.xpath("//div[@class='Polaris-TextField']//descendant::input[@placeholder='Search Collection']"));
        collection.sendKeys("ok");
        Thread.sleep(300);
        collection.sendKeys(Keys.ARROW_DOWN);
        collection.sendKeys(Keys.ENTER);
        collection.sendKeys(Keys.TAB);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained jss13']")).click();
    }

    @Test(priority = 5)
    void SelectCountryOfSale(){
        WebElement country = driver.findElement(By.xpath("//input[@id='react-select-2-input']"));
        country.sendKeys("viet nam");
        country.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@class='Polaris-Choice__Label']")).click();
        driver.findElement(By.xpath("//input[@id='shipping_fee']")).sendKeys("5000");
        driver.findElement(By.xpath("//input[@id='tax']")).sendKeys("50");
        driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained jss13']")).click();
    }

    @Test(priority = 6)
    void SelectLanguage(){
        WebElement language = driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
        language.sendKeys("viet");
        language.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained jss13']")).click();;
    }

    @Test(priority = 7)
    void SelectCurrency() throws InterruptedException{
        WebElement currency = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
        currency.sendKeys("top");
        currency.sendKeys(Keys.ENTER);
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained jss13']")).click();
        Thread.sleep(500);
    }

    @Test(priority = 8)
    void SelectScheduleSync() throws InterruptedException{
        driver.findElement(By.xpath("//span[normalize-space()='Weekly']")).click();
        Select repeat = new Select(driver.findElement(By.xpath("//*[@id='schedule_repeat']")));
        repeat.selectByValue("5");
        driver.findElement(By.xpath("//input[@id='schedule_hour']")).sendKeys("1213pm");;
        driver.findElement(By.xpath("//span[normalize-space()='Finish']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[normalize-space()='Create Feed']")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//tbody//div[2]//span[1]//button[1]")).click();
    }

}
