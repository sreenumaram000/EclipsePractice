package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//    private static WebDriver driver;

    // Setter
    public static void setDriver(WebDriver driverInstance) {
//      driver = driverInstance;
    	
//    	driver is a ThreadLocal object that can store a value per thread.
//    	ThreadLocal is a Java class, part of java.lang.
//    	ThreadLocal class has two main methods:
//    	set(value to set)   // store value for current thread
//    	get()             // get value for current thread
    	
    	driver.set(driverInstance);
    	

    	
    }

    // Getter
    public static WebDriver getDriver() {
//    	return driver;
    	return driver.get();
    
    }
}
