package com.example.bringmanage;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.bringmanage.CreatorTask.BMServices;

public class MainViewModel extends AndroidViewModel
{
    private final BMServices services;

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.services = new BMServices(application);
    }

    public BMServices getServices() {
        return services;
    }
}
