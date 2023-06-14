package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class BaseClass {
    public WebDriver driver;
    public JavascriptExecutor jsExec;
    public WebDriverWait jsWait;
    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }
    public BaseClass() {
    }

    public void fluentwaitTillEleVisibleAndClickable(By locator) {
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
                    .pollingEvery(Duration.ofMillis(2000)).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
                    .ignoring(TimeoutException.class);
            WebElement ele = driver.findElement(locator);
            wait.until(ExpectedConditions.visibilityOf(ele));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            waitUntilJSReady();
            waitForJQueryLoad();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void waitUntilJSReady() {
        try {
            jsWait = new WebDriverWait(driver, 40);
            jsExec = (JavascriptExecutor) driver;
            ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) this.driver)
                    .executeScript("return document.readyState").toString().equals("complete");

            boolean jsReady = jsExec.executeScript("return document.readyState").toString().equals("complete");

            if (!jsReady) {
                jsWait.until(jsLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }

    public void waitForJQueryLoad() {
        try {
            jsWait = new WebDriverWait(driver, 40);
            jsExec = (JavascriptExecutor) driver;
            ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) this.driver)
                    .executeScript("return jQuery.active") == 0);

            boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");

            if (!jqueryReady) {
                jsWait.until(jQueryLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }
}
