package com.hog.page;

import com.hog.core.AppBasePage;
import com.hog.core.AppFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.time.Duration;

public class HomePage extends AppBasePage {
    public HomePage() {

        initDriver();
    }
    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @AndroidFindBy(uiAutomator = "resourceId(\"com.tencent.wework:id/egd\").text(\"通讯录\")")
    private WebElement contactBtn;


    /**
     * 点击通讯录，进入通讯录页面
     * @return	ContactPage
     */
    public ContactPage contact(){
        click(contactBtn);
        return new ContactPage(driver);
    }



    /**
     * 初始化driver
     */
    public void initDriver(){
        try {
            driver = AppFactory.getDriver();
            AppiumFieldDecorator decorator = new AppiumFieldDecorator(this.driver, Duration.ofMillis(6000));
            PageFactory.initElements(decorator, this);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}


