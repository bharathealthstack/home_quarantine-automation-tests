package HomeQuarantineTests.wrappers;

import HomeQuarantineTests.pages.HomePage;
import org.testng.annotations.*;


import java.io.IOException;

public class ProjectWrappers extends GenricWrappers {

  public HomePage homePage;

    // contains 8 testng methods
    public String excelSheetName, description;
    public String browser = "chrome";

    @BeforeSuite
    public void beforeSuit() {
        //startReport();

    }

    @BeforeTest
    public void beforeTest() {
        loadObject();

    }

    @BeforeMethod
    public void beforeMethod() {

        getBrowser(browser, "https://ops-stage4192.swasthapp.org/login");
    }

    @AfterMethod
    public void afterMethod() {
        homePage=new HomePage(driver);
        homePage.endSession();

    }

    @AfterClass
    public void afterClass() {
        //endTest();
    }

    @AfterTest
    public void afterTest() {

        unloadObject();
    }

    @AfterSuite
    public void afterSuit() {
        //endReport();
    }

	/*@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return DataProviderFromExcel.getData(excelSheetName);
	}
	*/


}