package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverStore {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver == null) throw new RuntimeException("Driver not initialised. Run init() before use.");
        return driver;
    }

    public static void closeDriver() {
        if(driver != null) driver.quit();
    }

    static void init(String driverName) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
}
