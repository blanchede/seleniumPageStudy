package com.hog.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AppBasePage {
    public AppiumDriver<MobileElement> driver;

    public WebDriverWait wait;

    private TouchAction touchAction;

    public AppBasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        AppiumFieldDecorator decorator = new AppiumFieldDecorator(this.driver, Duration.ofMillis(5000));
        PageFactory.initElements(decorator, this);
    }

    public AppBasePage() {
    }

    /**
     *隐式等待方法
     */
    private void implicitlyWait(long time, TimeUnit unit) {
        driver.manage().timeouts().implicitlyWait(time, unit);
    }

    /**
     * 点击元素
     */

    public void click(WebElement element){
        implicitlyWait(3, TimeUnit.SECONDS);
            element.click();
    }

    /**
     * 给元素 输入信息
     */
    public void inputText(WebElement element, String text){
        if (element.isDisplayed()){
            element.clear();
            element.sendKeys(text);
        }else {
            getWait().until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
        }
    }

    public WebDriverWait getWait(){
        return new WebDriverWait(driver, 60, 1000);
    }


}
