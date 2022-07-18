package com.stackbits.dragndrop.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.stackbits.dragndrop.R;

public class FinalView extends AppCompatActivity {

    ThirdActivity thirdActivity;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_view);

        CardView container = findViewById(R.id.drag_linear_layout);
        Intent intent = getIntent();

        container.addView(intent.getParcelableExtra("view"));
//        ImageView imageView = findViewById(R.id.final_view);
//        Intent intent = getIntent();
//        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("BitmapImage");
//
//        imageView.setImageBitmap(bitmap);

    }
}
