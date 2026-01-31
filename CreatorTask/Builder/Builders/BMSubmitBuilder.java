package com.example.bringmanage.CreatorTask.Builder.Builders;

import android.content.Context;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.bringmanage.CreatorTask.BMExceptions.BMException;
import com.example.bringmanage.CreatorTask.DTO.BMDTO;

public class BMSubmitBuilder implements IBMBuilders
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
        this.query.submit.forEach((submit)->
        {
            if(submit.getId().trim().isEmpty() || submit.getValue().trim().isEmpty())
            {
                throw new BMException(BMException.ErrorCode.EMPTY_DTO);
            }
            Button button = new Button(this.context);
            button.setId(View.generateViewId());
            button.setText(submit.getValue());
            button.setTag(submit.getId());
            if(submit.getAction() != null)
            {
                button.setOnClickListener(v -> {
                    Runnable action = submit.getAction();
                    action.run();
                });
            }
            //button.setBackgroundColor(((Submit) this.creator).getColor());
        });
        return container;
    }
}
