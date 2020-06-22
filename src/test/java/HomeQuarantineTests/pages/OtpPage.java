package HomeQuarantineTests.pages;

import HomeQuarantineTests.objects.OtpPageObjects;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OtpPage extends OtpPageObjects {

    private WebDriverWait wait;

    public OtpPage(RemoteWebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15, 50);
        PageFactory.initElements(driver, this);

    }

    public OtpPage enterOtp(){
            checkVisibility(otp1);
            otp1.sendKeys(obj.getProperty("otp"));
            otp2.sendKeys(obj.getProperty("otp"));
            otp3.sendKeys(obj.getProperty("otp"));
            otp4.sendKeys(obj.getProperty("otp"));
            otp5.sendKeys(obj.getProperty("otp"));
            otp6.sendKeys(obj.getProperty("otp"));
            return this;
    }

    public HomePage verify() throws InterruptedException {
            checkVisibility(verifybtn);
            verifybtn.click();
            Thread.sleep(3000);
            return new HomePage(driver);
    }


}
