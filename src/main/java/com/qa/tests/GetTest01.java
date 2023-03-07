package com.qa.tests;

import com.alibaba.fastjson.JSONObject;
import com.qa.base.TestBase;
import com.qa.restClient.ResClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * 类的描述
 *
 * @author LZZ
 * @Date 2023/3/6 16:09
 */
public class GetTest01 extends TestBase {
    TestBase testbase;
    ResClient resclient;
    String host;
    String url;
    CloseableHttpResponse response;

    @BeforeClass
    public void setUp() {
        testbase = new TestBase();
        host = testbase.pro.getProperty("HOST"); //读取config.properties里面的host地址
        url = host + "/api/users?page=2";
    }

    @Test
    public void getListUser() throws IOException {
        resclient = new ResClient();
        response = resclient.getApi(url);
        //获取响应内容
        String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
        //创建json对象,把得到的响应字符串序列化成json
        JSONObject responseJson = JSONObject.parseObject(responseString);
        System.out.print("responsejson--->" + responseJson);
        response.close();
        resclient.getApi(url).close();

    }

    @Test
    public void Test01() {
        System.out.println("测试用例1");
    }

    @Test
    public void Test02() {
        System.out.println("测试用例2");
    }

    @Test
    public void Test03() {
        System.out.println("测试用例3");
    }

    @Test(timeOut = 3000)
    public void Test04() throws InterruptedException {
        System.out.println("测试用例4");
        Thread.sleep(1200);

    }
}