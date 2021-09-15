package testcase;


import core.DriverFactory;
import core.TestConfig;
import core.TestReporter;
import io.appium.java_client.windows.WindowsDriver;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import org.testng.ITestResult;
import org.testng.annotations.*;
import views.NotePad;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {

    private WiniumDriver driver=null;
    private WindowsDriver driverWin=null;
    private TestReporter reporter;

  /*  public WiniumDriver setupNotepadEnvironment() throws IOException {

        String notePadApplicationPath = "C:\\WINDOWS\\system32\\notepad.exe";
        String winiumDriverPath = "C:\\Users\\damarine2101\\Documents\\NIELSEN\\automationTools\\Winium.Desktop.Driver.exe";
        //String winiumDriverPath = System.setProperty("Winium.Desktop.Driver", System.getProperty("user.dir")+"\\src\\main\\resources\\driver\\Winium.Desktop.Driver.exe");
        DesktopOptions options = new DesktopOptions(); //Initiate Winium Desktop Options
        options.setApplicationPath(notePadApplicationPath); //Set notepad application path

        File drivePath = new File(winiumDriverPath); //Set winium driver path

        WiniumDriverService service = new WiniumDriverService.Builder().usingDriverExecutable(drivePath).usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
        service.start(); //Build and Start a Winium Driver service
        driver = new WiniumDriver(service, options); //Start a winium driver

        return driver;

    }*/

    @BeforeMethod
    public void setUp()  {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app","C:\\WINDOWS\\system32\\notepad.exe");
        cap.setCapability("platformName","Windows");
        cap.setCapability("deviceName","WindowsPC");

        try {
            driverWin = new WindowsDriver(new URL("http://127.0.0.1:4723/"),cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driverWin.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void cleanUp(){
        driverWin.quit();
    }

    @AfterSuite
    public void tearDown(){
        driverWin.quit();
    }

    @Test
    public void checkHelpAboutNowTest() throws Exception {
        driverWin.findElementByName("Help").click();
        driverWin.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driverWin.findElementByName("About Notepad").click();
        driverWin.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driverWin.findElementByName("OK").click();
        //driverWin.findElementByWindowsUIAutomation("1").click();
        //driverWin.findElementById("1").click();
        //String name = driverWin.findElementByName("Version 20H2 (OS Build 19042.1165)").getText();
        //System.out.println(name);
    }


    @Test
    public void sendText(){
        driverWin.findElementByName("Text Editor").sendKeys("example test automation");
        driverWin.findElementByName("Text Editor").clear();
    }



/*
    @BeforeSuite
    public void initSuite() throws Exception {
        TestConfig.load(System.getenv("env"));
        TestConfig.addProperty("browser",System.getenv("browser"));
        TestConfig.addProperty("env",System.getenv("env"));
        reporter = new TestReporter();
    }

    @BeforeClass
    public void initDriver() {
        driver =  new DriverFactory().getDriver(TestConfig.getProperty("browser"));
    }


    public WebDriver driver() {
        return driver;
    }

    public void moveOverElementInPage(WebElement ele){
        Actions action = new Actions(driver());
        action.moveToElement(ele).perform();
    }

    @BeforeMethod
    public void launchApp() {
        driver.get(TestConfig.getProperty("appHomeURL"));
    }

    @BeforeMethod
    public void initTestReport(Method method){
        reporter.startReporting(method.getName(), driver);
    }

    public TestReporter reporter(){
        if(reporter!=null){
            return reporter;
        }
        return null;
    }

    @AfterMethod
    public void closeReport(){
        reporter.endReporting();
    }

    @AfterClass
    public void cleanUp() {
        if(driver!=null) {
            driver.close();
        }
    }

    @AfterSuite
    public void clearReport(){
        reporter.flushReport();
    }
*/
    public WiniumDriver winDriver() {
    return driver;
}

    @AfterMethod
    public void takeScreenShotIfFailure(ITestResult result) throws IOException {
        if(ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot camera =((TakesScreenshot)driver);
            File screenShot = camera.getScreenshotAs(OutputType.FILE);
            System.out.println("Screenshot taken: " + screenShot.getAbsolutePath());
            File DestFile = new File("./ScreenShots/"+result.getName()+"_Fail.png");
            FileHandler.copy(screenShot,DestFile);
        }

    }

}