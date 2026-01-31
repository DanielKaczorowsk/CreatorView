package com.example.bringmanage.CreatorTask.BMHandler;

import android.content.Context;

import com.example.bringmanage.CreatorTask.BMExceptions.BMException;
import com.example.bringmanage.CreatorTask.Builder.Builders.IBMBuilders;
import com.example.bringmanage.CreatorTask.DTO.BMDTO;

import java.util.List;

abstract public class BMHandler implements IBMHandler
{
    protected BMDTO query;
    protected BMHandler next;
    protected Context context;
    /**
     * function get a object DTO
     * @param query DTO*/
    public void setQuery(BMDTO query)
    {
        this.query = query;
    }
    public void setContext(Context context)
    {
        this.context = context;
    }
    /**
     * get dto with checking is it date from him
     * @return BMDTO*/
    @Override
    public BMDTO getQuery()
    {
        if(this.query == null)
        {
            throw new BMException(BMException.ErrorCode.EMPTY_DTO);
        }
        return this.query;
    }
    /**
     * function check all variant of validator
     * @param handler get a validator*/
    public void setNext(BMHandler handler)
    {
        if(handler == null)
        {
            throw new BMException(BMException.ErrorCode.EMPTY_CLASS);
        }
        this.next = handler;
    }
    /**
     * create and control chain system
     * @param check set builder to array
     * @return IBMBuilders*/
    public List<IBMBuilders> check(List<IBMBuilders> check)
    {
        this.handle(check);
        if(this.next != null)
        {
            this.next.check(check);
        }
        return check;
    }
    abstract protected void handle(List<IBMBuilders> check);
}
