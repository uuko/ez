package com.example.activitylifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.TaskStackBuilder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if(savedInstanceState != null){
//            String tempData=savedInstanceState.getString("data_key");
//            Log.d("TAG",tempData);
//        }
//        Button startnnormalact=(Button) findViewById(R.id.start_normal_act);
//        Button startndialogact=(Button) findViewById(R.id.start_dialog_act);
//        startnnormalact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity.this,NormalActivity.class);
//                startActivity(intent);
//            }
//        });
//        startndialogact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity.this,DialogActivity.class);
//                startActivity(intent);
//            }
//        });
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        String tempData="sth u type";
//        outState.putString("data_key",tempData);
//    }

//    protected void onStart(){
//        super.onStart();
//        Log.d("TAG","onstart");
//    }
//    protected void onResume(){
//        super.onResume();
//        Log.d("TAG","onresume");
//    }
//    protected void onPause(){
//        super.onPause();
//        Log.d("TAG","onpause");
//    }
//    protected void onStop(){
//        super.onStop();
//        Log.d("TAG","onstop");
//    }
//    protected void onDestroy(){
//        super.onDestroy();
//        Log.d("TAG","ondestroy");
//    }
//    protected void onRestart(){
//        super.onRestart();
//        Log.d("TAG","onre  start");
//    }
}
