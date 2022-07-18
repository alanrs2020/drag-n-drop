package com.stackbits.dragndrop.Controller;



import android.os.Build;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.stackbits.dragndrop.Model.DragData;
import com.stackbits.dragndrop.Model.ItemModel;
import com.stackbits.dragndrop.R;

import java.util.ArrayList;


public class DragAdapterList extends RecyclerView.Adapter<DragAdapterList.MyViewHolder> {

    ArrayList<ItemModel> eventList;
    ArrayList<ItemModel> selectedList = new ArrayList<ItemModel>();

    public DragAdapterList(ArrayList<ItemModel> eventList){
        this.eventList = eventList;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener , View.OnDragListener {
        ImageView imageView;


        public MyViewHolder(@NonNull View convertView) {
            super(convertView);
            convertView.setOnLongClickListener(this);
            convertView.setOnDragListener(this);
            imageView = convertView.findViewById(R.id.image_view_drop);

        }

//        @Override
//        public void onClick(View view) {
//            Toast.makeText(view.getContext(), "Item clicked" +eventList.get(getLayoutPosition()).name, Toast.LENGTH_SHORT).show();
//            ItemModel item = eventList.get(getLayoutPosition());
//
//
//        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public boolean onLongClick(View v) {

//            final ItemModel item = eventList.get(getLayoutPosition());
//            final DragData state = new DragData(item, shape.getWidth(), shape.getHeight());
//            final DragShadowBuilder shadow = new DragShadowBuilder(shape);
//            ViewCompat.startDragAndDrop(shape, null, shadow, state, 0);
            return false;
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public boolean onDrag(View v, DragEvent e) {

            return false;




        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drag_image_view, parent, false);
        final MyViewHolder holder = new MyViewHolder(itemView);
        final View shape = holder.imageView;
        holder.itemView.setOnLongClickListener(v -> {
            final ItemModel item = eventList.get(holder.getAdapterPosition());
            final DragData state = new DragData(item, shape.getWidth(), shape.getHeight());
            final View.DragShadowBuilder shadow = new View.DragShadowBuilder(shape);
            ViewCompat.startDragAndDrop(shape, null, shadow, state, 0);
            return true;
        });
        return holder;


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ItemModel event = eventList.get(position);


        holder.imageView.setImageResource(event.getBitmap());


    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
