package desktopapp;

import static org.testng.Assert.assertFalse;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.Test;

public class ESP_Agreement {
  @Test
  void Agreement() throws MalformedURLException, InterruptedException {
	  	
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
		
		// Wait for the application to load
		Thread.sleep(2000);
		
		// Click the "OK" button on the first screen
		driver.findElement(By.name("OK")).click();
		
		// Wait for the next screen to load
		Thread.sleep(2000);
		
		// Check if the "I do not accept the agreement" option is selected
		boolean agreement = driver.findElement(By.name("I do not accept the agreement")).isSelected();
		
		// If the "I do not accept the agreement" option is selected
		if(agreement)
		{
			// Check if the "Next" button is enabled
			boolean next_button = driver.findElement(By.name("Next")).isEnabled();
			
			// Assert that the "Next" button is not enabled
			assertFalse(next_button);
			
			// Print "Test Case Passed" to the console
			System.out.println("Test Case Passed");
		}
		
		// Click the "Cancel" button to exit the installer
		driver.findElement(By.name("Cancel")).click();
		
		// Confirm the cancellation by clicking the "Yes" button
		driver.findElement(By.name("Yes")).click();
  }
}
