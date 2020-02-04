package com.example.un1act;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Four extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
    }
    public void  display(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
    public void showDonut(View view){
        display(getString(R.string.donut_order_message));
    }
    public void showpurple(View view){
        display(getString(R.string.froyo_order_message));
    }
    public void showice(View view){
        display(getString(R.string.ice_cream_order_message));
    }
}
