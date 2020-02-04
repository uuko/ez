package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TEXT_STATE = "currentText";
    private  TextView textView;
    private  ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView1=(TextView) findViewById(R.id.textView2);
        progressBar = (ProgressBar) findViewById(R.id.indeterminateBar);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            textView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }
    public void startTask(View view){
        TextView tv=(TextView) findViewById(R.id.textView);
        tv.setText("sleep");
        new AsyncTask(tv).execute();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the state of the TextView
        outState.putString(TEXT_STATE,
                textView.getText().toString());
    }
}





