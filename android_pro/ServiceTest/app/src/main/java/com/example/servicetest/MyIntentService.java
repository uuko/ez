package com.example.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {
    public MyIntentService(){
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("try", "onHandleIntent: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("try" +
                "", "onDestroy: ");
    }
}
