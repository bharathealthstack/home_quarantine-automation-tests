package HomeQuarantineTests.testcases;

import HomeQuarantineTests.pages.LoginPage;
import HomeQuarantineTests.wrappers.ProjectWrappers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;


public class HQPartnerTest extends ProjectWrappers {

      public String n="cellnumber";
      public String path="/Users/madanraj.thangarajthoughtworks.com/Desktop/Automation_success_flow.xlsx";


    @BeforeClass
    public void beforeClass() {
        description = "To ensure functionality breakdown";
        browser = "chrome";
    }

    @Test
    public void singleFlow() throws InterruptedException, AWTException {

        new LoginPage(driver).role(n).login().enterOtp().verify().uploadOption().chooseFile().pickfile(path).uploadFile().clickAlert().refreshLog().reportCheck().todayDate().todayReport().downloadReport();

        String report= driver.findElementByXPath("//*[text()='Request for file download submitted']").getText();
        String title= driver.getTitle();Assert.assertEquals(title, obj.getProperty("title"));
        Assert.assertEquals(report,"Request for file download submitted");
        System.out.println(report);

    }

}
