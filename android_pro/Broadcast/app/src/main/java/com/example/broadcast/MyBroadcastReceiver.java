package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context, "recieve in my",
                Toast.LENGTH_SHORT).show();
//        abortBroadcast();
//        // 截斷 後面收不到
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
