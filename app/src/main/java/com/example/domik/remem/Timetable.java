package com.example.domik.remem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.provider.CalendarContract.Events;
import android.widget.ImageButton;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;


public class Timetable extends Activity {
    CalendarView calendarView;
    ImageButton addEventButton, size, add, account;
    ListView Listview;
    TextView event_titleTextView, event_descriptionTextView;
    Events events;


    @Override
    protected void onCreate (Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_calendar);


        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Timetable.this, Profile.class));
            }

        });

    }

    /*public void addEvent (View view) {
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

    }*/

    public static ArrayList<String> nameOfEvent = new ArrayList<String>();
    public static ArrayList<String> startDates = new ArrayList<String>();
    public static ArrayList<String> endDates = new ArrayList<String>();
    public static ArrayList<String> descriptions = new ArrayList<String>();

    public static ArrayList<String> readCalendarEvent (Context context) {
        Cursor cursor = context.getContentResolver()
                .query(Uri.parse("content://com.android.calendar/events"),
                        new String[]{"calendar_id", "title", "description", "dtstart", "dtend", "eventLocation"},null,null,null);
        cursor.moveToFirst();
        String CNames[] = new String[cursor.getCount()];


        nameOfEvent.clear();
        startDates.clear();
        endDates.clear();
        descriptions.clear();
        for (int i = 0; i< CNames.length; i++) {

            nameOfEvent.add(cursor.getString(1));
            startDates.add(getDate(Long.parseLong(cursor.getString(3).trim())));
            endDates.add(getDate(Long.parseLong(cursor.getString(4).trim())));
            descriptions.add(cursor.getString(2));
            CNames[i] = cursor.getString(1);
            cursor.moveToNext();
        }
        return nameOfEvent;
    }

    public static String getDate(long milliSeconds){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }
}
