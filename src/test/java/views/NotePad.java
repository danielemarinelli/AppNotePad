package views;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.Test;
import testcase.TestBase;

import java.net.URL;

public class NotePad extends TestBase {

 /*   @FindBy(xpath = "/*[@id='Item 1']")
    private WebElement File;

    @FindBy(xpath = ".//select[@class='goog-te-combo']")
    private WebElement languageOnSite;
*/

    private WiniumDriver driver;
    private WindowsDriver driverWin=null;

    public void openNotePad(){

                driverWin.findElementByName("Help").click();
                driverWin.findElementByName("About Notepad").click();
                driverWin.findElementByName("OK").click();

    }
}
