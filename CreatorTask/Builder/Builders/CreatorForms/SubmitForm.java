package com.example.bringmanage.CreatorTask.Builder.Builders.CreatorForms;

public class SubmitForm implements ICreator
{
    private String id = "";
    private String value = " ";
    private Runnable action = null;
    private String color = " ";
    public SubmitForm(String id, String value)
    {
        this.id = id;
        this.value = value;
    }
    public SubmitForm(String id, String value, Runnable action)
    {
        this.id = id;
        this.value = value;
        this.action = action;
    }
    public SubmitForm(String id, String value, Runnable action,String color)
    {
        this.id = id;
        this.value = value;
        this.action = action;
        this.color = color;
    }
    @Override
    public String getId()
    {
        return this.id;
    }
    @Override
    public String getValue()
    {
        return this.value;
    }
    public String getColor() { return this.color; }
    public Runnable getAction(){ return this.action; }
}
