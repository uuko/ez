package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class CustomReciever extends BroadcastReceiver {

    private static final  String action_custom_broadcast=BuildConfig.APPLICATION_ID+"ACTION_CUSTOM_BROADCAST";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String intentAct=intent.getAction();
        Log.d("LOVE", intentAct);
        if (intentAct !=null){
            String toast="test";
            switch (intentAct){
                case Intent.ACTION_POWER_CONNECTED:
                    toast="connected";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toast="unconnected";
                    break;
                case "com.example.Broadcast.ACTION_CUSTOM_BROADCAST":
                    toast="custom";
                    break;
                case "com.example.Broadcast.ACTION_SEND_NUMBER":
                    String extra=intent.getExtras().getString("extra");
                    int n =Integer.parseInt(extra);
                    int z=n*n;
                    String end=Integer.toString(z);
                    toast=end;
                    break;


            }
            Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
        }
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
