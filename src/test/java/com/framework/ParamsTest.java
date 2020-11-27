package com.framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ParamsTest {

    /**
     * 参数化举例
     */
    /*
    @ParameterizedTest
    //参数化1
    //@ValueSource(strings = {"search demo1","search demo2"})
    @MethodSource()
    void searchDemo01(String keyword) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://ceshiren.com/");
        driver.findElement(By.id("search-button")).click();
        driver.findElement(By.id("search-term")).sendKeys(keyword);

    }*/
    /**
     * 使用yaml文件参数传递
     */
    @ParameterizedTest
    @MethodSource()
    void searchDemo02(TestCase testCase){
        System.out.println(testCase);
        //done: runner引擎
        testCase.run();
    }
    static Stream<TestCase> searchDemo02() throws IOException {
        //return  Stream.of("apple","banana");//传入数据可以外部读取
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TestCase testCase = mapper.readValue(
                ParamsTest.class.getResourceAsStream("/framework/search.yaml"),
                TestCase.class);
        return Stream.of(testCase);
    }
}