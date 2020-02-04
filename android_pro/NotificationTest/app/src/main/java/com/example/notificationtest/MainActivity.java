package com.example.notificationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button send=(Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.send:
                        Intent intent = new Intent(MainActivity.this, AlertDetails.class);
                        PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                        //跟intent一樣可以啟動服務 getService()活動 廣播getBroadcast() 會找適當時機 flag有四種型態
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "YOUR_CHANNEL_ID")
                                .setSmallIcon(R.mipmap.ic_launcher) // notification icon
                                .setContentTitle("title") // title for notification
                                .setContentText("content")// message for notification
                                .setAutoCancel(true)// clear notification after click
                                .setStyle(new NotificationCompat.BigTextStyle().bigText("" +
                                        "45554888888888888888888888888888888" +
                                        "8888888888888888888888888888888" +
                                        "88888888888888888888" +
                                        "8888888888888888888888888"))
                                .setPriority(NotificationCompat.PRIORITY_MAX)
                                //LOW 可能縮小 HIGH放大或較高 MAX跳視窗
                                .setContentIntent(pi);
                        manager.notify(1,mBuilder.build());
                        /*setAutoCancel也可以寫成*/
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + v.getId());
                }
            }
        });
    }
}
