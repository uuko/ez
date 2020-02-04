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

public class OneFragment extends Fragment {
    public static final String TAG = OneFragment.class.getSimpleName();
    private TextView changeTwo, changeThree;

    public static OneFragment newInstance() {
        return new OneFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        changeTwo = view.findViewById(R.id.two_fragment);
        changeThree = view.findViewById(R.id.three_fragment);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        changeTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("touch", "touch");
                CommonUtils.TransFragment(getContext(), R.id.main_container, TwoFragment.newInstance(), TwoFragment.TAG, null);
            }
        });

        changeThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonUtils.TransFragment(getContext(), R.id.main_container, ThreeFragment.newInstance(), ThreeFragment.TAG, null);
            }
        });
    }
}
