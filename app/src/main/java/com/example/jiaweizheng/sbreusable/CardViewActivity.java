package com.example.jiaweizheng.sbreusable;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CardViewActivity extends Activity {

    TextView itemName;
    TextView itemDescription;
    ImageView itemPhoto;
    Bitmap photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cardview);
        itemName = (TextView)findViewById(R.id.item_name);
        itemDescription = (TextView)findViewById(R.id.item_description);
        itemPhoto = (ImageView)findViewById(R.id.item_photo);

        itemName.setText("Cafe Vanilla Soylent");
        itemDescription.setText("Ready-to-drink meal with coffee.");
        itemPhoto.setImageResource(R.mipmap.soylent);
    }
}
