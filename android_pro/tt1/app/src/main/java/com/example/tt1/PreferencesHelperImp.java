package com.example.tt1;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelperImp implements PreferencesHelper {
    private String SharedPreferencesKey = "SharedPreferencesKey";
    private final SharedPreferences mSharedPreferences;

    private static final String PREF_KEY_BOOLEAN_DATA = "PREF_KEY_BOOLEAN_DATA";
    private static final String PREF_KEY_STRING_DATA = "PREF_KEY_STRING_DATA";
    private static final String PREF_KEY_LONG_DATA = "PREF_KEY_LONG_DATA";
    private static final String PREF_KEY_INTEGER_DATA = "PREF_KEY_INTEGER_DATA";

    public PreferencesHelperImp(Context context) {
        mSharedPreferences = context.getSharedPreferences(SharedPreferencesKey, Context.MODE_PRIVATE);
    }

    @Override
    public boolean getBooleanData() {
        return mSharedPreferences.getBoolean(PREF_KEY_BOOLEAN_DATA, true);
    }

    @Override
    public void setBooleanData(boolean booleanData) {
        mSharedPreferences.edit().putBoolean(PREF_KEY_BOOLEAN_DATA, booleanData).apply();
    }

    @Override
    public String getStringData() {
        return mSharedPreferences.getString(PREF_KEY_STRING_DATA, "");
    }

    @Override
    public void setStringData(String stringData) {
        mSharedPreferences.edit().putString(PREF_KEY_STRING_DATA, stringData).apply();
    }

    @Override
    public Long getLongData() {
        return mSharedPreferences.getLong(PREF_KEY_LONG_DATA, 0);
    }

    @Override
    public void setLongData(Long longData) {
        mSharedPreferences.edit().putLong(PREF_KEY_LONG_DATA, longData).apply();
    }

    @Override
    public Integer getIntegerData() {
        return mSharedPreferences.getInt(PREF_KEY_INTEGER_DATA, 0);
    }

    @Override
    public void setIntegerData(Integer integerData) {
        mSharedPreferences.edit().putInt(PREF_KEY_INTEGER_DATA, integerData).apply();
    }
}
