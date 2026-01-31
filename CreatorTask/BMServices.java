package com.example.bringmanage.CreatorTask;
import android.content.Context;
import android.widget.LinearLayout;

import com.example.bringmanage.CreatorTask.BMExceptions.BMException;
import com.example.bringmanage.CreatorTask.Builder.Builders.Creator.Contents;
import com.example.bringmanage.CreatorTask.Builder.Builders.Creator.Header;
import com.example.bringmanage.CreatorTask.Builder.Builders.Creator.Submit;
import com.example.bringmanage.CreatorTask.Builder.Builders.CreatorForms.ICreator;
import com.example.bringmanage.CreatorTask.Builder.Builders.CreatorForms.Inputs;
import com.example.bringmanage.CreatorTask.Builder.Builders.CreatorForms.SubmitForm;
import com.example.bringmanage.CreatorTask.DTO.BMDTO;
import com.example.bringmanage.CreatorTask.DTO.KeyForm;
import com.example.bringmanage.CreatorTask.Factory.BMFactory;

import java.util.ArrayList;
import java.util.HashMap;


public final class BMServices
{
    private BMDTO query;
    private ArrayList<ICreator> inputs;
    private ArrayList<ICreator> buttons;
    private final Context context;
    /**
     *@param context Environment to create view*/
    public BMServices(Context context)
    {
        this.context = context;
    }
    /**
     *create object dto and reset*/
    public void reset()
    {
        query = new BMDTO();
    }
    /**
     * function which create a new Task
     * @param task name your task
     * @return BMServices this create a DTO*/
    public BMServices nameTask(String task) {
        this.reset();
        query.nameTask = task;
        return this;
    }
    /**
     * @param form set name to form
     *@return BMServices create form and set name his*/
    public BMServices nameForm(String form)
    {
        query.form = new HashMap<>();
        query.form.put(form, new HashMap<>());
        return this;
    }
    /**
     * @param nameForm choose the form by name
     * @param nameInput set index index/name input
     * @param value set value input
     * @param hintValue set hint value input
     *@return BMServices set data to primary view input in forms*/
    public BMServices addInputForm(String nameForm,String nameInput,String hintValue,String value)
    {
        if(this.inputs == null)
        {
            this.inputs = new ArrayList<>();
        }
        ICreator input = new Inputs(nameInput,value,hintValue);
        this.inputs.add(input);
        query.form
                .computeIfAbsent(nameForm, k -> new HashMap<>())
                .put(KeyForm.INPUT, this.inputs);
        return this;
    }
    public BMServices addInputForm(String nameForm,String nameInput,String hintValue)
    {

        if(this.inputs == null)
        {
            this.inputs = new ArrayList<>();
        }
        ICreator input = new Inputs(nameInput,hintValue);
        this.inputs.add(input);
        query.form
                .computeIfAbsent(nameForm, k -> new HashMap<>())
                .put(KeyForm.INPUT, this.inputs);
        return this;
    }
    /**
     * @param nameForm choose the form by name
     * @param nameButton set index index/name button
     * @param labelButton set value name button
     * @param action set action
     * @param color set color button
     *@return BMServices set data to primary view button in forms*/
    public BMServices addButtonForm(String nameForm , String nameButton,String labelButton,Runnable action,String color)
    {
        if(this.buttons == null)
        {
            this.buttons = new ArrayList<>();
        }
        ICreator button = new SubmitForm(nameButton,labelButton,action,color);
        buttons.add(button);
        query.form
                .computeIfAbsent(nameForm, k -> new HashMap<>())
                .put(KeyForm.SUBMIT, buttons);
        return this;
    }
    public BMServices addButtonForm(String nameForm , String nameButton,String labelButton,Runnable action)
    {
        if(this.buttons == null)
        {
            this.buttons = new ArrayList<>();
        }
        ICreator button = new SubmitForm(nameButton,labelButton,action);
        buttons.add(button);
        query.form
                .computeIfAbsent(nameForm, k -> new HashMap<>())
                .put(KeyForm.SUBMIT, buttons);
        return this;
    }
    public BMServices addButtonForm(String nameForm , String nameButton,String labelButton)
    {
        if(this.buttons == null)
        {
            this.buttons = new ArrayList<>();
        }
        ICreator button = new SubmitForm(nameButton,labelButton);
        buttons.add(button);
        query.form
                .computeIfAbsent(nameForm, k -> new HashMap<>())
                .put(KeyForm.SUBMIT, buttons);
        return this;
    }
    /**
     * @param nameButton set index index/name button
     * @param labelButton set value name button
     * @param action set action
     * @param color set color button
     *@return BMServices set data to primary view button*/
    public BMServices addButton(String nameButton,String labelButton,Runnable action,String color)
    {
        Submit submit = new Submit(nameButton,labelButton);
        if(query.submit == null)
        {
            query.submit = new ArrayList<>();
        }
        query.submit.add(submit);
        return this;
    }
    public BMServices addButton(String nameButton,String labelButton,Runnable action)
    {
        Submit submit = new Submit(nameButton,labelButton);
        if(query.submit == null)
        {
            query.submit = new ArrayList<>();
        }
        query.submit.add(submit);
        return this;
    }
    public BMServices addButton(String nameButton,String labelButton)
    {
        Submit submit = new Submit(nameButton,labelButton);
        if(query.submit == null)
        {
            query.submit = new ArrayList<>();
        }
        query.submit.add(submit);
        return this;
    }
    /*public BMServices addListForm(String nameForm , String nameList)
    {
        query.form
                .computeIfAbsent(nameForm , k->new HashMap<>())
                .put(nameList, new HashMap<>(list).toString());
        return this;
    }*/
    /*public BMServices formCheck(String nameForm , String nameCheck,String type)
    {
        query.form
                .computeIfAbsent(nameForm , k->new HashMap<>()).put(nameCheck,type);
        return this;
    }*/
    /*public BMServices check(String nameForm ,String nameList, Map<String,String> list)
    {
        query.form.computeIfAbsent(nameForm, k->new HashMap<>())
                .computeIfPresent(nameList,(k,v)->new HashMap<>(list)
                        .toString());
        return this;
    }*/
    /**
     * Object whose have fields to create headers
     * @param nameHeader set index index/name header
     * @param valueHeader set value header
     *@return BMServices set data to primary view header*/
    public BMServices header(String nameHeader , String valueHeader, int[] margin)
    {
        Header header = new Header(nameHeader,valueHeader);
        if(query.header == null)
        {
            query.header = new ArrayList<>();
        }
        query.header.add(header);
        return this;
    }
    public BMServices header(String nameHeader , String valueHeader)
    {
        Header header = new Header(nameHeader,valueHeader);
        if(query.header == null)
        {
            query.header = new ArrayList<>();
        }
        query.header.add(header);
        return this;
    }
    /**
     * Object whose have fields to create text
     * @param nameText set index index/name text
     * @param valueText set value text
     * @param margin set margins in contents
     * @param colorText set text color
     *@return BMServices set data to primary view text*/
    public BMServices contents(String nameText, String valueText, int[] margin, String colorText)
    {
        if(margin == null || margin.length < 4)
        {
            throw new BMException(BMException.ErrorCode.ARG_ARRAY);
        }
        Contents contents = new Contents(nameText,valueText,margin,colorText);
        if(query.contents == null)
        {
            query.contents = new ArrayList<>();  // initialize if null
        }
        query.contents.add(contents);
        return this;
    }
    public BMServices contents(String nameText, String valueText,int[] margin)
    {
        ArrayList<Contents> textArray = new ArrayList<>();
        Contents contents = new Contents(nameText,valueText);
        textArray.add(contents);
        query.contents = textArray;
        return this;
    }
    public BMServices contents(String nameText, String valueText)
    {
        ArrayList<Contents> textArray = new ArrayList<>();
        Contents contents = new Contents(nameText,valueText);
        textArray.add(contents);
        query.contents = textArray;
        return this;
    }
    public LinearLayout get()
    {
        BMFactory factory = new BMFactory(this.context);
        factory.setQuery(this.query);
        return factory.create();
    }
}
