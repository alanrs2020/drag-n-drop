package com.stackbits.dragndrop.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.stackbits.dragndrop.Model.ItemModel;

import com.stackbits.dragndrop.Controller.NewAdapter;
import com.stackbits.dragndrop.R;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {


    ItemModel itemModel;
    NewAdapter newAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ArrayList<ItemModel> arrayList = new ArrayList<>();

//        ListView listView = findViewById(R.id.list_item);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_item);

        Button nextButton = findViewById(R.id.next_button);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        ItemModel item1 = new ItemModel("First",R.drawable.first);
        ItemModel item2 = new ItemModel("Second",R.drawable.second);
        ItemModel item3 = new ItemModel("third",R.drawable.third);
        ItemModel item4 = new ItemModel("Fourth",R.drawable.fourth);


        arrayList.add(item1);
        arrayList.add(item2);
        arrayList.add(item3);
        arrayList.add(item4);
        newAdapter = new NewAdapter(arrayList);
        recyclerView.setAdapter(newAdapter);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(newAdapter.selectedList.size() >= 3){
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    Bundle args = new Bundle();

                    args.putSerializable("data",(ArrayList<ItemModel>) newAdapter.selectedList);
                    intent.putExtra("BUNDLE",args);
                    startActivity(intent);
                }else{
                    Toast.makeText(SecondActivity.this, "Select min 3 items", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}
