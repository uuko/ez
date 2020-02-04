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

public class TwoFragment extends Fragment {
    public static final String TAG = TwoFragment.class.getSimpleName();
    private TextView changeOne, changeThree;

    public static TwoFragment newInstance() {
        return new TwoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
//        changeOne = view.findViewById(R.id.one_fragment);
//        changeThree = view.findViewById(R.id.three_fragment);
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
//        changeThree.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                CommonUtils.TransFragment(getContext(), R.id.main_container, ThreeFragment.newInstance(), ThreeFragment.TAG, null);
//            }
//        });
    }
}
