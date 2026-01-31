package com.example.bringmanage.CreatorTask.Builder.Builders.CreatorForms;

public class Contents implements ICreator
{
    private final String id;
    private final String value;
    Contents(String id, String value)
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
}
