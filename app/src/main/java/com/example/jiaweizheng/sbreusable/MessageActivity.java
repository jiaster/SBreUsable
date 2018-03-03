package com.example.jiaweizheng.sbreusable;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

/**
 * Created by owner on 3/3/18.
 */

public class MessageActivity extends AppCompatActivity {
    private List<Conversation> convosList;
    private RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_message);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv=findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        Drawable soylent = getResources().getDrawable( R.drawable.soylent);
        Item item = new Item("Cafe Vanilla Soylent", "Read-to-drink meal with coffee.", soylent, soylent, "food","Ralph Huang", "ralhuang@cs.stonybrook.edu", 40.916f, -73.126f);

        convosList = new ArrayList<>();

        convosList.add(new Conversation(item, "Hi, I would like to enquire about Soylent..."));
    }

    private void initializeAdapter(){
        MessageRVAdapter adapter = new MessageRVAdapter(convosList);
        rv.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
