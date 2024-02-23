package desktopapp;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.Test;

public class ESP_Install {
 
	
	
  @Test
  void Install() throws InterruptedException, MalformedURLException 
  {
	  	
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
		Thread.sleep(3000);
		
		 // Click the "OK" button on the first screen (Select Language)
		driver.findElement(By.name("OK")).click();
		
		// Select "I accept the agreement" and 
		//click the "Next" button on the second screen (Accept Agreement)
		driver.findElement(By.name("I accept the agreement")).click();
		driver.findElement(By.name("Next")).click();	
		
		// Click the "Next" button on the third screen (Pre-installation System Check)
		driver.findElement(By.name("Next")).click();
		
		// Click the "Next" button on the fourth screen (Select Destination Location)
		driver.findElement(By.name("Next")).click();
		
		// Click the "Next" button on the fifth screen (Select Components)
		driver.findElement(By.name("Next")).click();
		
		// Click the "Install" button on the sixth screen (Ready to Install) and 
		//wait for the installation to complete
		driver.findElement(By.name("Install")).click();
		Thread.sleep(600000);
		
		// Click the "Finish" button on the seventh screen (Finish)
		driver.findElement(By.name("Finish")).click();
		
		// Verify that the ESP-IDF installation directory exists at the expected location
		File espIdfDirectory = new File("C:/Espressif/");
		assertTrue(espIdfDirectory.exists() && espIdfDirectory.isDirectory(),
                "ESP-IDF installation directory not found at C:/Espressif");
  }
}
