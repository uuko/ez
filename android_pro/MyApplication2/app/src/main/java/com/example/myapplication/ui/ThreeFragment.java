package com.example.myapplication.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.CommonUtils;
import com.example.myapplication.R;

public class ThreeFragment extends Fragment {
    public static final String TAG = ThreeFragment.class.getSimpleName();
    private TextView changeOne, changeTwo;

    public static ThreeFragment newInstance() {
        return new ThreeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
//        changeOne = view.findViewById(R.id.one_fragment);
//        changeTwo = view.findViewById(R.id.two_fragment);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        changeOne.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.i("touch","touch");
//                CommonUtils.TransFragment(getContext(), R.id.main_container, OneFragment.newInstance(), OneFragment.TAG, null);
//            }
//        });
//
//        changeTwo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                CommonUtils.TransFragment(getContext(), R.id.main_container, TwoFragment.newInstance(), TwoFragment.TAG, null);
//            }
//        });
    }
}
