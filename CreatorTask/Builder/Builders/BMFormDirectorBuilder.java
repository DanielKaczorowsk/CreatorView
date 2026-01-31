package com.example.bringmanage.CreatorTask.Builder.Builders;

import com.example.bringmanage.CreatorTask.Builder.Builders.BuildersForms.ContentsBuilder;
import com.example.bringmanage.CreatorTask.Builder.Builders.BuildersForms.SubmitBuilder;
import com.example.bringmanage.CreatorTask.Builder.Builders.BuildersForms.InputBuilder;
import com.example.bringmanage.CreatorTask.Builder.Builders.BuildersForms.IFormBuilder;
import com.example.bringmanage.CreatorTask.Builder.Builders.CreatorForms.ICreator;
import com.example.bringmanage.CreatorTask.DTO.BMDTO;
import com.example.bringmanage.CreatorTask.DTO.KeyForm;

import java.util.Map;
import java.util.function.Supplier;
import java.util.Objects;
import android.content.Context;

import android.widget.LinearLayout;
public class BMFormDirectorBuilder implements IBMBuilders
{
    private BMDTO query;
    private Context context;

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
     * private function to build from section
     * @param key enum to choose what is a create
     * @param creator interface field to create views
     * @return IFormBuilder class which create form*/
    private IFormBuilder buildForms(KeyForm key,ICreator creator)
    {
        Map<KeyForm, Supplier<IFormBuilder>> formBuilder = Map.of(
                KeyForm.INPUT, InputBuilder::new,
                KeyForm.SUBMIT, SubmitBuilder::new,
                KeyForm.Contents, ContentsBuilder::new
        );
        IFormBuilder builder = Objects.requireNonNull(formBuilder.get(key)).get();
        builder.setObject(this.context,creator);
        return builder;
    }
    /**
     * function which use private function buildForms to create form view
     * */
    @Override
    public LinearLayout build()
    {
        LinearLayout container = new LinearLayout(this.context);
        container.setOrientation(LinearLayout.VERTICAL);
        query.form.forEach((nameForm,objectForm)->
        {
            LinearLayout formContainer = new LinearLayout(this.context);
            formContainer.setOrientation(LinearLayout.VERTICAL);
            objectForm.forEach((keyForm,objectFrom)->
                    objectFrom.forEach((object)->
                    {
                        IFormBuilder form = this.buildForms(keyForm,object);
                        formContainer.addView(form.build());
                    })
            );
            container.addView(formContainer);
        });
        return container;
    }
}
