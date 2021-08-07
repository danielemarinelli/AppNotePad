package testcase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class MyFirstWiniumTestCase {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		/*
		DesktopOptions opt = new DesktopOptions();
		opt.setApplicationPath("C:\\Windows\\System32\\calc.exe");
		
		WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), opt);
		//WiniumDriver driver = new WiniumDriver(@"C:/Users/damarine2101/Documents/NIELSEN/automationTools/Winium.Desktop.Driver.exe",opt);
		//WiniumDriver driver = new WiniumDriver("C:/Users/damarine2101/Documents/NIELSEN/automationTools/Winium.Desktop.Driver.exe", opt)	
		Thread.sleep(3000);
		System.out.println("Trying to press 7... ");
		//driver.findElement(By.id("num7Button")).click();
		
		driver.findElement(By.name("Sette")).click();
		Thread.sleep(5000);
		System.out.println("Trying to press multiply... ");
		driver.findElement(By.id("multiplyButton")).click();
		System.out.println("Trying to press 5... ");
		driver.findElement(By.id("num5Button")).click();
		System.out.println("Trying to press equal... ");
		driver.findElement(By.id("equalButton")).click();
		
		String result = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
		Thread.sleep(3000);
		System.out.println("Result is: "+result);
		
		*/
		DesktopOptions notepad = new DesktopOptions();
		notepad.setApplicationPath("C:\\Windows\\System32\\notepad.exe");
		WiniumDriver driver1 = new WiniumDriver(new URL("http://localhost:9999"), notepad);
		driver1.findElement(By.id("15")).sendKeys("My first Winium Test....");
		Thread.sleep(5000);
	}

}
