package HomeQuarantineTests.testcases;

import HomeQuarantineTests.pages.LoginPage;
import HomeQuarantineTests.wrappers.ProjectWrappers;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;


public class HQPartnerTest extends ProjectWrappers {

      
    
      public String n="cellnumber";
//      public String path="C:\\Users\\madan\\OneDrive\\Desktop\\HQ\\home_quarantine-automation-tests\\src\\test\\java\\HomeQuarantineTests\\xlsx\\Automation_success_flow.xlsx";
      public String path="C:\\Users\\patient onboarding by provider (2)-1595346265549-Success.xlsx";


    @BeforeClass
    public void beforeClass() {
        description = "To ensure functionality breakdown";
        browser = "chrome";
    }

    @Test(priority = 2)
    public void singleFlow() throws InterruptedException, AWTException {

        //new LoginPage(driver).role(n).login().enterOtp().verify().uploadOption().chooseFile();//.pickfile(path).uploadFile().clickAlert();
        //new LoginPage(driver).role(n).login().enterOtp().verify().uploadOption().chooseFile("Onboarding").pickFile(path).uploadFile().clickAlert();

        String report= driver.findElementByXPath("//*[text()='Request for file download submitted']").getText();
        String title= driver.getTitle();
        Assert.assertEquals(title, obj.getProperty("title"));
        Assert.assertEquals(report,"Request for file download submitted");
        System.out.println(report);
        
     }
    @Test(priority = 1)
    public void verifyPartnerPage() throws Throwable {
    	
    	//String filedownload = driver.findElementByLinkText("File Download").getText();
    	
    	//Assert.assertEquals(filedownload, "File Download");
    	//System.out.println(filedownload);
    	new LoginPage(driver).role(n).login().enterOtp().verify();//2 .uploadOption().chooseFile().uploadFile().clickAlert().reportCheck().todayDate().todayReport().downloadReport();

        String hqpartner= driver.findElementByXPath("//div[contains(text(),'HQ - Partner']").getText();
        Assert.assertEquals(hqpartner, obj.getProperty("hqpartner"));

        String homeoption= driver.findElementByXPath("//div[contains(text(),'Home')]").getText();
        Assert.assertEquals(homeoption, obj.getProperty("homeoption"));
        String uploadoption= driver.findElementByXPath("//div[contains(text(),'Upload')]").getText();
        Assert.assertEquals(uploadoption, obj.getProperty("uploadoption"));
        String reportoption= driver.findElementByXPath("//div[contains(text(),'Report')]").getText();
        Assert.assertEquals(reportoption, obj.getProperty("reportoption"));
        
    }
    
    @AfterClass
    public void afterClass() {
    	
    	driver.close();
    }
    	
    	
    	
    	
    
}
