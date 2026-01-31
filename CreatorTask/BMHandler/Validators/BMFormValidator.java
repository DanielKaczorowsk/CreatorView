package com.example.bringmanage.CreatorTask.BMHandler.Validators;

import com.example.bringmanage.CreatorTask.BMHandler.BMHandler;
import com.example.bringmanage.CreatorTask.Builder.Builders.BMFormDirectorBuilder;
import com.example.bringmanage.CreatorTask.Builder.Builders.IBMBuilders;

import java.util.List;

public class BMFormValidator extends BMHandler implements IBMValidator
{
    @Override
    public void handle(List<IBMBuilders> check)
    {
        if(this.query.form != null)
        {
            BMFormDirectorBuilder builder = new BMFormDirectorBuilder();
            builder.dto(this.query);
            builder.context(this.context);
            check.add(builder);
        }
    }
}
