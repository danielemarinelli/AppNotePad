package testcase;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.Test;
import views.NotePad;


public class MyFirstWiniumTestCase extends TestBase {

        NotePad np;

        //@Test
       // public void checkHelpAboutNowTest() throws Exception {
        //    np = new NotePad();
         //   np.openNotePad();
       // }
        /*DesktopOptions options= new DesktopOptions();
        options.setApplicationPath("C:\\WINDOWS\\system32\\notepad.exe");
        try{
            WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"),options);

            driver.findElementByClassName("Edit").sendKeys("This is a sample test Winium");
            System.out.println("Click on FILE button...!!!");
            //driver.findElement(By.id("Item 1")).click();
            driver.findElement(By.name("File")).click();
            Thread.sleep(2000);
            System.out.println("Click on SAVE button...!!!");
            //driver.findElement(By.id("Item 3")).click();
            driver.findElement(By.name("Save")).click();
            Thread.sleep(2000);
            String notePad = driver.findElement(By.id("TitleBar")).getAttribute("Name");

            //new version - Notepad
            System.out.println("The first application opened is ----> "+notePad);
            //driver.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        DesktopOptions optionsVLC = new DesktopOptions();
        optionsVLC.setApplicationPath("C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe");
        try{
            WiniumDriver driverV=new WiniumDriver(new URL("http://localhost:9999"),optionsVLC);
            String VLC = driverV.findElement(By.id("TitleBar")).getAttribute("Name");
            System.out.println("The second application opened is ----> "+VLC);
            //driver.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("VLC opened but element is wrong,....");
        }

*/

}
