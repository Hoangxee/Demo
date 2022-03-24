package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import static graphql.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class xmlFeed extends Init {
    private String feedTitle = "hoangnh";
    private String ageGroupText = "Newborn";
    private  String genderText = "Unisex";
    private String shippingfee = "5000";
    private  String taxRate = "50";
    private String dataCollection = "' show tables";

    @Test(priority = 0)
    void openApp() throws InterruptedException{
        WebElement listFeed = driver.findElement(By.id("/feed-list")); //tao doi tuong dung nhieu lan
        listFeed.click();
    }

    @Test(priority = 1)
    void channel() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='Polaris-Button Polaris-Button--primary']")).click();

        //kiem tra title popup
        Thread.sleep(1000);
        String title = driver.findElement(By.xpath("//h2[contains(text(),'Add Feed')]")).getText();
        assertEquals("Add Feed", title);
        //assertTrue(title.getText().contains("Add Feed"));
        //assertFalse(title.getText().contains("Add Feed"));

        WebElement xmlFeed = driver.findElement(By.xpath("//span[normalize-space()='XML Feed']"));
        xmlFeed.click();
            assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Feed status & title']")).getText().equals("Feed status & title"));
            assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Map product types with Google categories']")).getText().equals("Map product types with Google categories"));
            assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Select products']")).getText().equals("Select products"));
            assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Select country of sale']")).getText().equals("Select country of sale"));
            assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Select language']")).getText().equals("Select language"));
            assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Select currency']")).getText().equals("Select currency"));
            assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Select schedule sync']")).getText().equals("Select schedule sync"));
        driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
        WebElement backBtn = driver.findElement(By.xpath("//div[@data-polaris-scrollable='true']//button[1]"));
        assertTrue(backBtn.isEnabled());
    }

    @Test(priority = 2)
    void FeedStatusTitle(){

        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Enable')]")).isEnabled());
        String placeHolderFeedTitle = driver.findElement(By.xpath("//input[@id='title']")).getAttribute("placeholder");
        assertEquals("Please enter a title to continue!", placeHolderFeedTitle);
        driver.findElement(By.xpath("//input[@id='title']")).sendKeys(feedTitle, Keys.RETURN);

        WebElement ageGroupSel = driver.findElement(By.id("age_group"));
        Select ageGroup = new Select(ageGroupSel);
        String defaultAgeGroup = ageGroup.getFirstSelectedOption().getText();
        assertEquals(defaultAgeGroup, "Keep it Blank");
        ageGroup.selectByVisibleText(ageGroupText);

        WebElement genderSel = driver.findElement(By.id("gender"));
        Select gender = new Select(genderSel);
        String defaultGender = gender.getFirstSelectedOption().getText();
        assertEquals(defaultGender, "Keep it Blank");
        gender.selectByVisibleText(genderText);
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
        WebElement selectProductDefault = driver.findElement(By.xpath("//span[contains(text(),'All Products')]"));
        Assert.assertTrue(selectProductDefault.isEnabled(), "loi default");

        driver.findElement(By.xpath("//button[@class='Polaris-Button']")).click();
        WebElement collection = driver.findElement(By.xpath("//div[@class='Polaris-TextField']//descendant::input[@placeholder='Search Collection']"));
        collection.sendKeys(dataCollection);
        Thread.sleep(300);
        collection.sendKeys(Keys.ARROW_DOWN);
        collection.sendKeys(Keys.ENTER);
        collection.sendKeys(Keys.TAB);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained jss13']")).click();
    }

    @Test(priority = 5)
    void SelectCountryOfSale() throws InterruptedException {
        WebElement checkbox = driver.findElement(By.xpath("//span[@class='Polaris-Checkbox']"));
        Assert.assertFalse(checkbox.isSelected(), "sai default");
        WebElement country = driver.findElement(By.xpath("//input[@id='react-select-2-input']"));
        country.sendKeys("viet nam");
        country.sendKeys(Keys.ENTER);
        checkbox.click();
        driver.findElement(By.xpath("//input[@id='shipping_fee']")).sendKeys(shippingfee);
        driver.findElement(By.xpath("//input[@id='tax']")).sendKeys(taxRate);
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
        Thread.sleep(500);
        WebElement currency = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
        currency.sendKeys("top");
        currency.sendKeys(Keys.ENTER);
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained jss13']")).click();
        Thread.sleep(500);
    }

    @Test(priority = 8)
    void SelectScheduleSync() throws InterruptedException{
        WebElement hourlyDefault = driver.findElement(By.xpath("//input[@id='schedule_type_hourly']"));
        Assert.assertTrue(hourlyDefault.isSelected(), "sai default");

        List<WebElement> repeatDefault =  driver.findElements(By.xpath("//*[@id='schedule_repeat']"));
//        System.out.println(repeatDefault.size());
//        Assert.assertTrue(repeatDefault);
        driver.findElement(By.xpath("//span[normalize-space()='Weekly']")).click();
        Select repeat = new Select(driver.findElement(By.xpath("//*[@id='schedule_repeat']")));
        repeat.selectByValue("5");
        driver.findElement(By.xpath("//input[@id='schedule_hour']")).sendKeys("1213pm");;
        driver.findElement(By.xpath("//span[normalize-space()='Finish']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[normalize-space()='Create Feed']")).click();
    }

    @Test(priority = 9)
    void verify() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//tbody/tr[3]/td[2]/div[1]/div[1]/span[1]/button[1]/span[1]/span[1]/span[1]//*[name()='svg']")).click();

        WebElement channelEdit = driver.findElement(By.xpath("//div[@data-polaris-scrollable='true']/div/div/div/div/div[1]/div[1]/div[1]/div[2]/div[1]"));
        Assert.assertTrue(channelEdit.isEnabled(), "sai xml feed");

        WebElement enableFeedEdit = driver.findElement(By.xpath("//div[@data-polaris-layer='true']/div/div[@role='dialog']/div/div/div[@data-polaris-scrollable='true']/div/div[3]/div[2]"));
        Assert.assertTrue(enableFeedEdit.isEnabled(), "sai enable feed");

        WebElement feedTitleEdit = driver.findElement(By.xpath("//div[2]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]"));
        assertEquals(feedTitle,feedTitleEdit.getAttribute("value"), "loi feed title");

        Select ageGroupSel = new Select(driver.findElement(By.xpath("//select[@id='age_group']")));
        WebElement ageGroupDefaultOption = ageGroupSel.getFirstSelectedOption();
        assertEquals(ageGroupText, ageGroupDefaultOption.getText(), "loi age group");

        Select genderSel = new Select(driver.findElement(By.xpath("//select[@id='gender']")));
        WebElement genderDefaultOption = genderSel.getFirstSelectedOption();
        assertEquals(genderText, genderDefaultOption.getText(), "loi gender");

