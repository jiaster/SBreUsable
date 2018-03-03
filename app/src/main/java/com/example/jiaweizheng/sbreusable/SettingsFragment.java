package com.example.jiaweizheng.sbreusable;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by ralph on 3/3/2018.
 */

public class SettingsFragment extends PreferenceFragment{

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
