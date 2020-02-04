package com.example.activitytest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.TaskStackBuilder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
//        Intent intent=getIntent();
//        String data=intent.getStringExtra("extra_data");
//        Log.d("second",data);
        Button button2=(Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("data_return","i hate u");
                setResult(RESULT_OK,intent);
                finish();
            }
        });




    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent();
        intent.putExtra("data_return","i hate u");
        setResult(RESULT_OK,intent);
        finish();
    }
}
