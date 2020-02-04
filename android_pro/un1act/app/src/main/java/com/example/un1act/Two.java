package com.example.un1act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Two extends AppCompatActivity {

    private EditText editText;
    public static final String extra="com.example.android.un1act.extra.reply";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Intent intent=getIntent();
        TextView textView=(TextView)findViewById(R.id.text_header);
        String ms=intent.getStringExtra(MainActivity.extra_ms);
        textView.setText(ms);

    }
    public void return_re(View view){
        editText=(EditText)findViewById(R.id.textView);
       String reply=editText.getText().toString();
       Intent replyIntent=new Intent(Two.this,MainActivity.class);
       replyIntent.putExtra(extra,reply);
       setResult(RESULT_OK,replyIntent);
       finish();
    }
    public void go_three(View view){
        Intent intent=new Intent(Two.this,Three.class);
        startActivity(intent);
    }
}
