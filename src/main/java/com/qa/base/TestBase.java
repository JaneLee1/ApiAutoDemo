package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 新建测试基类，此类为所有测试类的父类
 *
 * @author LZZ
 * @Date 2023/3/6 15:08
 */
public class TestBase {
    //新建测试基类，此类为所有测试类的父类
    public Properties pro;
    //读取配置文件，把读取配置文件的操作卸载构造方法中
    public TestBase(){
        pro =new Properties();
        try{
            FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
            pro.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
