package com.example.bringmanage.CreatorTask.Builder.Builders;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bringmanage.CreatorTask.BMExceptions.BMException;
import com.example.bringmanage.CreatorTask.Builder.Builders.Creator.Header;
import com.example.bringmanage.CreatorTask.DTO.BMDTO;

public class BMHeaderBuilder implements IBMBuilders
{
    Context context;
    BMDTO query;
    @Override
    public Context context(Context context)
    {
        this.context = context;
        return this.context;
    }

    @Override
    public BMDTO dto(BMDTO query)
    {
        this.query = query;
        return this.query;
    }

    @Override
    public LinearLayout build()
    {
        LinearLayout container = new LinearLayout(this.context);
        container.setOrientation(LinearLayout.VERTICAL);
        this.query.header.forEach((header)->
        {
            if(header.getId().trim().isEmpty() || header.getValue().trim().isEmpty())
            {
                throw new BMException(BMException.ErrorCode.EMPTY_DTO);
            }
            TextView text = new TextView(this.context);
            text.setId(TextView.generateViewId());
            text.setTextSize(24);
            text.setTypeface(null, Typeface.BOLD);
            text.setGravity(Gravity.CENTER);
            text.setText(header.getValue());
            text.setTag(header.getId());
            container.addView(text);
        });
        return container;
    }
}
