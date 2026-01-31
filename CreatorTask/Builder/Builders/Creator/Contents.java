package com.example.bringmanage.CreatorTask.Builder.Builders.Creator;

public class Contents
{
    private final String id;
    private final String value;
    private String color;
    private int margin[];
    public Contents(String id,String value,int margin[],String color)
    {
        this.id = id;
        this.value = value;
        this.margin = margin;
        this.color = color;
    }
    public Contents(String id, String value)
    {
        this.id = id;
        this.value = value;
    }
    public String getId()
    {
        return this.id;
    }
    public String getValue()
    {
        return this.value;
    }
    public int[] getMargin(){return this.margin;}
    public String getColor(){return this.color;}
}
