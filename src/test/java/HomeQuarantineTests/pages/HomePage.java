package HomeQuarantineTests.pages;

import HomeQuarantineTests.objects.HomePageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    public HomePage chooseFile(){

        //WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/input"));

           Actions actions = new Actions(driver);
           actions.moveToElement(driver.findElement(By.xpath("//input[@type='file']")))
                   .click().pause(2000).build().perform();
           return this;


    }

    public HomePage pickfile(String path) throws InterruptedException, AWTException {

        Thread.sleep(4000);
        //File Need to be imported

        File file = new File(path);

        StringSelection StringSelection = new StringSelection(file.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(StringSelection, null);

        driver.switchTo().window(driver.getWindowHandle());

        Robot robot = new Robot();

        //Open Goto window
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);

        //Paste the clipboard value
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);

        //Press Enter key to close the Goto window and Upload window
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        return this;

    }

    public HomePage uploadFile(){
        checkVisibility(uploadbtn);
        uploadbtn.click();
        return this;
    }

    public HomePage clickAlert(){
        checkVisibility(alert);
        alert.click();
        return this;
    }

    public HomePage refreshLog() throws InterruptedException {
        Thread.sleep(2000);
        checkVisibility(refresh);
        refresh.click();
        return this;
    }

    public HomePage reportCheck() throws InterruptedException {
        checkVisibility(report);
        report.click();
        return this;
    }

    public HomePage todayDate(){
        checkVisibility(date);
        date.click();
        return this;
    }

    public HomePage todayReport(){
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


}
