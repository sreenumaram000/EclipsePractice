package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.DriverManager;

import java.time.Duration;

public class Hooks {


	
    @Before(order =0)
    public void setUp() {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Set driver in DriverManager for step classes
        DriverManager.setDriver(driver);

       
    }

    @After
    public void tearDown() {
        WebDriver driver = DriverManager.getDriver();
    	  if (driver != null) {
            driver.quit();
        }
    }
}
