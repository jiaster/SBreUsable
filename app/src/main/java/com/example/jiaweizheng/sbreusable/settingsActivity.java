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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ralph on 3/3/2018.
 */

public class settingsActivity extends AppCompatActivity{
    EditText settingsEmail;
    EditText settingsContact;
    Button settingsSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_settings);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        settingsEmail = findViewById(R.id.settings_email);
        settingsContact = findViewById(R.id.settings_contact);
        settingsSaveButton = findViewById(R.id.settings_save);
        String email;
        String contact;
        SharedPreferences sharedPrefs = getSharedPreferences("userContactInfo", Context.MODE_PRIVATE);
        if(sharedPrefs.contains("email")) {
            email = sharedPrefs.getString("email", "");
            if (email != null)
                settingsEmail.setText(email + "");
        }
        if(sharedPrefs.contains("contact")) {
            contact = sharedPrefs.getString("contact", "");
            if (contact != null)
                settingsContact.setText(contact + "");
        }

        settingsSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settingsEmail = findViewById(R.id.settings_email);
                settingsContact = findViewById(R.id.settings_contact);

                SharedPreferences sharedPrefs = getSharedPreferences("userContactInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPrefs.edit();
                editor.putString("email", settingsEmail.getText().toString());
                editor.putString("contact", settingsContact.getText().toString());
                editor.apply();
                Toast.makeText(settingsActivity.this, "Preferences Saved.", Toast.LENGTH_LONG).show();
                    finish();


            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

}
