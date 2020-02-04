package com.example.activitytest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.TaskStackBuilder;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.jar.Attributes;

public class first extends AppCompatActivity {
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstlayout);
        Log.d("first","123");
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        Button button1=(Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              Toast.makeText(first.this, "u click it",Toast.LENGTH_LONG).show();
//                finish();
//                Intent intent = new Intent(first.this,second.class);
//                Intent intent=new Intent("com.example.activitytest.ACTION_START");
//                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                //Intent intent =new Intent(Intent.ACTION_VIEW);
               // intent.setData(Uri.parse("http://www.baidu.com"));
//                Intent intent=new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
                String data="i love u";
                Intent intent=new Intent(first.this,second.class);
//                intent.putExtra("extra_data",data);
//                startActivity(intent);
                startActivityForResult(intent,1);
//                startActivity(intent);
            }
        });
        editText=(EditText)findViewById(R.id.edit_text);
        Button click_to_show=(Button) findViewById(R.id.click_show);
        imageView =(ImageView) findViewById(R.id.img_view);
        progressBar =(ProgressBar) findViewById(R.id.progress_bar);
        Button show=(Button) findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.show:
                        AlertDialog.Builder dialog=new AlertDialog.Builder(first.this);
                        dialog.setTitle("test");
                        dialog.setMessage("i love u");
                        dialog.setCancelable(false);
//                        true是不能按返回建取消ㄉ
                        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        dialog.show();
//                        有分progressdialog 他是有進度條ㄉ 跟一班的差別
                }
            }
        });
        click_to_show.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                    switch (view.getId()){
                        case R.id.click_show:
                            String inputtext=editText.getText().toString();
                            Toast.makeText(first.this,inputtext,Toast.LENGTH_LONG).show();
                            imageView.setImageResource(R.drawable.a2);
                            if (progressBar.getVisibility() == View.GONE){
    //                            //gone是不可見 invisible透明仍佔大小 visible 可見
    //                            要在VIEW使用則是找visiblitiy這個屬性
    //                            progressBar.setVisibility(View.VISIBLE);
                                int pro=progressBar.getProgress();
                                pro=pro+10;
                                progressBar.setProgress(pro);
                            }
    //                        else{
    //                            progressBar.setVisibility(View.GONE);
    //                        }

                            break;
                            default:
                                break;

                    }
                }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.main,menu);
       return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()){
          case R.id.add_item:
              Toast.makeText(this,"u click add",Toast.LENGTH_LONG).show();
              break;
          case R.id.remove_item:
              Toast.makeText(this,"u click remove",Toast.LENGTH_LONG).show();
              break;
          default:
      }
      return true;
    }
//按鈕案返回時取得結果
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
      switch (requestCode){
          case 1:
              if (requestCode == RESULT_OK){
                  String returnedData=data.getStringExtra("data_return");
                  Log.d("first",returnedData);
              }
              break;
              default:
      }

      //自定義控建

    }
    public class TitleLayout extends LinearLayout{
        public TitleLayout(Context context, AttributeSet attrs){
            super(context,attrs);
//           //動態加載
            LayoutInflater.from(context).inflate(R.layout.title,this);
            Button title_back=(Button) findViewById(R.id.title_back);
            Button title_edit=(Button) findViewById(R.id.title_edit);
            title_back.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Activity) getContext()).finish();
                }
            });
            title_edit.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),"u click edit",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
