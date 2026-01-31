package com.example.bringmanage.CreatorTask.DTO;
import com.example.bringmanage.CreatorTask.Builder.Builders.Creator.Contents;
import com.example.bringmanage.CreatorTask.Builder.Builders.Creator.Header;
import com.example.bringmanage.CreatorTask.Builder.Builders.CreatorForms.ICreator;
import com.example.bringmanage.CreatorTask.Builder.Builders.Creator.Submit;

import java.util.List;
import java.util.Map;


    public class BMDTO
    {
        public String nameTask = "";
        public Map<String, Map<KeyForm , List<ICreator>>> form;
        public List<Header> header;
        public List<Submit> submit;
        public List<Contents> contents;
    }
