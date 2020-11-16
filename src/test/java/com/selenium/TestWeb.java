package com.selenium;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestWeb {
    public static WebDriver driver;
    @BeforeAll
    public static void initData(){
        System.setProperty("webdriver.chrome.driver", "E:\\driver\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    void testSearch(){

        driver.get("https://ceshiren.com/");
        //driver.findElement(By.id());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#search-button")).click();
        driver.findElement(By.cssSelector("search-term")).sendKeys("selenium");

    }

    @Test
    void testLogin() throws IOException, InterruptedException {
        //driver.get("https://work.weixin.qq.com/wework_admin/loginpage_wx?from=myhome_baidu");
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        Thread.sleep(15000);
        Set<Cookie> cookies = driver.manage().getCookies();
        //gson jackson（git hub 库） 工具
        //ObjectMapper mapper
        //将获取到的cookie存起来
        ObjectMapper mapper= new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File("cookies.yaml"), cookies);


    }

    @Test
    void testLogined() throws IOException, InterruptedException {
        //driver.get("https://work.weixin.qq.com/wework_admin/loginpage_wx?from=myhome_baidu");
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        //Thread.sleep(15000);
        //取出cookie
        ObjectMapper mapper= new ObjectMapper(new YAMLFactory());
        //TypeReference typeReference = new TypeReference<List<HashMap<String, Object>>>(){};
        TypeReference<List<HashMap<String, Object>>> typeReference = new TypeReference<List<HashMap<String, Object>>>() {};
        List<HashMap<String, Object>> cookies = mapper.readValue(new File("cookies.yaml"), typeReference);
        System.out.println("cookies");
        System.out.println(cookies);
        //设置cookie
        cookies.forEach(cookieMap->{
            driver.manage().addCookie(new Cookie(cookieMap.get("name").toString(), cookieMap.get("value").toString()));
        });
        Thread.sleep(5000);
        //刷新界面
        driver.navigate().refresh();

    }


}
