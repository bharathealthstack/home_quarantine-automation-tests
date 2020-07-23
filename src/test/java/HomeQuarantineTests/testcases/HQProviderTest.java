package HomeQuarantineTests.testcases;

import HomeQuarantineTests.pages.LoginPage;
import HomeQuarantineTests.wrappers.ProjectWrappers;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;


public class HQProviderTest extends ProjectWrappers {

    public String m="phonenumber";
    //public String path="C:\\Users\\madan\\OneDrive\\Desktop\\HQ\\home_quarantine-automation-tests\\src\\test\\java\\HomeQuarantineTests\\xlsx\\service_provider.xlsx";
    public String path="/home/hasher/patient onboarding by provider-1594295694089-Success.xlsx";

    @BeforeClass
    public void beforeClass() {
        description = "To ensure functionality breakdown";
        browser = "chrome";
    }

    //4
    @Test
    public void singleFlow() throws InterruptedException, AWTException {

        new LoginPage(driver).role(m).login().enterOtp().verify().uploadOption().chooseFile().uploadFile().clickAlert().reportCheck().todayDate().todayReport().downloadReport();

        String report= driver.findElementByXPath("//*[text()='Request for file download submitted. Please watch file logs']").getText();
        String title= driver.getTitle();
        Assert.assertEquals(title, obj.getProperty("titleurl"));
        Assert.assertEquals(report,"Request for file download submitted. Please watch file logs");
        System.out.println(report);
    }

    //1, 2, 3
    @Test
    public void checkOptions() throws InterruptedException, AWTException {

        new LoginPage(driver).role(m).login().enterOtp().verify();//2 .uploadOption().chooseFile().uploadFile().clickAlert().reportCheck().todayDate().todayReport().downloadReport();

        String hqname= driver.findElementByXPath("//div[contains(text(),'HQ - Provider')]").getText();
        Assert.assertEquals(hqname, obj.getProperty("hqname"));//1

        String option1= driver.findElementByXPath("//div[contains(text(),'Home')]").getText();
        Assert.assertEquals(option1, obj.getProperty("option1"));
        String option2= driver.findElementByXPath("//div[contains(text(),'Upload')]").getText();
        Assert.assertEquals(option2, obj.getProperty("option2"));
        String option3= driver.findElementByXPath("//div[contains(text(),'Report')]").getText();
        Assert.assertEquals(option3, obj.getProperty("option3"));//3
    }

    //10
    @Test
    public void hqAccessOnly() throws InterruptedException, AWTException {

        new LoginPage(driver).role(m).login().enterOtp().verify().uploadOption();//.chooseFile().uploadFile().clickAlert().reportCheck().todayDate().todayReport().downloadReport();
        Thread.sleep(4000);
        WebElement a = driver.findElementByXPath("//div[@class='tab-container-bottom']//*[local-name()='svg']");
        a.click();
        Thread.sleep(4000);
//        String hqname= driver.findElementByXPath("//div[contains(text(),'HQ - Provider')]").getText();
//        Assert.assertEquals(hqname, obj.getProperty("hqname"));
    }

//    @Test
//    public void reportFlow() throws InterruptedException, AWTException {
//
//        new LoginPage(driver).role(m).login().enterOtp().verify().uploadOption().chooseFile().uploadFile().clickAlert().reportCheck().todayDate().todayReport().downloadReport();
//
//        String report= driver.findElementByXPath("//*[text()='Request for file download submitted. Please watch file logs']").getText();
//        String title= driver.getTitle();
//        Assert.assertEquals(title, obj.getProperty("titleurl"));
//        Assert.assertEquals(report,"Request for file download submitted. Please watch file logs");
//        System.out.println(report);
//    }


    @AfterClass
    public void afterClass() {

        driver.close();
    }
}
