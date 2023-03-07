package com.qa.data;

/**
 * 类的描述
 *
 * @author LZZ
 * @Date 2023/3/7 09:51
 */
public class userData {
    private String name;
    private String job;
    public userData(String name, String job){
        this.job=job;
        this.name=name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
    public void setJob(String job){
        this.job=job;
    }

    public String getJob(){
        return job;
    }
}
