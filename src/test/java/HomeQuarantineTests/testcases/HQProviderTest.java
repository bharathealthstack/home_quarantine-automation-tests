package HomeQuarantineTests.testcases;

import HomeQuarantineTests.pages.LoginPage;
import HomeQuarantineTests.wrappers.ProjectWrappers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

public class HQProviderTest extends ProjectWrappers {

    public String n="phonenumber";
    public String path="/Users/madanraj.thangarajthoughtworks.com/Desktop/service_provider.xlsx";

    @BeforeClass
    public void beforeClass() {
        description = "To ensure functionality breakdown";
        browser = "chrome";
    }

    @Test
    public void singleFlow() throws InterruptedException, AWTException {

        new LoginPage(driver).role(n).login().enterOtp().verify().uploadOption().chooseFile().pickfile(path).uploadFile().clickAlert().reportCheck().todayDate().todayReport().downloadReport();

        String report= driver.findElementByXPath("//*[text()='Request for file download submitted. Please watch file logs']").getText();
        String title= driver.getTitle();Assert.assertEquals(title, obj.getProperty("title"));
        Assert.assertEquals(report,"Request for file download submitted. Please watch file logs");
        System.out.println(report);
    }
}
