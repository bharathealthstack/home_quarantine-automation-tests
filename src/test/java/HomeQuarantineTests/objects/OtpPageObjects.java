package HomeQuarantineTests.objects;

import HomeQuarantineTests.wrappers.GenricWrappers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OtpPageObjects extends GenricWrappers{


    @FindBy(xpath="(//input[@type='number'])[1]")
    public WebElement otp1;
    @FindBy(xpath="(//input[@type='number'])[2]")
    public WebElement otp2;
    @FindBy(xpath="(//input[@type='number'])[3]")
    public WebElement otp3;
    @FindBy(xpath="(//input[@type='number'])[4]")
    public WebElement otp4;
    @FindBy(xpath="(//input[@type='number'])[5]")
    public WebElement otp5;
    @FindBy(xpath="(//input[@type='number'])[6]")
    public WebElement otp6;

    @FindBy(xpath="//button[text()='Verify']")
    public WebElement verifybtn;
}
