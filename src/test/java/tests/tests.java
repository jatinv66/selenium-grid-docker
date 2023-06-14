package tests;

import base.BaseClass;
import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class tests extends BaseTest {
    private screens s;
    @BeforeClass(alwaysRun = true)
    public void setup(){
        openBrowser();
        s = new screens(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void backDashboard() {
        driver.navigate().to("https://google.com");
    }
    @Test
    public void testcase() throws MalformedURLException {
        s.search();
    }

    @Test
    public void testcase1() throws MalformedURLException {
        s.search();
    }
}
