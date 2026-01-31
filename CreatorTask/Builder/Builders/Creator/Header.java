package com.example.bringmanage.CreatorTask.Builder.Builders.Creator;

public class Header
{
    private final String id;
    private final String value;
    /**
     * build with dto header to view*/
    public Header(String id,String value)
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
}
