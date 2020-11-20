package com.hog.core;

import com.hog.config.ConfigInfo;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * appium的参数设置
 */
public class AppOptions {
    private final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

    private void init(){
        setNoSign(true);
        setNoReset(true);
        setUnicodeKeyboard(true);
        setResetKeyboard(true);
    }

    /**
     * android的初始化配置
     * @return DesiredCapabilities
     */
    public DesiredCapabilities initAndroid(){
        init();
        setPlatformName(ConfigInfo.APP_PLATFORM_NAME);
        setDeviceName(ConfigInfo.DEVICE_NAME);
        setAppPackage(ConfigInfo.APP_PACKAGE);
        setAppActivity(ConfigInfo.APP_ACTIVITY);
        setAdbExecTimeout(ConfigInfo.APP_ADB_EXEC_TIMEOUT);
        return desiredCapabilities;
    }

    /**
     * 设置是否保留程序的状态
     * @param noReset	true表示保留，false表示重置
     */
    public void setNoReset(boolean noReset) {
        desiredCapabilities.setCapability("noReset",noReset);
    }

    /**
     * 是否跳过检查与签名
     * @param noSign	true 跳过检查，false不跳过检查
     */
    public void setNoSign(boolean noSign) {
        desiredCapabilities.setCapability("noSign",noSign);
    }
    /**
     * 设置是否启动unicode输入
     * @param unicodeKeyboard	true表示启用，false表示不启用
     */
    public void setUnicodeKeyboard(boolean unicodeKeyboard) {
        desiredCapabilities.setCapability("unicodeKeyboard",unicodeKeyboard);
    }

    /**
     * 将键盘置为原始状态
     * @param resetKeyboard  true：置为原始状态  false：保持原样
     */
    public void setResetKeyboard(boolean resetKeyboard) {
        desiredCapabilities.setCapability("resetKeyboard",resetKeyboard);
    }

    /**
     * 设置平台名称
     * @param platformName android 、 ios
     */
    public void setPlatformName(String platformName){
        desiredCapabilities.setCapability("platformName", platformName);
    }

    /**
     * 设置设备名称
     * @param deviceName 设备名称
     */
    public void setDeviceName(String deviceName){
        desiredCapabilities.setCapability("deviceName", deviceName);
    }

    /**
     * 设置程序的包名  android独有
     * @param appPackage	包名
     */
    public void setAppPackage(String appPackage){
        desiredCapabilities.setCapability("appPackage", appPackage);
    }

    /**
     * 设置android的activity
     * @param appActivity activity
     */
    public void setAppActivity(String appActivity){
        desiredCapabilities.setCapability("appActivity", appActivity);
    }


    /**
     * 设置adb命令执行的超时时间
     * @param timeout	超时时间
     */
    public void setAdbExecTimeout(Long timeout){
        desiredCapabilities.setCapability("adbExecTimeout", timeout);
    }
}
