package com.example.jiaweizheng.sbreusable;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private List<Item> items;
    private RecyclerView rv;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    private Bitmap originalPhoto;
    private Bitmap reducedPhoto;
    private String nameOfItem;
    private String description;
    private String category;
    private String username;
    private String contactname;
    public boolean consumeCheck = false;
    public boolean techCheck = false;
    public boolean clothCheck = false;
    public boolean bookCheck = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Intent intent = new Intent(MainActivity.this, addItemActivity.class);
                intent.putExtra("photo", originalPhoto);
                intent.putExtra("reducedPhoto", reducedPhoto);
                intent.putExtra("nameOfItem", nameOfItem);
                intent.putExtra("description", description);
                intent.putExtra("category", category);
                startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                // get String data from Intent
                originalPhoto = (Bitmap) data.getParcelableExtra("photo");
                reducedPhoto = (Bitmap) data.getParcelableExtra("reducedPhoto");
                nameOfItem = data.getStringExtra("nameOfItem");
                description = data.getStringExtra("description");
                category = data.getStringExtra("category");
            }
            Item item=new Item(nameOfItem,description, originalPhoto, reducedPhoto,"food", "Ralph", "Jiawei",40.916f, -73.121f  );
            addItem(item);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_consume) {


        } else if (id == R.id.nav_tech) {

        } else if (id == R.id.nav_clothing) {

        } else if (id == R.id.nav_books) {

        } else if (id == R.id.nav_messages) {

        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(MainActivity.this, settingsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_loginout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initializeData(){
        items = new ArrayList<>();
        items.add(new Item("Cafe Vanilla Soylent", "Read-to-drink meal with coffee.", R.mipmap.soylent, R.mipmap.soylent, "food","Ralph Huang", "ralhuang@cs.stonybrook.edu", 40.916f, -73.126f));
        items.add(new Item("CSE 303 Textbook", "Paperback textbook for Anika's section.", R.mipmap.textbook, R.mipmap.textbook, "book","Nicholas Chen", "nicholas.chen@stonybrook.edu", 40.916f, -73.121f));
        items.add(new Item("Monster Drink", "Unopened Monster energy drink.", R.mipmap.monster, R.mipmap.monster, "food", "Jiawei Zheng", "3476027588", 40.909f, -73.127f));
        items.add(new Item("Cafe Vanilla Soylent", "Read-to-drink meal with coffee.", R.mipmap.soylent, R.mipmap.soylent, "food","Ralph Huang", "ralhuang@cs.stonybrook.edu", 40.916f, -73.126f));
        items.add(new Item("CSE 303 Textbook", "Paperback textbook for Anika's section.", R.mipmap.textbook, R.mipmap.textbook, "book","Nicholas Chen", "nicholas.chen@stonybrook.edu", 40.916f, -73.121f));
        items.add(new Item("Monster Drink", "Unopened Monster energy drink.", R.mipmap.monster, R.mipmap.monster, "food", "Jiawei Zheng", "3476027588", 40.909f, -73.127f));
        items.add(new Item("Cafe Vanilla Soylent", "Read-to-drink meal with coffee.", R.mipmap.soylent, R.mipmap.soylent, "food","Ralph Huang", "ralhuang@cs.stonybrook.edu", 40.916f, -73.126f));
        items.add(new Item("CSE 303 Textbook", "Paperback textbook for Anika's section.", R.mipmap.textbook, R.mipmap.textbook, "book","Nicholas Chen", "nicholas.chen@stonybrook.edu", 40.916f, -73.121f));
        items.add(new Item("Monster Drink", "Unopened Monster energy drink.", R.mipmap.monster, R.mipmap.monster, "food", "Jiawei Zheng", "3476027588", 40.909f, -73.127f));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(items);
        rv.setAdapter(adapter);
    }

    public void addItem(Item item) {
        if(item != null) {
            items.add(item);
        }
    }

    public void removeItem(Item item) {
        if(item != null) {
            items.remove(item);
        }
    }
}
