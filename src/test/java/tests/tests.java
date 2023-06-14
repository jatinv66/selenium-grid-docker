package tests;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class tests {

    @Test
    public static void testcase() throws MalformedURLException {
        WebDriver driver=null;
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
        try{
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options){};

        }catch(Exception e){
            e.printStackTrace();
        }

        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//launching the specified URL
        driver.get("https://www.google.com/");
//        driver.quit();
        System.out.println("ghgjhg");
    }

    @Test
    public static void testcase1(){
        WebDriver driver=null;
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
        try{
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options){};

        }catch(Exception e){
            e.printStackTrace();
        }

        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//launching the specified URL
        driver.get("https://www.google.com/");
//        driver.quit();
        System.out.println("ghg");
    }
}
