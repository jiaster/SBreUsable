package com.example.jiaweizheng.sbreusable;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.app.Activity;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.BitmapFactory;
import com.example.jiaweizheng.sbreusable.MainActivity;
import android.graphics.drawable.*;


/**
 * Created by Jia Wei Zheng on 3/3/2018.
 */

public class addItemActivity extends Activity{
    private static final int CAMERA_REQUEST = 1888;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageButton imageButton;
    private String title;
    private String description;
    private int category;
    private EditText titleField;
    private EditText descriptionField;
    Drawable photo;
    Drawable reducedPhoto;
    Bitmap imageBitmap;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);
        titleField   = (EditText)findViewById(R.id.title);
        descriptionField   = (EditText)findViewById(R.id.description);
        this.imageButton = (ImageButton)this.findViewById(R.id.add_main_image);
        ImageButton photoButton = (ImageButton) this.findViewById(R.id.add_main_image);
        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }

        });

    }


    public void postButton(View view) {
        title=titleField.getText().toString();
        description=descriptionField.getText().toString();

        Intent resultIntent = new Intent();
        //Bitmap photo1 = ((BitmapDrawable)photo).getBitmap();
        //Bitmap photo2 = ((BitmapDrawable)reducedPhoto).getBitmap();
        resultIntent.putExtra("photo", imageBitmap);
        resultIntent.putExtra("reducedPhoto", imageBitmap);
        resultIntent.putExtra("nameOfItem", title);
        resultIntent.putExtra("description", description);
        resultIntent.putExtra("category", description);
        setResult(Activity.RESULT_OK, resultIntent);

        finish();
    }

    public void setLocationButton(View view) {

    }
    public String getItemTitle(){
        return title;
    }
    public String getItemDescription(){
        return description;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
        //reducedPhoto = getResizedBitmap(photo, 72);
        //title=titleField.getText().toString();
        //description=descriptionField.getText().toString();

        Bundle extras = data.getExtras();
        imageBitmap = (Bitmap) extras.get("data");
        imageButton.setImageBitmap(imageBitmap);
        //Drawable photo = new BitmapDrawable(getResources(), imageBitmap);
/*
            Intent resultIntent = new Intent();
            resultIntent.putExtra("photo", photo);
            resultIntent.putExtra("reducedPhoto", reducedPhoto);
            resultIntent.putExtra("nameOfItem", title);
            resultIntent.putExtra("description", description);
            resultIntent.putExtra("category", description);
            setResult(Activity.RESULT_OK, resultIntent);*/
        //}
    }/*
    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = 1;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }*/
}