package desktopapp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.Test;

public class ESP_Uninstall {
  @Test
  void Uninstall() throws MalformedURLException, InterruptedException {
	  
	  	// Define the path to the application
	  	String appPath = "C:\\Espressif\\unins000.exe";
		
	  	// Create DesktopOptions object
		DesktopOptions dop = new DesktopOptions();
		
		// Set the application path in the DesktopOptions object
		dop.setApplicationPath(appPath);
		
		// Define the URL for the Winium Driver	
		URL url = new URL("http://localhost:9999");
		
		// Create a new instance of the Winium Driver
		WebDriver driver = new WiniumDriver(url,dop);
		
		// Wait for the application to load
		Thread.sleep(3000);
		
		// Click the "Yes" button on the confirmation dialog to confirm the uninstallation
		driver.findElement(By.name("Yes")).click();
		
		// Wait for the application to load
		Thread.sleep(120000);
		
		// Click the "OK" button on the completion dialog after the uninstallation is complete
		driver.findElement(By.name("OK")).click();
	  
	  
 }
}
