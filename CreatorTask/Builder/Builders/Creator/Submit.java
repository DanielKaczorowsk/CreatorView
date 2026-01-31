package com.example.bringmanage.CreatorTask.Builder.Builders.Creator;
public class Submit
{
    private String id = "";
    private String value = "";
    private Runnable action = null;
    private String color = " ";
    public Submit(String id, String value)
    {
        this.id = id;
        this.value = value;
    }
    public Submit(String id, String value, Runnable action, String color)
    {
        this.id = id;
        this.value = value;
        this.action = action;
        this.color = color;
    }
    public Submit(String id, String value, String color)
    {
        this.id = id;
        this.value = value;
        this.color = color;
    }
    public String getId()
    {
        return this.id;
    }
    public String getValue()
    {
        return this.value;
    }
    public String getColor() { return this.color; }
    public Runnable getAction(){ return this.action; }

}
