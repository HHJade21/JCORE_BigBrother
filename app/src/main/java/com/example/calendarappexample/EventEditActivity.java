package com.example.calendarappexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Locale;


public class EventEditActivity extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    private Button dateButton2;
    int is_clicked = 0;
    int pre_hour, pre_minute;
    private EditText eventNameET;
    private EditText eventLocationET;
    private EditText eventNoteET;
    private EditText eventTogetherET;
    private TextView eventDateTV;
    Button btn_work;
    Button btn_social;
    Button btn_hang_out;
    Button btn_anniversary;
    Button btn_assignment;
    Button btn_date;
    Button btn_study;
    Button btn_growth;

    private Button pre_time, next_time;
    private Button pre_date, next_date;

    private Button timeButton;
    private Button timeButton2;
    int hour, minute;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initWidgets();
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton_pre);
        dateButton.setText(getTodaysDate());
        dateButton2 = findViewById(R.id.datePickerButton_next);
        dateButton2.setText(getTodaysDate());
        eventDateTV.setText("Date: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));

        timeButton = findViewById(R.id.timePickerButton_pre);
        timeButton2 = findViewById(R.id.timePickerButton_next);


        btn_work = findViewById(R.id.WorkOut);
        btn_social = findViewById(R.id.Social);
        btn_hang_out = findViewById(R.id.HangOut);
        btn_anniversary = findViewById(R.id.Anniversary);
        btn_assignment = findViewById(R.id.Assignment);
        btn_date = findViewById(R.id.Date);
        btn_study = findViewById(R.id.Study);
        btn_growth = findViewById(R.id.Growth);

        btn_work.setOnClickListener(v -> {
            if (is_clicked == 0) {
                //btn_work.setBackgroundColor(Color.GRAY);
                btn_work.setBackgroundColor(Color.BLACK);
                //btn_work.setTextColor();
                is_clicked = 1;
            } else if (is_clicked == 1) {
                btn_work.setBackgroundColor(Color.BLUE);
                //btn_work.setTextColor();
                is_clicked = 0;
            }
        });
        btn_social.setOnClickListener(v -> {
            if (is_clicked == 0) {
                btn_social.setBackgroundColor(Color.BLACK);
                //btn_work.setTextColor();
                is_clicked = 2;
            } else if (is_clicked == 2) {
                btn_social.setBackgroundColor(Color.BLUE);
                //btn_social.setBackgroundColor(R.color.social);
                is_clicked = 0;
            }
        });
        btn_hang_out.setOnClickListener(v -> {
            if (is_clicked == 0) {
                btn_hang_out.setBackgroundColor(Color.BLACK);
                //btn_work.setTextColor();
                is_clicked = 3;
            } else if (is_clicked == 3) {
                btn_hang_out.setBackgroundColor(Color.BLUE);
                //btn_hang_out.setBackgroundColor(R.color.hang);
                is_clicked = 0;
            }
        });
        btn_anniversary.setOnClickListener(v -> {
            if (is_clicked == 0) {
                btn_anniversary.setBackgroundColor(Color.BLACK);
                //btn_work.setTextColor();
                is_clicked = 4;
            } else if (is_clicked == 4) {
                btn_anniversary.setBackgroundColor(Color.BLUE);
                //btn_anniversary.setBackgroundColor(R.color.anniversary);
                is_clicked = 0;
            }
        });
        btn_assignment.setOnClickListener(v -> {
            if (is_clicked == 0) {
                btn_assignment.setBackgroundColor(Color.BLACK);
                //btn_work.setTextColor();
                is_clicked = 5;
            } else if (is_clicked == 5) {
                btn_assignment.setBackgroundColor(Color.BLUE);
                //btn_assignment.setBackgroundColor(R.color.assignment);
                is_clicked = 0;
            }
        });
        btn_date.setOnClickListener(v -> {
            if (is_clicked == 0) {
                btn_date.setBackgroundColor(Color.BLACK);
                //btn_work.setTextColor();
                is_clicked = 6;
            } else if (is_clicked == 6) {
                btn_date.setBackgroundColor(Color.BLUE);
                //btn_date.setBackgroundColor(R.color.date);
                is_clicked = 0;
            }
        });
        btn_study.setOnClickListener(v -> {
            if (is_clicked == 0) {
                btn_study.setBackgroundColor(Color.BLACK);
                //btn_work.setTextColor();
                is_clicked = 7;
            } else if (is_clicked == 7) {
                btn_study.setBackgroundColor(Color.BLUE);
                //btn_study.setBackgroundColor(R.color.study);
                is_clicked = 0;
            }
        });
        btn_growth.setOnClickListener(v -> {
            if (is_clicked == 0) {
                btn_growth.setBackgroundColor(Color.BLACK);
                //btn_work.setTextColor();
                is_clicked = 8;
            } else if (is_clicked == 8) {
                btn_growth.setBackgroundColor(Color.BLUE);
                //btn_growth.setBackgroundColor(R.color.growth);
                is_clicked = 0;
            }
        });
    }

    public void popTimePicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                pre_hour = selectedHour;
                pre_minute = selectedMinute;
                pre_time.setText(String.format(Locale.getDefault(), "%02d:%02d", pre_hour, pre_minute));
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, pre_hour, pre_minute, true);
    }


    private void initWidgets()
    {
        eventNameET = findViewById(R.id.eventNameET);
        eventDateTV = findViewById(R.id.eventDateTV);
        timeButton = findViewById(R.id.timePickerButton_pre);
        timeButton2 = findViewById(R.id.timePickerButton_next);
    }

    public void saveEventAction(View view)
    {
        String eventName = eventNameET.getText().toString();
        String time_pre = timeButton.getText().toString();
        String time_next = timeButton2.getText().toString();

        Event newEvent = new Event(eventName,time_pre, time_next);
        Event.eventsList.add(newEvent);
        finish();
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month +1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }

    private String makeDateString(int day, int month, int year)
    {
        return getMonthFormat(month) + " "+ day + " " + year;
    }

    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";


        return "JAN";
    }

    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month +1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    public void onClick_predate(View view)
    {
        datePickerDialog.show();
    }

    public void onClick_nextdate(View view)
    {
        datePickerDialog.show();
    }

    public void onClick_pretime(View view)
    {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
        {
            public void onTimeSet(TimePicker timePick, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
            }

        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,AlertDialog.THEME_HOLO_LIGHT, onTimeSetListener, hour, minute, true);

        timePickerDialog.show();
    }

    public void onClick_nexttime(View view)
    {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
        {
            public void onTimeSet(TimePicker timePick, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                timeButton2.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
            }

        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,AlertDialog.THEME_HOLO_LIGHT, onTimeSetListener, hour, minute, true);

        timePickerDialog.show();
    }


}