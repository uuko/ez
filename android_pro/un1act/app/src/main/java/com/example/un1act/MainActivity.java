package com.example.un1act;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG=
            MainActivity.class.getSimpleName();
    private TextView textView;
    private EditText editText;
    public static final String extra_ms="com.example.un1act.extra.Message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView) findViewById(R.id.get);

    }

    public static final int TEXT_REQUEST = 1;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String a=Integer.toString(requestCode);
        Log.d("1111", a);

        if (requestCode==TEXT_REQUEST){

           if (resultCode == RESULT_OK){
               Log.d("123","12" +
                       "1");
                String reply=data.getStringExtra(Two.extra);
                textView.setVisibility(View.VISIBLE);
                textView.setText(reply);
           }
       }
    }

    public void gototwo(View view) {
         editText=(EditText) findViewById(R.id.gooo);
        Intent intent =new Intent(MainActivity.this,Two.class);
        String ms=editText.getText().toString();
        intent.putExtra(extra_ms,ms);
        startActivityForResult(intent,TEXT_REQUEST);
        Log.d(LOG_TAG, "Button clicked!");
    }
}
