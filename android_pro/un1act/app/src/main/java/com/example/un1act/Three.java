package com.example.un1act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Three extends AppCompatActivity {
    private EditText mWebsiteEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        Intent intent=getIntent();
        Uri uri=intent.getData();
        if (uri!=null){
            String urs=uri.toString();
            TextView textView=(TextView) findViewById(R.id.textView8);
            textView.setText(urs);
        }

    }
    public void openweb(View view) {
        mWebsiteEditText = findViewById(R.id.web);
        String url = mWebsiteEditText.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
    public void  openloc(View view){
        EditText locedit=(EditText)findViewById(R.id.loc);
        String loc=locedit.getText().toString();
        Uri address=Uri.parse("geo:0,0?q=" + loc);
        Intent intent=new Intent(Intent.ACTION_VIEW,address);
        startActivity(intent);
    }
    public void openshare(View view) {
        EditText share=(EditText) findViewById(R.id.share);
        String txt = share.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("share_text_with")
                .setText(txt)
                .startChooser(); //發送
    }
}
