package com.pagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactPage extends BasePage {
    //po原则2 不要暴露页面内部实现细节
    private By parterInfo=By.cssSelector(".js_party_info");

    public ContactPage(WebDriver driver) {
        //保存driver到自己的实例
        super(driver);
    }

    //po原则6 添加成功的时候与添加失败返回的页面是不同，需要封装为不同的方法
    public ContactPage addMember(String username, String acctid, String mobile){
        return this;
    }

    //po原则6 添加失败返回的页面是不同，需要封装为不同的方法
    public ContactPage addMemberFail(String username, String acctid, String mobile){
        return this;
    }

    //po原则5 不要实现所有的方法，按需封装
    public ContactPage searchDepart(String departName){
        //po原则1 用公共方法代表页面所提供的功能
        //po原则3  通常不要在po方法内添加断言
        sendKeys(By.id("memberSearchInput"), departName);
        String content = driver.findElement(parterInfo).getText();
        System.out.println(content);
        click(By.cssSelector(".ww_icon_AddMember"));
        return this;
    }

    public String getPartyInfo(){
        //
        String content = driver.findElement(parterInfo).getText();
        System.out.println(content);
        return content;
    }

    public ContactPage addDepart(String departName) {
//        todo: 添加部门

//        click(By.cssSelector("#js_contacts344 > div > div.member_colLeft > div > div.member_colLeft_top.member_colLeft_top_BorderBottom > a > i"));
//        click(By.cssSelector(".member_colLeft_top_addBtn"));
        click(By.linkText("添加"));
        click(By.linkText("添加部门"));
        sendKeys(By.name("name"), departName);
        click(By.linkText("选择所属部门"));
        driver.findElements(By.linkText("尹侦测试账号")).get(1).click();
        click(By.linkText("确定"));
        return this;
    }

    public ContactPage addMemberToDepart(String name,String id,String phone) throws InterruptedException {
        Thread.sleep(2);
        click(By.linkText("添加成员"));
        sendKeys(By.name("username"), name);
        sendKeys(By.name("acctid"), id);
        sendKeys(By.name("mobile"), phone);
        click(By.xpath("//input[@class=\"ww_checkbox\"and@name=\"sendInvite\"]"));
        click(By.linkText("保存"));

        return this;
    }

    public ContactPage deleteMemberToDepart(String name){
        click(By.linkText(name));
        click(By.linkText("删除"));
        click(By.linkText("确认"));
        return this;
    }

    public ContactPage deleteDepart(String departName){
        click(By.xpath("'//span[@class=\"ww_commonImg ww_commonImg_ClearText ww_searchInput_delete\"]'"));
        click(By.linkText(departName));
        click(By.xpath("//a[contains(text(),\"部门qitest\")]/span"));
        click(By.linkText("确定"));

        return this;


    }


    public void clearAllDeparts(){
        searchDepart("定向班四期");
        //todo: 删除所有的成员
        //todo: 所有的部门
    }
}
