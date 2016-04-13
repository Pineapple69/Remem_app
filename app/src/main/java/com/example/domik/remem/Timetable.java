package com.example.domik.remem;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import java.util.Calendar;
import android.provider.CalendarContract.Events;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ListView;

public class Timetable extends Activity {

    CalendarView calendarView;
    ImageButton addEventButton, size, add, account;
    ListView ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        addEventButton = (ImageButton) findViewById(R.id.addEventButton);
        size = (ImageButton) findViewById(R.id.size);
        add = (ImageButton) findViewById(R.id.add);
        account = (ImageButton) findViewById(R.id.account);
        ListView = (ListView) findViewById(R.id.Listview);

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Timetable.this, Profile.class));
            }
        });
    }

    /*public void onAddEventClicked(View view) {
        Calendar onAddEventClicked = Calendar.getInstance();
        Intent i = new Intent(Intent.ACTION_EDIT);
        i.setType("vnd.android.cursor.item/event");
        i.putExtra("beginTime", onAddEventClicked.getTimeInMillis());
        i.putExtra("allDay", true);
        i.putExtra("rule", "FREQ=YEARLY");
        i.putExtra("endTime", onAddEventClicked.getTimeInMillis() + 60 * 60 * 1000);
        i.putExtra("title", "Sample Calender Event Android Application");
        startActivity(i);
    }*/
}
