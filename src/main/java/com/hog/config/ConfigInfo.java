package com.hog.config;

import java.io.IOException;
import java.util.Properties;

/**
 * config.properties里配置的数据传入
 */

public class ConfigInfo {
    public static String APP_SERVER = null;

    public static String DEVICE_NAME = null;

    public static String APP_PACKAGE = null;

    public static String APP_ACTIVITY = null;

    public static String APP_PLATFORM_NAME = null;

    public static Long APP_ADB_EXEC_TIMEOUT = null;

    static {
        Properties pro = new Properties();
        try {
            pro.load(ConfigInfo.class.getClassLoader().getResourceAsStream("config.properties"));
            DEVICE_NAME = pro.getProperty("app.deviceName");

            APP_PACKAGE = pro.getProperty("app.package");

            APP_ACTIVITY = pro.getProperty("app.activity");

            APP_PLATFORM_NAME = pro.getProperty("app.platformName");

            APP_SERVER = pro.getProperty("app.server");

            APP_ADB_EXEC_TIMEOUT = Long.parseLong(pro.getProperty("app.adb.exec.timeout"));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
