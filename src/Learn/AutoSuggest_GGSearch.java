package Learn;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static graphql.Assert.assertFalse;
import static graphql.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;


//https://anhtester.com/lesson/selenium-java-bai-14-cach-dung-javascript-executor-de-hanh-dong
public class AutoSuggest_GGSearch {
    ChromeDriver driver;
    @Test
    public void search() throws InterruptedException {
//		Tạo biến class của pakage khác
//		Test_1 a = new Test_1();
//		a.agh();

        System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Downloads/Downloads/IntelliJ/gecko/chromedriver.exe");
        driver = new ChromeDriver();

        String text = "selenium";
        driver.get("https://www.google.com");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15)); //doi page load trong 5s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//doi cac step load trong 3s
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@class='YacQv gsfi']/following-sibling::input")).sendKeys("selenium");

        //lấy list kết quả trả về sau khi search
        List<WebElement> searchT = driver.findElements(By.xpath("//ul[@class='G43f7e']//descendant::li"));


        System.out.println(searchT.size());

        Thread.sleep(2000);
        for(WebElement st : searchT){
//			String sttt = st.getText();
//		    System.out.println(sttt);
            System.out.println(st.getText());
//		    if(sttt.equalsIgnoreCase("selenium")){
//		    	st.click();
//		    	break;
//		    }
//		    if(sttt.equals(text)) {
//		        st.click();
//		        break;
//		    }

        }

		/*String alertMessage = "";

        driver.get("http://jsbin.com/usidix/1");
        driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
        alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        System.out.println(alertMessage);
        driver.quit();
		*/
    }
    @Test (priority = 1)
    public void Test123() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Downloads/Downloads/IntelliJ/gecko/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15)); //doi page load trong 5s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//doi cac step load trong 3s
        Thread.sleep(3000);

        WebElement button = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']"));
//        assertEquals("Google Search", button.getText());
//        System.out.println(button.getText());
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("ok chua");
    }

    //cuộn chuột đến vị trí phần tử
    public void scroll_JS(){
        WebElement element = driver.findElement(By.id("id_of_element"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    //verify button enable/disable button save
    public void verifyBtnSave(){
        WebElement buttonSave = driver.findElement(By.id("id_of_element"));
        String title = driver.findElement(By.xpath("//h2[contains(text(),'Add Feed')]")).getText();
        assertEquals(buttonSave.isEnabled(), "False");
        assertFalse(buttonSave.isEnabled());
        assertTrue(buttonSave.isEnabled());
    }

    //Enter không cần gán vào đối tượng cụ thể
//    Actions action = new Actions(driver);
//    action.sendKeys(Keys.ENTER).build().perform();

    //phân biệt .getText() và .getAttribute("value")

    //verify khi search ra nhiều phần tử trong dropdown search: search %like%
    public void dropDown(){
        //findElements: lấy TỔNG số lượng các option thả xuống, trùng với ký tự seach
         List<WebElement> listCheckbox = driver.findElements(By.xpath(""));
        System.out.println(listCheckbox.size());
        String dataSearch = "abc";
        //duyệt listCheckbox.size()
        for(int i = 1; i <= listCheckbox.size(); i++){
            //findElement: trỏ đến TỪNG phần tử cụ thể trong dropdown
            WebElement checkbox = driver.findElement(By.xpath(""));

            //contains là so sánh %like%
            assertTrue(checkbox.getText().contains(dataSearch));

            //equals là so sánh =
            assertTrue(checkbox.getText().equals(dataSearch));

            //Verify option đã chọn trong dropdown
            //so sánh bằng phải dùng equals, không dùng dấu ==
            assertTrue(checkbox.getText().trim().equals(dataSearch));

        }
    }
    void list(){
        WebElement e = driver.findElement(By.xpath("//select[@id='speed']"));
        Select s = new Select(e);
        List<WebElement> options = s.getOptions();

        for(WebElement w : options)
        {
            System.out.println(" Items in drop down : " + w.getText());
        }

        s.selectByVisibleText("Faster");

    }
    void select(){
        //lay ra gia tri default/da chon truoc do cua select
        Select ageGroupSel = new Select(driver.findElement(By.xpath("//select[@id='age_group']")));
        WebElement defaultOption = ageGroupSel.getFirstSelectedOption();

        Assert.assertEquals("text so sanh", defaultOption.getText(), "loi age group");

    }
}
