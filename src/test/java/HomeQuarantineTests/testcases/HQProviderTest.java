package HomeQuarantineTests.testcases;

import HomeQuarantineTests.pages.LoginPage;
import HomeQuarantineTests.wrappers.ProjectWrappers;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;


public class HQProviderTest extends ProjectWrappers {

    @BeforeClass
    public void beforeClass() {
        description = "To ensure functionality breakdown";
        browser = "chrome";
    }

    //4
    @Test(priority = 2 , enabled=false)
    public void singleFlow() throws InterruptedException, AWTException {

        new LoginPage(driver).role("phonenumber").login().enterOtp().verify().uploadOption().chooseFile("Onboarding").uploadFile().clickAlert().reportCheck().todayDate().todayReport().downloadReport();

        String report = driver.findElementByXPath("//*[text()='Request for file download submitted. Please watch file logs']").getText();
        String title = driver.getTitle();
        Assert.assertEquals(title, obj.getProperty("titleurl"));
        Assert.assertEquals(report, "Request for file download submitted. Please watch file logs");
        System.out.println(report);
    }

    //1, 2, 3
    @Test(priority = 1)
    public void checkOptions() throws InterruptedException, AWTException {

        new LoginPage(driver).role("phonenumber").login().enterOtp().verify();//2 .uploadOption().chooseFile().uploadFile().clickAlert().reportCheck().todayDate().todayReport().downloadReport();

        String hqname = driver.findElementByXPath("//div[contains(text(),'HQ - Provider')]").getText();
        Assert.assertEquals(hqname, obj.getProperty("hqname"));//1

        String option1 = driver.findElementByXPath("//div[contains(text(),'Home')]").getText();
        Assert.assertEquals(option1, obj.getProperty("option1"));
        String option2 = driver.findElementByXPath("//div[contains(text(),'Upload')]").getText();
        Assert.assertEquals(option2, obj.getProperty("option2"));
        String option3 = driver.findElementByXPath("//div[contains(text(),'Report')]").getText();
        Assert.assertEquals(option3, obj.getProperty("option3"));//3
    }

    //10
    @Test
    public void hqAccessOnly() throws InterruptedException, AWTException {

        new LoginPage(driver).role("phonenumber").login().enterOtp().verify().uploadOption();//.chooseFile().uploadFile().clickAlert().reportCheck().todayDate().todayReport().downloadReport();
        Thread.sleep(4000);
        WebElement a = driver.findElementByXPath("//div[@class='tab-container-bottom']//*[local-name()='svg']");
        a.click();
        Thread.sleep(4000);
    }

    //Happy flow -  On boarding patient
    @Test(priority = 1)
    public void onBoardPatient() throws InterruptedException, AWTException, IOException {

        new LoginPage(driver).role("phonenumber").login().enterOtp().verify().uploadOption().requestDataFile().downloadLogs().uploadLogs().processTemplateData().chooseFile("Onboarding").uploadFile().clickAlert().reportCheck();//.todayDate().todayReport().downloadReport();
    }

    //Happy flow -  On boarding patient
    @Test(priority = 2)
    public void patientReport() throws InterruptedException, AWTException, IOException {

        new LoginPage(driver).role("phonenumber").login().enterOtp().verify().uploadOption().reportOption().requestDataFile().downloadLogs().uploadLogs().processTemplateDataPatients().chooseFile("Report").uploadFile().clickAlert().reportCheck();//.todayDate().todayReport().downloadReport();
    }


    @AfterClass
    public void afterClass() {

        driver.close();
        driver.quit();
    }
}