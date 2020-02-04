package com.example.myapplication.ui.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements BaseFragment.Callback {
    @Override
    public void onFragmentDetached(Bundle arg, String... tag) {

    }
}
