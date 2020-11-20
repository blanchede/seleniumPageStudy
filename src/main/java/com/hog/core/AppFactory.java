package com.hog.core;
import com.hog.config.ConfigInfo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;
import java.net.URL;
/**
 * 生成AppiumDriver的工厂类
 */
public class AppFactory {
    public static AppiumDriver<MobileElement> getDriver() throws MalformedURLException {
        return new AppiumDriver<>(new URL(ConfigInfo.APP_SERVER), new AppOptions().initAndroid());
    }

}
