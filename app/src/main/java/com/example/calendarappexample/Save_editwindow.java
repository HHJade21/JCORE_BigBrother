package com.example.calendarappexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Save_editwindow extends AppCompatActivity {


    private EditText eventNameET;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_editwindow);
        initWidgets();
    }

    private void initWidgets()
    {
        eventNameET = findViewById(R.id.eventNameET);

    }


    public void onClick_edit(View view)
    {



        finish();
    }



}