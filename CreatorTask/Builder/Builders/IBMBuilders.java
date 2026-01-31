package com.example.bringmanage.CreatorTask.Builder.Builders;
import android.content.Context;
import android.widget.LinearLayout;

import com.example.bringmanage.CreatorTask.DTO.BMDTO;

public interface IBMBuilders
{
    public Context context(Context context);

    public BMDTO dto(BMDTO query);
    public LinearLayout build();
}
