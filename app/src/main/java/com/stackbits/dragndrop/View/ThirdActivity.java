package com.stackbits.dragndrop.View;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.stackbits.dragndrop.Model.DragData;
import com.stackbits.dragndrop.Model.ItemModel;
import com.stackbits.dragndrop.Controller.DragAdapterList;
import com.stackbits.dragndrop.R;

import java.util.ArrayList;

public class ThirdActivity extends Activity {


    @SuppressLint("ClickableViewAccessibility")
    DragAdapterList newAdapter;
    CardView dropContainer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drag_drop);
        Intent intent = getIntent();

        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<ItemModel> selected = (ArrayList<ItemModel>) args.getSerializable("data");


//        Toast.makeText(this, selected.get(0).name,Toast.LENGTH_SHORT).show();


        LinearLayout linearLayout = findViewById(R.id.images_list_lay);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.images_list);
        dropContainer = findViewById(R.id.drag_linear_layout);

        Button nextButton = findViewById(R.id.next_button_2);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//               try{
////                   dropContainer.buildDrawingCache();
////                   Bitmap bitmap = dropContainer.getDrawingCache();
//
//                   Intent intent1 = new Intent(ThirdActivity.this, FinalView.class);
//                   intent1.putExtra("view", (Parcelable) dropContainer);
//                   startActivity(intent1);
//               }catch (Exception e){
//                   Log.d("error",e.toString());
//               }
                linearLayout.setVisibility(View.GONE);
                nextButton.setVisibility(View.GONE);



            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        newAdapter = new DragAdapterList(selected);
        recyclerView.setAdapter(newAdapter);
        final ImageView shape;
        dropContainer.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent event) {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_ENTERED:
                        dropContainer.setBackgroundColor(Color.GREEN);
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        dropContainer.setBackgroundColor(Color.RED);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        dropContainer.setBackgroundColor(Color.WHITE);
                        break;
                    case DragEvent.ACTION_DROP:
                        final float dropX = event.getX();
                        final float dropY = event.getY();
                        final DragData state = (DragData) event.getLocalState();

                        final ImageView shape = (ImageView) LayoutInflater.from(ThirdActivity.this).inflate(
                                R.layout.drag_image_view, dropContainer, false);
                        shape.setImageResource(state.item.getBitmap());
                        shape.setX(dropX - (float) state.width / 2);
                        shape.setY(dropY - (float) state.height / 2);
                        shape.getLayoutParams().width = state.width;
                        shape.getLayoutParams().height = state.height;
                        shape.setTag(state.item.getName());
                        dropContainer.addView(shape);

                        shape.setOnTouchListener(new View.OnTouchListener() {
                            float x,y;
                            float dx, dy;

                            @Override
                            public boolean onTouch(View view, MotionEvent motionEvent) {


                                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                                    x =motionEvent.getX() -x;
                                    y= motionEvent.getY() - y;

                                }
                                if(motionEvent.getAction() == MotionEvent.ACTION_MOVE){
                                    dx = motionEvent.getX();
                                    dy = motionEvent.getY();

                                    shape.setX(shape.getX()+dx);
                                    shape.setY(shape.getY()+ dy);

                                    x = motionEvent.getX();
                                    y= motionEvent.getY();


                                }
                                return true;
                            }
                        });


                        break;
                    default:
                        break;
                }
                return true;
            }
        });




    }
}
