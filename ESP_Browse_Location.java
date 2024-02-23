package desktopapp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.Test;

public class ESP_Browse_Location {
  @Test
  void Browse() throws MalformedURLException, InterruptedException {
	  
	  	// Define the path to the application
	  	String appPath = "C:\\Program Files (x86)\\Espressif\\espressif-ide-setup-2.12.0-with-esp-idf-5.1.2.exe";
		
	  	// Create DesktopOptions object	  	
		DesktopOptions dop = new DesktopOptions();
		
	  	// Set the application path in the DesktopOptions object		
		dop.setApplicationPath(appPath);
		
		// Define the URL for the Winium Driver		
		URL url = new URL("http://localhost:9999");
		
		// Create a new instance of the Winium Driver
		WebDriver driver = new WiniumDriver(url,dop);
		
		// Create a new Actions object
		Actions act = new Actions(driver);
		
		// Wait for the application to load
		Thread.sleep(3000);
		
		 // Click the "OK" button on the first screen (Select Language)
		driver.findElement(By.name("OK")).click();
		
		// Wait for the next screen to load
		Thread.sleep(2000);
		
		// Select "I accept the agreement" and 
		//click the "Next" button on the second screen (Accept Agreement)
		driver.findElement(By.name("I accept the agreement")).click();
		driver.findElement(By.name("Next")).click();
		
		// Click the "Next" button on the third screen (Pre-installation System Check)
		driver.findElement(By.name("Next")).click();
		
		// Click the "Browse..." button on the fourth screen (Select Destination Location)
		driver.findElement(By.name("Browse...")).click();
		
		// Double-click on "Local Disk (C:)" in the file explorer
		WebElement ele = driver.findElement(By.name("Local Disk (C:)"));
		act.doubleClick(ele).perform();
		
		// Double-click on "Test" in the file explorer
		ele = driver.findElement(By.name("Test"));
		act.doubleClick(ele).perform();
		
		// Click the "OK" button to confirm the installation location
		driver.findElement(By.name("OK")).click();
		
		// Click the "Next" button on the fifth screen (Select Components)
		driver.findElement(By.name("Next")).click();
		
		// Click the "Next" button on the sixth screen (Ready to Install)
		driver.findElement(By.name("Next")).click();
		
		// Click the "Cancel" button to exit the installer
		driver.findElement(By.name("Cancel")).click();
		
		// Confirm the cancellation by clicking the "Yes" button
		driver.findElement(By.name("Yes")).click();
  }
}
