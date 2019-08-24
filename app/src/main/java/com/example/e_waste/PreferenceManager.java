package com.example.e_waste;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context mContext;
    int PRIVATE_MODE = 0;
    public static final String PREF_NAME = "slider";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PreferenceManager(Context context) {
        this.mContext = context;
        pref = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}
