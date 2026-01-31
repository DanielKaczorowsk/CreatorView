package com.example.bringmanage.CreatorTask.Builder.Builders.CreatorForms;

public class Inputs implements ICreator
{
    private String id ="";
    private String value = "";
    private String hintValue = "";
    public Inputs(String id,String value,String hintValue)
    {
        this.id = id;
        this.value = value;
        this.hintValue = hintValue;
    }
    public Inputs(String id,String value)
    {
        this.id = id;
        this.value = value;
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
    public String getHintValue()
    {
        return this.hintValue;
    }
}
