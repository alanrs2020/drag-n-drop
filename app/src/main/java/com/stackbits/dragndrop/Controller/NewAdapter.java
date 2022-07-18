package com.stackbits.dragndrop.Controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import android.widget.Toast;


import com.stackbits.dragndrop.Model.ItemModel;
import com.stackbits.dragndrop.R;

import java.util.ArrayList;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.MyViewHolder> {

       public ArrayList<ItemModel> eventList;
       public ArrayList<ItemModel> selectedList = new ArrayList<ItemModel>();

    public NewAdapter(ArrayList<ItemModel> eventList){
        this.eventList = eventList;
    }
        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            ImageView imageView;
            TextView title;
            CheckBox checkBox;
            int itemsSelected;
            public MyViewHolder(@NonNull View convertView) {
                super(convertView);
                convertView.setOnClickListener(this);
                imageView = convertView.findViewById(R.id.image);
                title = convertView.findViewById(R.id.image_text);
                checkBox = convertView.findViewById(R.id.checked);

            }

            @Override
            public void onClick(View view) {
            Toast.makeText(view.getContext(), "Item clicked" +eventList.get(getLayoutPosition()).getName(), Toast.LENGTH_SHORT).show();
               ItemModel item = eventList.get(getLayoutPosition());

                if(checkBox.isChecked()){
                        checkBox.setChecked(false);
                        selectedList.remove(item);
                    }else{
                        checkBox.setChecked(true);
                        System.out.println();
                        selectedList.add(item);
                    }
            }
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_view, parent, false);

            return new MyViewHolder(itemView);

        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            ItemModel event = eventList.get(position);

            holder.title.setText(event.getName());
            holder.imageView.setImageResource(event.getBitmap());


        }

        @Override
        public int getItemCount() {
            return eventList.size();
        }
}
