package com.example.bringmanage;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.bringmanage.CreatorTask.BMServices;

public class MainActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        BMServices services = viewModel.getServices();

        LinearLayout container = findViewById(R.id.mainContainer);
        LinearLayout dynamicLayout = services.nameTask("First")
                .header("contentHeader","ManageTask",new int[]{0, 15, 0,15})
                .contents("contentText","Aplikacja do zarzadzania zadaniami", new int[]{0, 15, 0,15},"Black")
                .nameForm("formFirst").addInputForm("formFirst","inputFirst","","Dodaj nowe zadanie ...")
                .addButtonForm("formFirst","contentSubmit","Dodaj")
                .get();

        container.addView(dynamicLayout);
    }


}
