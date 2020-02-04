package com.example.tt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    public PreferencesHelperImp preferencesHelperImp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Button clear=(Button) findViewById(R.id.clear);
        Button send=(Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText account=(EditText) findViewById(R.id.text);
                EditText email=(EditText) findViewById(R.id.text2);
                EditText pw=(EditText) findViewById(R.id.pw_t);
                String ac1=email.getText().toString();
//                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("sharedPreferences", MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString("data",ac1);
//                editor.apply();
                preferencesHelperImp = new PreferencesHelperImp(getApplicationContext());
                preferencesHelperImp.setStringData(ac1);
                Intent intent=new Intent(MainActivity.this,Two.class);
                startActivity(intent);
                finish();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 EditText account=(EditText) findViewById(R.id.text);
                 EditText email=(EditText) findViewById(R.id.text2);
                EditText pw=(EditText) findViewById(R.id.pw_t);
                EditText day=(EditText) findViewById(R.id.day_t);
                account.getText().clear();
                email.getText().clear();
                pw.getText().clear();
                day.getText().clear();
            }
        });
    }
}
