package com.myaplication.goangkot404bnf.Notification;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.myaplication.goangkot404bnf.R;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private static final int NOTIFICATION_ID = 0;
    TextView mTextView;
    private NotificationManager mNotificationManager;
    public static final String channelID = "channelID";
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Intent intent = new Intent(this, com.myaplication.goangkot404bnf.Notification.AlarmReceiver.class);
        boolean alarmUp = (PendingIntent.getBroadcast(this, NOTIFICATION_ID,
                intent, PendingIntent.FLAG_NO_CREATE) != null);

        Button buttonTimePicker = findViewById(R.id.button_timepicker);

        buttonTimePicker.setClickable(alarmUp);
        buttonTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new com.myaplication.goangkot404bnf.Notification.TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        Button buttonCancelAlarm = findViewById(R.id.button_cancel);
        buttonCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
                Toast.makeText(AlarmActivity.this, "Notification Di Batalkan",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);
//        updateTimeText(c);
        startAlarm(c);
    }


    private void startAlarm(Calendar c) {
        mNotificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(this,
                NOTIFICATION_ID, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        boolean alarmUp = (PendingIntent.getBroadcast(this, NOTIFICATION_ID,
                intent, PendingIntent.FLAG_NO_CREATE) != null);

        Button buttonTimePicker = findViewById(R.id.button_timepicker);

        buttonTimePicker.setClickable(alarmUp);

        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);

        createNotificationChannel();
        Toast.makeText(AlarmActivity.this, "Notification Pengingat Telah Di Atur",
                Toast.LENGTH_SHORT).show();
    }
    private void cancelAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(this,
                NOTIFICATION_ID, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.cancel(pendingIntent);
    }



    public void createNotificationChannel() {

        mNotificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {

            NotificationChannel notificationChannel = new NotificationChannel
                    (PRIMARY_CHANNEL_ID,
                            "Notification Up",
                            NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription
                    ("Alarm Setted");
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
