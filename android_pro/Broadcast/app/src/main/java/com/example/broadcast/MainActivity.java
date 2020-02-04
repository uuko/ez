package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private IntentFilter intentFilter;
   // private NetworkChangeReciever networkChangeReciever;
   private LocalReceiver localReceiver;
   private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager= LocalBroadcastManager.getInstance(this);
        Button button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(
                        "com.example.broadcast.MY_BROADCAST"
                );
                sendBroadcast(intent);
//                Intent intent=new Intent("com.example.broadcast.LOCAL_BROADCAST"
//                );
//                localBroadcastManager.sendBroadcast(intent);
            }
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcast.LOCAL_BROADCAST");
        localReceiver =new  LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
////        networkChangeReciever = new NetworkChangeReciever();
//        registerReceiver(networkChangeReciever,intentFilter);
    }
    @Override
    //      動態註冊廣播一定要取消註冊
        protected  void onDestroy(){
        super.onDestroy();
//        unregisterReceiver(networkChangeReciever);
    }
    class  LocalReceiver extends BroadcastReceiver {
        @Override
        //繼承方法 網路發生變化
        public void onReceive(Context context, Intent intent){
                Toast.makeText(context, "yes",
                        Toast.LENGTH_SHORT).show();

    }
//        class NetworkChangeReciever extends BroadcastReceiver {
//        @Override
//        //繼承方法 網路發生變化
//        public void onReceive(Context context, Intent intent){
//            ConnectivityManager connectionManager= (ConnectivityManager)
//                    getSystemService(Context.CONNECTIVITY_SERVICE);
//            NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
//            if (networkInfo != null && networkInfo.isAvailable()) {
//                Toast.makeText(context, "network is available",
//                        Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(context, "network is unavailable",
//                        Toast.LENGTH_SHORT).show();
//            }
////
//
//        }


    }
}
