package com.example.bringmanage.CreatorTask.BMHandler.Validators;

import com.example.bringmanage.CreatorTask.BMHandler.BMHandler;
import com.example.bringmanage.CreatorTask.Builder.Builders.BMContentsBuilder;
import com.example.bringmanage.CreatorTask.Builder.Builders.BMFormDirectorBuilder;
import com.example.bringmanage.CreatorTask.Builder.Builders.BMHeaderBuilder;
import com.example.bringmanage.CreatorTask.Builder.Builders.IBMBuilders;

import java.util.List;

public class BMHeaderValidator extends BMHandler implements IBMValidator
{
    @Override
    public void handle(List<IBMBuilders> check)
    {
        if(this.query.header != null)
        {
            BMHeaderBuilder builder = new BMHeaderBuilder();
            builder.dto(this.query);
            builder.context(this.context);
            check.add(builder);
        }
    }
}
