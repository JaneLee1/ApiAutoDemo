package com.qa.restClient;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * //本类中包含post、get、put、delete请求方法
 *
 * @author LZZ
 * @Date 2023/3/6 15:25
 */
public class ResClient {
    //1.get请求，不带请求头
    public CloseableHttpResponse getApi(String url) throws IOException {
        //新建一个可以关闭的httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //新建get对象
        HttpGet get =new HttpGet(url);
        //执行get请求，储存返回的相应
        CloseableHttpResponse httpResponse=httpclient.execute(get);
        return httpResponse;

    }

    //2.get请求，带有请求头，方法重载
    public CloseableHttpResponse getApi(String url, HashMap<String,String> headermap) throws IOException {
        CloseableHttpClient httpClient=HttpClients.createDefault();
        HttpGet httpget =new HttpGet(url);
        //加载请求头到Http中
        for(Map.Entry<String,String> entry:headermap.entrySet()){
            httpget.addHeader(entry.getKey(), entry.getValue());
        }

        CloseableHttpResponse httpResponse =httpClient.execute(httpget);

        return httpResponse;
    }
    //3.post请求
    public CloseableHttpResponse postApi (String url,String entitystring,HashMap<String,String> headermap)throws IOException{
        CloseableHttpClient httpClient =HttpClients.createDefault();
        HttpPost httppost=new HttpPost(url);
        //设置payload
        httppost.setEntity(new StringEntity(entitystring));
        //加载请求头到httppost
        for(Map.Entry<String,String> entry : headermap.entrySet()){
            httppost.addHeader(entry.getKey(),entry.getValue());
        }
        //发送post请求
        CloseableHttpResponse httpResponse=httpClient.execute(httppost);
        return httpResponse;
    }

}
