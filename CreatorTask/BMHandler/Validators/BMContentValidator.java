package com.example.bringmanage.CreatorTask.BMHandler.Validators;

import android.util.Log;

import com.example.bringmanage.CreatorTask.BMHandler.BMHandler;
import com.example.bringmanage.CreatorTask.BMHandler.IBMHandler;
import com.example.bringmanage.CreatorTask.Builder.Builders.BMContentsBuilder;
import com.example.bringmanage.CreatorTask.Builder.Builders.BMFormDirectorBuilder;
import com.example.bringmanage.CreatorTask.Builder.Builders.BuildersForms.ContentsBuilder;
import com.example.bringmanage.CreatorTask.Builder.Builders.Creator.Contents;
import com.example.bringmanage.CreatorTask.Builder.Builders.IBMBuilders;

import java.util.Arrays;
import java.util.List;

public class BMContentValidator extends BMHandler implements IBMValidator
{

    @Override
    public void handle(List<IBMBuilders> check)
    {
        if(this.query.contents != null)
        {
            BMContentsBuilder builder = new BMContentsBuilder();
            builder.dto(this.query);
            builder.context(this.context);
            check.add(builder);
        }
    }
}
