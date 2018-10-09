package com.solution.transport.transport_solution;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePickerDialog picker;
    EditText eText,eTExt2;
    Button btnGet;
    final Calendar cldr = Calendar.getInstance();
    int day= cldr.get(Calendar.DAY_OF_MONTH);
    int month = cldr.get(Calendar.MONTH);
    int year = cldr.get(Calendar.YEAR);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eText=(EditText) findViewById(R.id.editText1);
        eTExt2=(EditText) findViewById(R.id.editText2);
        btnGet = findViewById(R.id.button1);


//        Set OnClick Listener for DateFrom
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDateFrom();
            }
        });

//        Set OnClick Listeer for dateto
        eTExt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDateTo();
            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondPage.class
                ));
            }
        });

    }

//    Method for selecting date for dateFrom
    public void selectDateFrom(){
        // date picker dialog
        picker = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
//                        eTExt2.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, day);
        picker.show();
    }

//    Selecting date for pickup date DateTo
    public void selectDateTo(){
        // date picker dialog
        picker = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                        eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        eTExt2.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, day);
        picker.show();

    }
}