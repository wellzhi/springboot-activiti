package com.dapeng.flow.drool.bean;

import java.io.Serializable;

public class Leave implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String name;
    private Integer day; 			//当前请假天数
    private Integer total = 0;		//总共请假天数
    public Leave(String name, Integer day)
    {
        this.name = name;
        this.day = day;
    }
    public Integer getDay()
    {
        return day;
    }
    public void setDay(Integer day)
    {
        this.day = day;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    @Override
    public String toString()
    {
        return "[name="+name+",day="+day+",total="+total+"]";
    }
}
