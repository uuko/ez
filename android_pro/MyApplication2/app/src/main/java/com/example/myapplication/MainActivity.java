package com.example.myapplication;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.myapplication.ui.ThreeFragment;
import com.example.myapplication.ui.base.BaseActivity;
import com.example.myapplication.ui.OneFragment;
import com.example.myapplication.ui.TwoFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //切換頁面
        CommonUtils.TransFragment(this, R.id.main_container, OneFragment.newInstance(), OneFragment.TAG, null);
    }

    @Override
    public void onFragmentDetached(Bundle arg, String... tag) {
        super.onFragmentDetached(arg, tag);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag[0]);
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .remove(fragment)
                    .commitNow();
        }
    }

    //返回鍵
    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (null != fragmentManager.findFragmentByTag(TwoFragment.TAG)) {
            onFragmentDetached(null, TwoFragment.TAG);
        } else if (null != fragmentManager.findFragmentByTag(ThreeFragment.TAG)) {
            onFragmentDetached(null, ThreeFragment.TAG);
        } else {
            super.onBackPressed();
        }
    }
}
