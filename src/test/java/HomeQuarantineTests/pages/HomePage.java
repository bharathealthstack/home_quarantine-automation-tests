package HomeQuarantineTests.pages;

import HomeQuarantineTests.objects.HomePageObjects;
import HomeQuarantineTests.rwexcel.ReadWriteExcelData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class HomePage extends HomePageObjects {

    private WebDriverWait wait;

    public HomePage(RemoteWebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15, 50);
        PageFactory.initElements(driver, this);

    }

    public HomePage uploadOption() throws InterruptedException {
        checkVisibility(uploadicon);
        uploadicon.click();
        
        Thread.sleep(4000);
        return this;
    }

    public HomePage requestDataFile() throws InterruptedException {
        driver.findElement(By.xpath("//span[@class='label-padding download-link']")).click();
        Thread.sleep(4000);
        return this;
    }

    public HomePage downloadLogs() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='tab-container-bottom']//div[@class='active-tab tab-button']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//tr[1]//td[5]")).click();
        Thread.sleep(4000);
//        driver.findElement(By.xpath("//html//body")).sendKeys(Keys.CONTROL + "tab");
//        driver.getWindowHandles().
        Set<String> winhandles = driver.getWindowHandles();
        Iterator<String> it = winhandles.iterator();
        String mainWindow=it.next();
        String childWindow =it.next();
        driver.switchTo().window(childWindow);
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(mainWindow);
        return this;
    }

    public HomePage uploadLogs() throws InterruptedException {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[4]/div[2]")).click();
        Thread.sleep(4000);
        return this;
    }



    public HomePage chooseFile(){

        //WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/input"));

           Actions actions = new Actions(driver);
//           actions.moveToElement(driver.findElement(By.xpath("//input[@type='file']")))
//                   .click().pause(2000).build().perform();


            driver.findElement(By.xpath("//input[@id='file']")).sendKeys("/home/hasher/Downloads/Patient Onboarding Details - SP to Swasth.xlsx");

            //driver.findElement(By.xpath("//input[@id='file']")).sendKeys("C:\\Users\\hasher\\eclipse-workspace\\home_quarantine-automation-tests\\src\\test\\java\\"
            //		+ "HomeQuarantineTests\\xlsx\\patient onboarding by provider (2)-1595346265549-Success.xlsx");

           return this;

    }

    public HomePage pickFile(String path) throws InterruptedException, AWTException {

        Thread.sleep(4000);
        //File Need to be imported
        // Specify the file location with extension
        StringSelection sel = new StringSelection(path);

        // Copy to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
        System.out.println("selection" +sel);


        // Create object of Robot class
        Robot robot = new Robot();
        Thread.sleep(2000);

        // Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);

        // Release Enter
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Press CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        // Release CTRL+V
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyRelease(KeyEvent.VK_V);
//        Thread.sleep(1000);
//
//        //Press Enter
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);

        return this;

    }

    public HomePage uploadFile() throws InterruptedException {
        Thread.sleep(4000);
        checkVisibility(uploadbtn);
        uploadbtn.click();
        Thread.sleep(2000);
        return this;
    }

    public HomePage clickAlert() throws InterruptedException {
        checkVisibility(alert);
        alert.click();
        Thread.sleep(4000);
        return this;
    }

    public HomePage refreshLog() throws InterruptedException {
        Thread.sleep(2000);
        checkVisibility(refresh);
        refresh.click();
        return this;
    }

    public HomePage reportCheck() throws InterruptedException {
        Thread.sleep(5000);
        checkVisibility(report);
        report.click();
        return this;
    }

    public HomePage todayDate() throws InterruptedException{
        Thread.sleep(3000);
        checkVisibility(date);
        date.click();
        return this;
    }

    public HomePage todayReport() throws InterruptedException{
        Thread.sleep(3000);
        checkVisibility(today);
        today.click();
        return this;
    }

    public HomePage downloadReport() throws InterruptedException {
        checkVisibility(download);
        download.click();
        Thread.sleep(3000);
        return this;
    }
    

    public LoginPage endSession(){
        checkVisibility(logout);
        logout.click();
        String login= driver.findElementByXPath("(//*[text()='Login To Control Tower'])[1]").getText();
        Assert.assertEquals(login,"Login To Control Tower");
        System.out.println(login);
        return new LoginPage(driver);
    }

    public HomePage processTemplateData() throws IOException {
        ReadWriteExcelData.processTemplateData();
        return this;
    }


}
