package com.example.bringmanage.CreatorTask.Builder.Builders.BuildersForms;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bringmanage.CreatorTask.BMExceptions.BMException;
import com.example.bringmanage.CreatorTask.Builder.Builders.CreatorForms.ICreator;
import com.example.bringmanage.CreatorTask.Builder.Builders.CreatorForms.Contents;

public class ContentsBuilder implements IFormBuilder
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
    public View build() {

        if(this.creator instanceof Contents)
        {
            if(creator.getValue().trim().isEmpty() || creator.getValue().trim().isEmpty())
            {
                throw new BMException(BMException.ErrorCode.EMPTY_DTO);
            }
            TextView text = new TextView(this.context);
            text.setId(TextView.generateViewId());
            text.setText(this.creator.getValue());
            text.setTag(this.creator.getId());
            return text;
        }
        throw new BMException(BMException.ErrorCode.EMPTY_CLASS);
    }
}
