package com.example.bringmanage.CreatorTask.Builder.Builders.BuildersForms;

import android.view.View;
import android.widget.EditText;
import android.content.Context;

import com.example.bringmanage.CreatorTask.BMExceptions.BMException;
import com.example.bringmanage.CreatorTask.Builder.Builders.CreatorForms.ICreator;
import com.example.bringmanage.CreatorTask.Builder.Builders.CreatorForms.Inputs;

import android.widget.LinearLayout;

public class InputBuilder implements IFormBuilder
{
    ICreator creator;
    Context context;
    @Override
    public ICreator setObject(Context context ,ICreator creator)
    {
        this.context = context;
        this.creator = creator;
        return this.creator;
    }
    @Override
    public View build()
    {
        if(this.creator instanceof Inputs)
        {
            if(creator.getId().trim().isEmpty())
            {
                throw new BMException(BMException.ErrorCode.EMPTY_DTO);
            }
            EditText edit = new EditText(this.context);
            edit.setId(View.generateViewId());
            edit.setText(this.creator.getValue());
            if(!((Inputs) this.creator).getHintValue().trim().isEmpty())
            {
                edit.setHint(((Inputs) this.creator).getHintValue());
            }
            edit.setTag(((Inputs) this.creator).getId());
            return edit;
        }
        throw new BMException(BMException.ErrorCode.EMPTY_CLASS);
    }

}
