package HomeQuarantineTests.objects;

import HomeQuarantineTests.wrappers.GenricWrappers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePageObjects extends GenricWrappers {

    @FindBy(xpath = "//div[text()='Upload']")
    public  WebElement uploadicon;

    @FindBy(xpath = "//h2[contains(text(),'Patients Report')]")
    public  WebElement reporticon;

    @FindBy(xpath = "//input[@type='file']")
    public  WebElement file;

    @FindBy(xpath = "//button[text()='Upload File']")
    public  WebElement uploadbtn;

    @FindBy(xpath = "//span[text()='Upload']")
    public  WebElement alert;

    @FindBy(css = "#root > div > div > div > div.css-1hetcr1 > div.container.css-4cffwv > div.log-heading-container > svg")
    public  WebElement refresh;

    @FindBy(xpath = "//div[text()='Report']")
    public  WebElement report;

    @FindBy(xpath = "//input[@id='text']")
    public  WebElement date;

    @FindBy(xpath = "//span[text()='TODAY']")
    public  WebElement today;

    @FindBy(xpath = "//span[text()='Download']")
    public  WebElement download;

    @FindBy(xpath = "(//*[text()='Logout'])[1]")
    public  WebElement logout;

}
