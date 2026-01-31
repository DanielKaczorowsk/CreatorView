package com.example.bringmanage.CreatorTask.Builder;
import android.content.Context;
import com.example.bringmanage.CreatorTask.Builder.Builders.IBMBuilders;

import android.view.View;
import android.widget.LinearLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.bringmanage.CreatorTask.BMExceptions.BMException;
public class BMDirector
{
    private List<IBMBuilders> builders;
    private LinearLayout layout;
    private Map<IBMBuilders, Object> cache;
    /**
     *@param builders the object have class to array from chains*/
    public void setArrayClass(List<IBMBuilders> builders)
    {
        this.builders = builders;
    }
    /**
     *@param context to create a new view
     * @return LinearLayout create new container to configure in builder*/
    public LinearLayout layout(Context context)
    {
        this.layout = new LinearLayout(context);
        this.layout.setOrientation(LinearLayout.VERTICAL);
        return this.layout;
    }
    /**
     * @return get Array with class builders to examples tests*/
    public List<IBMBuilders> getArrayClass()
    {
        return this.builders;
    }
    /**
     * function build is for create builder which make a view and save to global cache primary class for less weight memory*/
    public LinearLayout build()
    {

        if(this.layout != null)
        {

            this.cache = new HashMap<>();
            for(IBMBuilders builder : this.builders)
            {
                View builtView = builder.build();
                this.layout.addView(builtView);
                this.cache.put(builder,builtView);
            }
        }
        else
        {
            throw new BMException(BMException.ErrorCode.EMPTY_LAYOUT);
        }
        return this.layout;
    }
}
