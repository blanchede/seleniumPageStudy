package com.pagetest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
*部门测试
 */
public class DepartPOTest{

    private static MainPage main;
    //private static ContactPage contactPage;

    @BeforeAll
    static void beforeAll() throws IOException, InterruptedException {

        main = new MainPage();

//        清理数据
        //main.contact().clearAllDeparts();
        //为什么不放afterAll，如果你的用例中途被停止，teardown是不能保证一定会被执行，下次用例就会因为没清理数据导致失败
    }


    /**
     * 创建部门
     */
    @Test
    @Order(1)
    void testDepartAdd() throws InterruptedException, IOException {
        String departName = "部门qitest";
        assertTrue(main.contact().addDepart(departName).searchDepart(departName).getPartyInfo().contains(departName));
    }
    /**
     * 添加成员
     */

    @Test
    @Order(2)
    //@CsvSource({"qitestname, test0001,15112341234"})
    //@CsvFileSource(resources = "E:\\Java\\study\\teacher\\seleniumJunit5test\\menberInfo.csv",numLinesToSkip = 1)
    void testDepartMemberAdd() throws InterruptedException, IOException {
        //String departName = "部门qitest";
        String name = "qitestname";
        String id = "test001";
        String phone = "15112341234";
        main.contact02().addMemberToDepart(name,id,phone);
    }
    /**
     * 删除部门下的成员
     */
    @Order(3)
    void testDeleteDepartMember() throws InterruptedException{
        String name = "qitestname";
        main.contact02().deleteMemberToDepart(name);

    }


    /**
     * 删除部门
     */
    @Order(4)
    void testDeleteDepart() throws InterruptedException{
        String departName = "部门qitest";
        main.contact02().deleteDepart(departName);

    }
}
