package com.pagetest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;
    public BasePage(WebDriver driver) {
        //System.setProperty("webdriver.chrome.driver", "E:\\driver\\chrome\\chromedriver.exe");
        this.driver=driver;
    }

    public BasePage() {
    }

    void click(By by) {
        driver.findElement(by).click();
    }


    void sendKeys(By by, String content) {
        driver.findElement(by).sendKeys(content);
    }

}
