package tests;

import base.BaseClass;
import org.openqa.selenium.WebDriver;

public class screens extends BaseClass {
    public screens(WebDriver driver){
        super(driver);
    }
    private locators l = new locators();
    public void search(){
        fluentwaitTillEleVisibleAndClickable(l.input);
        System.out.println("element found");
    }
}
