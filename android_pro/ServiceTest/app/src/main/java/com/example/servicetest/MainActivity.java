package com.example.servicetest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyService.DownloadBinder downloadBinder;
    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder=(MyService.DownloadBinder)service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start=(Button) findViewById(R.id.start);
        Button stop=(Button) findViewById(R.id.stop);
        Button bind=(Button) findViewById(R.id.bind);
        Button unbind=(Button) findViewById(R.id.unbind);
        Button start_intent=(Button)findViewById(R.id.start_intent);

    }

    public   void  onClick(View v){
        switch (v.getId()){
            case R.id.start:
                Intent startIntent=new Intent(this,MyService.class);
                startService(startIntent);
                break;
            case R.id.stop:
                Intent stopIntent=new Intent(this,MyService.class);
                stopService(stopIntent);
                break;
            case R.id.bind:
                Intent bindIntent=new Intent(this,MyService.class);
                bindService(bindIntent,connection,BIND_AUTO_CREATE);
                break;
            case R.id.unbind:
                unbindService(connection);
            case R.id.start_intent:
                Log.d("Main", "onClick: "+Thread.currentThread().getId());
                Intent intent=new Intent(this,MyIntentService.class);
                startService(intent);
                break;
                default:
                    break;
        }
    }
}
