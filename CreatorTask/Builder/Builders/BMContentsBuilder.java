package com.example.bringmanage.CreatorTask.Builder.Builders;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bringmanage.CreatorTask.BMExceptions.BMException;
import com.example.bringmanage.CreatorTask.DTO.BMDTO;

public class BMContentsBuilder implements IBMBuilders
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
    /**
     * build with dto text to view*/
    @Override
    public LinearLayout build()
    {
        LinearLayout container = new LinearLayout(this.context);
        container.setOrientation(LinearLayout.VERTICAL);

        this.query.contents.forEach((contents)->
        {
            if(contents.getValue().trim().isEmpty() || contents.getId().trim().isEmpty())
            {
                throw new BMException(BMException.ErrorCode.EMPTY_DTO);
            }
            TextView text = new TextView(this.context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            if(contents.getMargin() != null)
            {
                params.setMargins(contents.getMargin()[0], contents.getMargin()[1], contents.getMargin()[2], contents.getMargin()[3]);
            }
            text.setLayoutParams(params);
            text.setId(TextView.generateViewId());
            text.setGravity(Gravity.CENTER);
            text.setText(contents.getValue());
            text.setTag(contents.getId());
            container.addView(text);
        });
        return container;
    }
}
