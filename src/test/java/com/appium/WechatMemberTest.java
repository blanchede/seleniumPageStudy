package com.appium;

import com.hog.page.HomePage;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WechatMemberTest {
    String userName="kqtest001";
    String phone = "15111112222";

    @Order(1)
    @Test
    public void testAddMember(){
        HomePage homePage = new HomePage();
        homePage.contact().addMember(userName, phone);
    }
    @Test
    @Order(2)
    public void testSearchEditMember(){
        HomePage homePage = new HomePage();
        homePage.contact().searchEditMember(userName);
    }

    @Test
    @Order(3)
    public void testSearchDeleteMember(){
        HomePage homePage = new HomePage();
        homePage.contact().deleteMember(userName);
    }


}
