package com.example.tt1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public interface PreferencesHelper {

    boolean getBooleanData();

    void setBooleanData(boolean booleanData);

    String getStringData();

    void setStringData(String stringData);

    Long getLongData();

    void setLongData(Long longData);

    Integer getIntegerData();

    void setIntegerData(Integer integerData);
}

