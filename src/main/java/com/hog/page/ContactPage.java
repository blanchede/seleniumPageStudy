package com.hog.page;

import com.hog.core.AppBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ContactPage extends AppBasePage {
    public ContactPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


    /**
     * 新建成员元素
     */
    @AndroidFindBy(id = "i6i")
    private WebElement addMemberBtn01;

    @AndroidFindBy(xpath = "//*[@text=\"添加成员\"]")
    private WebElement addMemberBtn;

    @AndroidFindBy(xpath = "//*[@text=\"手动输入添加\"]")
    private WebElement manuallyAddBtn;

    @AndroidFindBy(xpath = "//*[@text=\"姓名　\"]/..//*[@resource-id=\"com.tencent.wework:id/b4t\"]")
    private WebElement name;

    @AndroidFindBy(id = "com.tencent.wework:id/fow")
    private WebElement phone;

    @AndroidFindBy(uiAutomator = "resourceId(\"com.tencent.wework:id/b5m\").text(\"设置部门\")")
    private WebElement setDepartBtn;

    @AndroidFindBy(xpath = "//*[@text=\"部门ID2\"]/../../..//*[@resource-id=\"com.tencent.wework:id/gsi\"]")
    private WebElement childDepart;

    @AndroidFindBy(id = "com.tencent.wework:id/gsh")
    private WebElement confirmBtn;

    @AndroidFindBy(id = "com.tencent.wework:id/i6k")
    private WebElement saveBtn;

    @AndroidFindBy(id = "com.tencent.wework:id/i63")
    private WebElement backBtn;

    /**
     * 搜索成员元素
     */
    @AndroidFindBy(id = "com.tencent.wework:id/i6n")
    private WebElement searchBtn;

    @AndroidFindBy(id = "com.tencent.wework:id/gpg")
    private WebElement searchInput;

    @AndroidFindBy(id = "com.tencent.wework:id/dns")
    private WebElement searchResult;

    /**
     * 编辑成员元素
     */
    @AndroidFindBy(id = "com.tencent.wework:id/i6d")
    private WebElement selectBtn;

    @AndroidFindBy(id = "com.tencent.wework:id/b_x")
    private WebElement editBtn;

    @AndroidFindBy(id = "com.tencent.wework:id/elq")
    private WebElement genderSelect;

    @AndroidFindBy(xpath = "//*[@text=\"男\"]")
    private WebElement manSelect;

    @AndroidFindBy(xpath = "//*[@text=\"删除成员\"]")
    private WebElement deleteMemberBtn;

    @AndroidFindBy(id = "com.tencent.wework:id/blx")
    private WebElement confirmDeleteBtn;



    /**
     * 添加成员
     * @param username	用户名
     * @param userPhone		手机号
     * @return	ContactPage
     */
    public ContactPage addMember(String username, String userPhone){
        click(addMemberBtn01);
        click(addMemberBtn);
        click(manuallyAddBtn);
        inputText(name, username);
        inputText(phone, userPhone);
        click(setDepartBtn);
        click(childDepart);
        click(confirmBtn);
        click(saveBtn);
        return this;
    }
    /**
     * 搜索后编辑成员
     * @param searchName 用户名
     */
    public ContactPage searchEditMember(String searchName){
        click(searchBtn);
        inputText(searchInput, searchName);
        click(searchResult);
        click(selectBtn);
        click(editBtn);
        click(genderSelect);
        click(manSelect);
        click(saveBtn);
        return this;
    }


    /**
     * 删除成员
     * @param searchName 用户名
     */
    public ContactPage deleteMember(String searchName){
        click(searchBtn);
        inputText(searchInput, searchName);
        click(searchResult);
        click(selectBtn);
        click(editBtn);
        click(deleteMemberBtn);
        click(confirmDeleteBtn);

        return this;
    }


}