//        WebElement shippingFeeEdit = driver.findElement(By.xpath("//input[@id='shipping_fee']"));
//        assertEquals(shippingfee,shippingFeeEdit.getAttribute("value"), "loi shipping fee");
//
//        WebElement taxRateEdit = driver.findElement(By.xpath("//input[@id='shipping_fee']"));
//        assertEquals(taxRate,taxRateEdit.getAttribute("value"), "loi tax rate");

        WebElement productType = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
        assertEquals("Animals & Pet Supplies", productType.getAttribute("value"), "loi map product");

        WebElement selectProductsEdit = driver.findElement(By.xpath("//div[@role='dialog']/div/div/div[@data-polaris-scrollable='true']/div/div/div/div/div/div/div/span[1]"));
        Assert.assertTrue(selectProductsEdit.getText().contains(dataCollection), "loi select products");

        WebElement scheduleSync = driver.findElement(By.xpath("//div[12]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/label[1]/span[1]/span[1]/input[1]"));
        Assert.assertTrue(scheduleSync.isSelected(), "loi scheldule sync");

        Select scheduleRepeat = new Select(driver.findElement(By.xpath("//select[@id='schedule_repeat']")));
        WebElement scheduleRepeatOption = scheduleRepeat.getFirstSelectedOption();
        assertEquals(scheduleRepeatOption.getText(), "Every Friday", "loi repeat");

        String scheduleHourVerify = "12:131212";
        WebElement scheduleHour = driver.findElement(By.xpath("//input[@id='schedule_hour']"));
        assertEquals(scheduleHourVerify, scheduleHour.getAttribute("value"), "loi schedule hour");

        driver.findElement(By.xpath("//button[@aria-label='Close']//span//*[name()='svg']")).click();
        System.out.println("verify successful");
    }

    @Test(priority = 10)
    void delete() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.xpath("//tbody/tr[3]/td[2]/div[1]/div[2]/span[1]/button[1]/span[1]/span[1]/span[1]//*[name()='svg']//*[name()='path' and contains(@d,'M8 3.994C8')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).click();
        System.out.println("delete successful");
    }

}
