package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private CustomReciever customReciever=new CustomReciever();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter=new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction("com.example.Broadcast.ACTION_SEND_NUMBER");
        this.registerReceiver(customReciever,filter);
        Random r  = new Random();
        int n=r.nextInt(20);
        String y = Integer.toString(n);
        Intent intent =new Intent("com.example.Broadcast.ACTION_SEND_NUMBER");
        intent.putExtra("extra",y);
        sendBroadcast(intent);
        LocalBroadcastManager.getInstance(this).registerReceiver(
                customReciever,new IntentFilter("com.example.Broadcast.ACTION_CUSTOM_BROADCAST"));
    }

    @Override
    protected void onDestroy() {
        this.unregisterReceiver(customReciever);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(customReciever);
        super.onDestroy();
    }

    public void sendCustomBroadcast(View view) {
//        Intent custom=new Intent("com.example.Broadcast.ACTION_CUSTOM_BROADCAST");
//        LocalBroadcastManager.getInstance(this).sendBroadcast(custom);

    }
}
