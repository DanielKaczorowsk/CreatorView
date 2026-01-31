package com.example.bringmanage.CreatorTask.Builder.Builders.BuildersForms;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.example.bringmanage.CreatorTask.Builder.Builders.CreatorForms.ICreator;

public interface IFormBuilder
{
    public ICreator setObject(Context context , ICreator creator);
    public View build();
}
