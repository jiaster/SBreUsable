package com.example.jiaweizheng.sbreusable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by nick- on 3/3/2018.
 */

public class viewItemActivity extends Activity {

    public Item viewedItem;
    public TextView itemName;
    public TextView description;
    public TextView user;
    public TextView category;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_item);
        Intent i = getIntent();
        viewedItem = (Item)i.getSerializableExtra("CURRENT_ITEM");
        itemName = (TextView)findViewById(R.id.itemName);
        description = (TextView)findViewById(R.id.itemDesc);
        user = (TextView)findViewById(R.id.itemUser);
        category = (TextView)findViewById(R.id.itemCategory);
        itemName.setText(viewedItem.name);
        description.setText(viewedItem.description);
        user.setText(viewedItem.user);
        category.setText(viewedItem.category);
    }

    public void mapButtonGo(View view) {
        Intent intent = new Intent(this, MapsMarkerActivity.class);
        intent.putExtra("X", viewedItem.x);
        intent.putExtra("Y", viewedItem.y);
        startActivity(intent);
    }
}
