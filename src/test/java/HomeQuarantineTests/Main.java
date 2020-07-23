package HomeQuarantineTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello");
        //System.getProperty("webdriver.chrome.driver","/home/hasher/Downloads/Stage/chromedriver_linux64/chromedriver");
        System.setProperty("webdriver.chrome.driver","/home/hasher/Downloads/Stage/home_quarantine-automation-tests/src/test/java/HomeQuarantineTests/drivers/chromedriver");
        //System.getProperty("webdriver.chrome.driver","./drivers/chromedriver");
        WebDriver obj = new ChromeDriver();
        obj.get("https://www.google.com/");
    }
}
