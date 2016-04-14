package com.example.domik.remem;

import java.util.Calendar;


//import android.app.Activity;
import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.provider.CalendarContract.Events;
import android.widget.ImageButton;
import android.widget.CalendarView;
import android.widget.ListView;

public class Timetable extends ActionBarActivity {
    CalendarView calendarView;
    ImageButton addEventButton, size, add, account;
    ListView ListView;


    @Override
    protected void onCreate (Bundle savedInstancestate){
        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_calendar);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        size = (ImageButton) findViewById(R.id.size);
        add = (ImageButton) findViewById(R.id.add);
        account = (ImageButton) findViewById(R.id.account);
        ListView = (ListView) findViewById(R.id.Listview);

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Timetable.this, Profile.class));
            }

        });
    }


    public void addEvent (View view) {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType("vnd.android.cursor.item/event");

        Calendar cal = Calendar.getInstance();
        long startTime = cal.getTimeInMillis();
        long endTime = cal.getTimeInMillis() + 60 + 60 + 1000;

        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);

        intent.putExtra(Events.TITLE, "Title");
        intent.putExtra(Events.DESCRIPTION, "Description");
        intent.putExtra(Events.EVENT_LOCATION, "Location");
        intent.putExtra(Events.RRULE, "FREQ=YEARLY");

        intent.putExtra(Events.ACCESS_LEVEL, Events.ACCESS_PRIVATE);
        intent.putExtra(Events.AVAILABILITY, Events.AVAILABILITY_BUSY);

        startActivity(intent);

    }
}
