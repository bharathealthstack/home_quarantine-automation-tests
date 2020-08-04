package HomeQuarantineTests.pages;

import HomeQuarantineTests.objects.LoginPageObjects;
import HomeQuarantineTests.wrappers.GenricWrappers;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends LoginPageObjects {

    private WebDriverWait wait;

    public LoginPage(RemoteWebDriver driver) {
        this. driver = driver;
        wait = new WebDriverWait(driver, 15, 50);
        PageFactory.initElements(driver, this);

    }

    public LoginPage role(String num){
        if(num.equalsIgnoreCase("cellnumber")) {
            checkVisibility(number);
            number.sendKeys(obj.getProperty("cellnumber"));

        }
        if (num.equalsIgnoreCase("phonenumber")){
            checkVisibility(number);
            number.sendKeys(obj.getProperty("phonenumber"));
        }
        return this;


    }

    public OtpPage login(){

        checkVisibility(loginbtn);
        loginbtn.click();
        return new OtpPage(driver);
    }




}
