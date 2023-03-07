package com.qa.tests;

import com.alibaba.fastjson.JSON;
import com.qa.base.TestBase;
import com.qa.data.userData;
import com.qa.restClient.ResClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

/**
 * 类的描述
 *
 * @author LZZ
 * @Date 2023/3/7 09:31
 */
public class PostTest {
TestBase testbase;
ResClient resclient;
String Host;
String url;
CloseableHttpResponse response;
@BeforeClass
public void SetUp(){
    testbase=new TestBase();
    Host=testbase.pro.getProperty("HOST");
    url=Host+"/api/users";
    }

@Test
 public void postCreate() throws IOException {
    resclient=new ResClient();
    //准备请求头信息
    HashMap<String,String> headerMap=new HashMap<String,String>();
    headerMap.put("Content-Type","application/json");

    //实例化数据对象，将其转换成json格式
    userData userData=new userData("morpheus","leader");
    String dataJsonString = JSON.toJSONString(userData);
    //post请求
    response=resclient.postApi(url,dataJsonString,headerMap);
    //得到响应并输出
    String responseString = EntityUtils.toString(response.getEntity());
    System.out.print("response---->"+responseString);


 }
}
