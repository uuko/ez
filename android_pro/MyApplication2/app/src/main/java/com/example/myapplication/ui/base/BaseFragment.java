package com.example.myapplication.ui.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    public interface Callback {

        void onFragmentDetached(Bundle arg, String... tag);
    }
}
