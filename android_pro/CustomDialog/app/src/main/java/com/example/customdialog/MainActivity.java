package com.example.customdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnShowDialog;
    private Button btnCloseDialog;
    private EditText fname;
    private EditText lname;
    private View mDialogView;
    private AlertDialog.Builder mBuilder;
    private AlertDialog alertDialog;
    private TextView text_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowDialog = (Button) findViewById(R.id.btn_show_dialog);
        mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null);
        mBuilder = new AlertDialog.Builder(this).setView(mDialogView);


        text_result = (TextView) findViewById(R.id.text_result);
        fname = (EditText) mDialogView.findViewById(R.id.editText1);
        lname = (EditText) mDialogView.findViewById(R.id.editText2);
        alertDialog = mBuilder.create();



        btnCloseDialog = (Button) mDialogView.findViewById(R.id.button) ;

        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
                Window dialogWindow = alertDialog.getWindow();
                WindowManager m = getWindow().getWindowManager();
                Display d = m.getDefaultDisplay(); // 获取屏幕宽、高度
                WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
                p.height = (int) (d.getHeight() * 1.2);
                p.width = (int) (d.getWidth() * 1.0);
                dialogWindow.setAttributes(p);
            }
        });

        btnCloseDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                text_result.setText("firstname " + fname.getText().toString() + "\n" + "lastname " +lname.getText().toString());
            }
        });


    }
}
