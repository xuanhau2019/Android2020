package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    TextView txtDate;
    Button btnDatePickerDialog,btnTimePicker,btnChronometer,btnAnalogClock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDate = findViewById(R.id.txtDate);
        btnDatePickerDialog = findViewById(R.id.btnDatePickerDialog);
        btnTimePicker = findViewById(R.id.btnTimePicker);
        btnChronometer = findViewById(R.id.btnChronometer);
        btnAnalogClock = findViewById(R.id.btnAnalogClock);

        btnDatePickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        txtDate.setText((day+1) +""+(month+1) +""+ year);
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,onDateSetListener,2020,8,7);
                datePickerDialog.setTitle("My DateTime Picker");
                datePickerDialog.show();
            }
        });
        btnTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        txtDate.setText((hour) +"h"+(minute) +"p /"+ timePicker.getCurrentHour()+timePicker.getCurrentMinute());
                    }
                };
                TimePickerDialog datePickerDialog = new TimePickerDialog(MainActivity.this,onTimeSetListener,7,44,true);
                datePickerDialog.setTitle("My DateTime Picker");
                datePickerDialog.show();
            }
        });
        btnChronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chronometer chronometer = new Chronometer(MainActivity.this);
                ((LinearLayout)findViewById(R.id.mylayout)).addView(chronometer);
            }
        });
        btnAnalogClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnalogClock analogClock = new AnalogClock(MainActivity.this);
                ((LinearLayout)findViewById(R.id.mylayout)).addView(analogClock);
            }
        });
    }
}