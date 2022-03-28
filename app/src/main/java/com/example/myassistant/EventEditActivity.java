package com.example.myassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class EventEditActivity extends AppCompatActivity {

    EditText eventNameET;
    TextView dateTV,timeTV1,timeTV2;
    int hour1,min1,hour2,min2;
    LocalTime StartTime,EndTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initWidgets();
        /// Set the dateView
        dateTV.setText("Date: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        ///Set the view for the time
        timeTV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog tPD=new TimePickerDialog(
                        EventEditActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth ,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                // initialise hours,min
                                hour1=hourOfDay;
                                min1=minute;
                                // Store hours and time in String
                                String time= hour1 +":"+min1;
                                //Initialize 24 hours format
                                SimpleDateFormat f24h= new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date=f24h.parse(time);
                                    SimpleDateFormat f12h= new SimpleDateFormat(
                                            "hh:mm aa"
                                    );
                                    timeTV1.setText(f12h.format(date));
                                }
                                catch (ParseException e){
                                    e.printStackTrace();

                                }
                            }
                        },12,0,false
                );
                //Set transparent background
                tPD.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //display previous selected time
                tPD.updateTime(hour1,min1);
                //Show the dialog
                tPD.show();

            }
        });
        ////////////////////////////////////////////

        timeTV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog tPD=new TimePickerDialog(
                        EventEditActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth ,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                // initialise hours,min
                                hour2=hourOfDay;
                                min2=minute;
                                // Store hours and time in String
                                String time= hour2 +":"+min2;
                                //Initialize 24 hours format
                                SimpleDateFormat f24h= new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date=f24h.parse(time);
                                    SimpleDateFormat f12h= new SimpleDateFormat(
                                            "hh:mm aa"
                                    );
                                    timeTV2.setText(f12h.format(date));
                                }
                                catch (ParseException e){
                                    e.printStackTrace();

                                }
                            }
                        },12,0,false
                );
                //Set transparent background
                tPD.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //display previous selected time
                tPD.updateTime(hour2,min2);
                //Show the dialog
                tPD.show();

            }
        });
        /////

    }

    private void initWidgets()
    {
        eventNameET = findViewById(R.id.event_name);
        timeTV1=findViewById(R.id.tv_timer1);
        timeTV2=findViewById(R.id.tv_timer2);
    }

    public void saveEvent(View view)
    {
        String eventName = eventNameET.getText().toString();
        Event newEvent = new Event(eventName, CalendarUtils.selectedDate, StartTime,EndTime);
        Event.eventsList.add(newEvent);
        finish();
    }
}