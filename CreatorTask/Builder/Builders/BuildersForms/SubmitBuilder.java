package com.example.bringmanage.CreatorTask.Builder.Builders.BuildersForms;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.example.bringmanage.CreatorTask.BMExceptions.BMException;
import com.example.bringmanage.CreatorTask.Builder.Builders.CreatorForms.SubmitForm;
import com.example.bringmanage.CreatorTask.Builder.Builders.CreatorForms.ICreator;

public class SubmitBuilder implements IFormBuilder
{
    private Context context;
    private ICreator creator;
    @Override
    public ICreator setObject(Context context, ICreator creator)
    {
        this.context = context;
        this.creator = creator;
        return this.creator;
    }
    @Override
    public View build()
    {
        if(this.creator instanceof SubmitForm)
        {
            if(creator.getValue().trim().isEmpty() || creator.getId().trim().isEmpty())
            {
                throw new BMException(BMException.ErrorCode.EMPTY_DTO);
            }
            Button button = new Button(this.context);
            button.setId(View.generateViewId());
            button.setText(this.creator.getValue());
            button.setTag(this.creator.getId());
            Runnable actions = ((SubmitForm) this.creator).getAction();
            //button.setBackgroundColor(((Submit) this.creator).getColor());
            if(((SubmitForm) this.creator).getAction() != null)
            {
                button.setOnClickListener(v -> actions.run());
            }

            return button;
        }
        throw new BMException(BMException.ErrorCode.EMPTY_CLASS);
    }
}
