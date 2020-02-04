package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class CommonUtils {
    public static void TransFragment(Context context, int containerId, Fragment fragment, String Tag, Bundle args) {
        if (fragment == null)
            return;
        fragment.setArguments(args);
        AppCompatActivity activity = (AppCompatActivity) context;

        activity.getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .add(containerId, fragment, Tag)
                .commit();
    }
}
