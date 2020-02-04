package com.example.cameratest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public  static  final int TAKE_PHOTO=1;
    private ImageView picture;
    private Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button take=(Button) findViewById(R.id.take);
        picture =(ImageView) findViewById(R.id.picture);
        take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //read SD卡緩存目錄
                File outputImage=new File(getExternalCacheDir(),"out_put.jpg");
                try{
                    if(outputImage.exists()){
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                }catch (IOException e){
                    e.printStackTrace();
                }
                imageUri= FileProvider.getUriForFile(MainActivity.this,
                        "com.example.cameratest.fileprovider",outputImage);
                Intent intent =new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(intent,TAKE_PHOTO);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        switch (requestCode) {
            case 1:
                if (requestCode == RESULT_OK) {
                    Bitmap bitmap= BitmapFactory.decodeByteArray(getContentResolver().openInputStream(imageUri));
                    picture.setImageBitmap(bitmap);
                }
                break;
            default:
        }
    }
}
