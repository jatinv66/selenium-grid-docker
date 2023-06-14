package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import tests.screens;

import java.net.URL;

public class BaseTest {

    public WebDriver driver;
    public void openBrowser() {
        System.out.println("In OpenBrowser");
        try {
//                DesiredCapabilities cap = null;
//                cap = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--no-sandbox");
                options.addArguments("--headless");
                options.addArguments("--remote-debugging-port=9222");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options) {
                };
                System.out.println("driver initialized on http://172.20.0.2:4444/wd/hub");
            }
        catch ( Exception m) {
//            System.out.println("Invalid hub URL");
            m.printStackTrace();
        }
    }

        @AfterClass
    public void quit() {
        if(driver != null) {
            driver.quit();
        }
        else {
            System.out.println("In After Class Driver is not found to quit !!!");
        }
    }
}
