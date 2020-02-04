package com.example.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText accountEdit;
    private EditText pwEdit;
    private Button login;
    private SharedPreferences preferences;
    private  SharedPreferences.Editor editor;
    private CheckBox rememberpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
       accountEdit =(EditText) findViewById(R.id.account);
       pwEdit=(EditText) findViewById(R.id.password);
       login =(Button) findViewById(R.id.login);
       rememberpass=(CheckBox)findViewById(R.id.remember);
       boolean isRemember = preferences.getBoolean("rem_pw",false);
      if (isRemember){
          String account = preferences.getString("account","");
          String password=preferences.getString("password","");
          accountEdit.setText(account);
          pwEdit.setText(password);
          rememberpass.setChecked(true);
      }
       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String account=accountEdit.getText().toString();
               String password=pwEdit.getText().toString();
               if (account.equals("abc")&&password.equals("123")){
                   editor=preferences.edit();
                   if (rememberpass.isChecked()){
                       editor.putBoolean("rem_pw",true);
                       editor.putString("account",account);
                       editor.putString("password",password);
                   }else{
                       editor.clear();
                   }
                   editor.apply();

                   Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                   startActivity(intent);
                   finish();}

               else {
                   Toast.makeText(LoginActivity.this,"incorrect",Toast.LENGTH_SHORT).show();
               }
           }
       });



    }

}
