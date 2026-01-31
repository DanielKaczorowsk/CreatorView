package com.example.bringmanage.CreatorTask.Factory;
import static com.example.bringmanage.CreatorTask.BMExceptions.BMException.ErrorCode.EMPTY_CLASS;

import android.content.Context;
import android.widget.LinearLayout;

import com.example.bringmanage.CreatorTask.BMExceptions.BMException;
import com.example.bringmanage.CreatorTask.BMHandler.BMHandler;
import com.example.bringmanage.CreatorTask.BMHandler.Validators.BMFormValidator;
import com.example.bringmanage.CreatorTask.BMHandler.Validators.BMHeaderValidator;
import com.example.bringmanage.CreatorTask.BMHandler.Validators.BMContentValidator;
import com.example.bringmanage.CreatorTask.BMHandler.Validators.IBMValidator;
import com.example.bringmanage.CreatorTask.Builder.BMDirector;
import com.example.bringmanage.CreatorTask.Builder.Builders.IBMBuilders;
import com.example.bringmanage.CreatorTask.DTO.BMDTO;

import java.util.ArrayList;
import java.util.List;

public class BMFactory {
    private BMDTO query;
    private final Context context;

    public BMFactory(Context context)
    {
          this.context = context;
    }
    /**
     * set param to dto
     * @param query this is BMDTO which have data to create new view*/
    public void setQuery(BMDTO query){
        this.query = query;
    }
    /**
     *  return to test data transfer object
     * @return my BMDTO example to tests*/
    public BMDTO getQuery(){
        return this.query;
    }
    private List<IBMBuilders> openChain(BMDTO query)
    {
        BMHandler prev = null;
        BMHandler first = null;

        List<BMHandler> handlers = List.of(
                new BMHeaderValidator(),
                new BMContentValidator(),
                new BMFormValidator()
        );

        List<IBMBuilders> results = new ArrayList<>();

        for (BMHandler handler : handlers)
        {
            if (!(handler instanceof IBMValidator))
            {
                throw new BMException(EMPTY_CLASS);
            }

            handler.setQuery(this.query);
            handler.setContext(this.context);
            if (first == null) {
                first = handler;
            }

            if (prev != null) {
                prev.setNext(handler);
            }

            prev = handler;
        }

        return first.check(results);
    }

    public LinearLayout create()
    {
        if(this.query==null)
        {
            throw new BMException(BMException.ErrorCode.EMPTY_DTO);
        }

        List <IBMBuilders> chain = this.openChain(query);
        BMDirector director = new BMDirector();
        director.layout(this.context);
        director.setArrayClass(chain);
        return director.build();
    }
}
