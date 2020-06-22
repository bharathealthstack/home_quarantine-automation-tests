package HomeQuarantineTests.objects;

import HomeQuarantineTests.wrappers.GenricWrappers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects extends GenricWrappers {


    @FindBy(id = "phone")
    public WebElement number;


    @FindBy(xpath="//button[text()='LOGIN']")
    public  WebElement loginbtn;

}
