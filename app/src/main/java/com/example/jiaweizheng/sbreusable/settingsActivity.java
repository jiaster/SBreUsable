package com.example.jiaweizheng.sbreusable;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

/**
 * Created by ralph on 3/3/2018.
 */

public class settingsActivity extends AppCompatActivity{
    EditText settingsEmail = findViewById(R.id.settings_email);
    EditText settingsContact = findViewById(R.id.settings_contact);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPrefs = getSharedPreferences("userContactInfo", Context.MODE_PRIVATE);
        String email = sharedPrefs.getString("email", "");
        String contact = sharedPrefs.getString("contact", "");
        if (contact.equals(""))
            contact = ""
        settingsEmail.setText();
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_settings);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        SharedPreferences sharedPrefs = getSharedPreferences("userContactInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("email", settingsEmail.getText().toString());
        editor.putString("contact", settingsContact.getText().toString());
        editor.apply();
        finish();
        return true;
    }
}
