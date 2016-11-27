package com.tpccina.tpcclesson05;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class ImplicitActivity extends AppCompatActivity {

    private static final String LOG_TAG = ImplicitActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button alarmButton = (Button) findViewById(R.id.alarm_button);

        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, "Alarm Test")
                        .putExtra(AlarmClock.EXTRA_HOUR, 3)
                        .putExtra(AlarmClock.EXTRA_MINUTES, 30);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        Button timerButton = (Button) findViewById(R.id.timer_button);
        timerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, "Timer Test")
                        .putExtra(AlarmClock.EXTRA_LENGTH, 10)
                        .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
            }
        });

        Button calendarButton = (Button) findViewById(R.id.calendar_button);

        final Calendar beginTime = Calendar.getInstance();
        beginTime.set(Calendar.YEAR, 2016 );
        beginTime.set(Calendar.MONTH, 9);
        beginTime.set(Calendar.DATE, 31);

        final Calendar endTime = Calendar.getInstance();
        endTime.set(Calendar.YEAR, 2016);
        endTime.set(Calendar.MONTH, 10);
        endTime.set(Calendar.DATE, 4);

        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.Events.TITLE, "Android Dev Contest")
                        .putExtra(CalendarContract.Events.EVENT_LOCATION, "Telkom")
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime)
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime);
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_implicit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
