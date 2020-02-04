package com.example.tv;

import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FragmentManager mFragmentManager;
    private HomeFragment mHomeFragment;
    private DashboardFragment mDashboardFragment;
    private NotificationFragment mNotificationFragment;

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            HOME, DASHBOARD, NOTIFICATIONS, DETAIL
    })
    public @interface FragmentType {}
    public static final String HOME = "HOME";
    public static final String DASHBOARD = "DASHBOARD";
    public static final String NOTIFICATIONS = "NOTIFICATIONS";
    public static final String DETAIL = "DETAIL";
    public static final String DETAIL_MESSAGE = "DetailMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getFragmentManager();

        ((BottomNavigationView) findViewById(R.id.navigation)).setOnNavigationItemSelectedListener(this);
        ((BottomNavigationView) findViewById(R.id.navigation)).setSelectedItemId(R.id.navigation_home);
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        final View v = inflater.inflate(R.layout.alertdialog, null);

//        new AlertDialog.Builder(MainActivity.this)
//                .setTitle("請輸入你的id")
//                .setView(v)
//                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        EditText editText = (EditText) (v.findViewById(R.id.editText1));
//                        Toast.makeText(getApplicationContext(), "你的id是" +
//
//                                editText.getText().toString(), Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .show();
//        final String[] dinner = {"腿庫","雞蛋糕","沙威瑪","澳美客","麵線","麵疙瘩"};
//
//        AlertDialog.Builder dialog_list = new AlertDialog.Builder(MainActivity.this);
//        dialog_list.setTitle("利用List呈現");
//        dialog_list.setItems(dinner, new DialogInterface.OnClickListener(){
//            @Override
//
//            //只要你在onClick處理事件內，使用which參數，就可以知道按下陣列裡的哪一個了
//            public void onClick(DialogInterface dialog, int which) {
//                // TODO Auto-generated method stub
//                Toast.makeText(MainActivity.this, "你選的是" + dinner[which], Toast.LENGTH_SHORT).show();
//            }
//        });
//        dialog_list.show();
//        AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
////        dialog.setTitle("123");
////        dialog.setMessage("456");
////        dialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
////            @Override
////            public void onClick(DialogInterface dialog, int which) {
////                Toast.makeText(MainActivity.this, "123", Toast.LENGTH_SHORT).show();
////            }
////        });
//        dialog.show();
//        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//        dialog.setTitle("基本訊息對話按鈕");
//        dialog.setMessage("基本訊息對話功能介紹");
//        dialog.setNegativeButton("NO",new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface arg0, int which) {
//                // TODO Auto-generated method stub
//                Toast.makeText(MainActivity.this, "我還尚未了解",Toast.LENGTH_SHORT).show();
//            }
//
//        });
//        dialog.setPositiveButton("YES",new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface arg0, int arg1) {
//                // TODO Auto-generated method stub
//                Toast.makeText(MainActivity.this, "我了解了",Toast.LENGTH_SHORT).show();
//            }
//
//        });
//        dialog.setNeutralButton("取消",new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface arg0, int arg1) {
//                // TODO Auto-generated method stub
//                Toast.makeText(MainActivity.this, "取消",Toast.LENGTH_SHORT).show();
//            }
//
//        });
//        dialog.show();
//

    }

    public void test(){
        Toast.makeText(this, "123", Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if (mFragmentManager.findFragmentByTag(DETAIL) != null) {
            mFragmentManager.popBackStack();
        }

        switch (item.getItemId()) {
            case R.id.navigation_home:

                if (mHomeFragment == null) mHomeFragment = new HomeFragment();
                if (mDashboardFragment != null) fragmentTransaction.hide(mDashboardFragment);
//                if (mNotificationsFragment != null) fragmentTransaction.hide(mNotificationsFragment);
                if (mHomeFragment.isAdded()) {
                    fragmentTransaction.show(mHomeFragment);
                } else {
                    fragmentTransaction.add(R.id.container_main, mHomeFragment, HOME);
                }
                fragmentTransaction.commit();

                return true;
            case R.id.navigation_dashboard:

                if (mDashboardFragment == null) mDashboardFragment = new DashboardFragment();
                if (mHomeFragment != null) fragmentTransaction.hide(mHomeFragment);
            //    if (mNotificationsFragment != null) fragmentTransaction.hide(mNotificationsFragment);
                if (mDashboardFragment.isAdded()) {
                    fragmentTransaction.show(mDashboardFragment);
                } else {
                    fragmentTransaction.add(R.id.container_main, mDashboardFragment, DASHBOARD);
                }
                fragmentTransaction.commit();

                return true;
            case R.id.navigation_notifications:

//                if (mNotificationsFragment == null) mNotificationsFragment = new NotificationFragment();
//                if (mHomeFragment != null) fragmentTransaction.hide(mHomeFragment);
//                if (mDashboardFragment != null) fragmentTransaction.hide(mDashboardFragment);
//                if (mNotificationsFragment.isAdded()) {
//                    fragmentTransaction.show(mNotificationsFragment);
//                } else {
//                    fragmentTransaction.add(R.id.container_main, mNotificationsFragment, NOTIFICATIONS);
//                }
//                fragmentTransaction.commit();
//
//                return true;
        }
        return false;
    }

    public void onOpenDetail(String message) {

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        // 如果目前顯示的頁面是 home fragment
        if (mHomeFragment != null && !mHomeFragment.isHidden()) {
            fragmentTransaction.hide(mHomeFragment);
            fragmentTransaction.addToBackStack(HOME);
            //transaction.addToBackStack(String tag);
        }
        if (mDashboardFragment != null && !mDashboardFragment.isHidden()) {
            fragmentTransaction.hide(mDashboardFragment).addToBackStack(DASHBOARD);
        }
//        if (mNotificationsFragment != null && !mNotificationsFragment.isHidden()) {
//            fragmentTransaction.hide(mNotificationsFragment).addToBackStack(NOTIFICATIONS);
//        }

        DetailFragment fragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(DETAIL_MESSAGE, message);
        fragment.setArguments(bundle);

        fragmentTransaction.add(R.id.container_main, fragment, DETAIL).commit();

    }
}
