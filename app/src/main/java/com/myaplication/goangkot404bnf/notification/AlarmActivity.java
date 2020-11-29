package com.myaplication.goangkot404bnf.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

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
import java.util.Calendar;
import com.myaplication.goangkot404bnf.R;


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

        Intent intent = new Intent(this, AlarmReceiver.class);
        boolean alarmUp = (PendingIntent.getBroadcast(this, NOTIFICATION_ID,
                intent, PendingIntent.FLAG_NO_CREATE) != null);

        Button buttonTimePicker = findViewById(R.id.button_timepicker);

        buttonTimePicker.setClickable(alarmUp);
        buttonTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        Button buttonCancelAlarm = findViewById(R.id.button_cancel);
        buttonCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
                Toast.makeText(AlarmActivity.this, "Alarm telah dibatalkan",
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
 /*   private void updateTimeText(Calendar c) {
        String timeText = "Alarm set for: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());
        mTextView.setText(timeText);
    }

  */


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
        Toast.makeText(AlarmActivity.this, "Alarm telah diset",
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
                            "Notifikasi muncul",
                            NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription
                    ("Alarm akan diset setiap 24 jam");
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }
}

   /* private void startalarm(final Calendar c){

        mNotificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        ToggleButton alarmToggle = findViewById(R.id.alarmToggle);

        Intent notifyIntent = new Intent(this, AlarmReceiver.class);

        boolean alarmUp = (PendingIntent.getBroadcast(this, NOTIFICATION_ID,
                notifyIntent, PendingIntent.FLAG_NO_CREATE) != null);
        alarmToggle.setChecked(alarmUp);

        final PendingIntent notifyPendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_ID, notifyIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

        final AlarmManager alarmManager = (AlarmManager) getSystemService
                (ALARM_SERVICE);

        alarmToggle.setOnCheckedChangeListener
                (new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged
                            (CompoundButton buttonView, boolean isChecked) {
                        String toastMessage = "lol";
                        if (isChecked) {

                            if (alarmManager != null) {
                                alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME,
                                        c.getTimeInMillis(), 60000, notifyPendingIntent );

                            }
                            toastMessage = "getString(R.string.stand_up_alarm_on";
                            }

                         Toast.makeText(AlarmActivity.this, toastMessage,
                                 Toast.LENGTH_SHORT).show();
                     }
                });

    }
}
    */
   /* f

    */