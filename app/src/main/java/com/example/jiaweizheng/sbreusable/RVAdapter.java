package com.example.jiaweizheng.sbreusable;

/**
 * Created by nick- on 3/3/2018.
 */
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ItemViewHolder> {

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView itemName;
        TextView itemDescription;
        ImageView itemPhoto;

        ItemViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            itemName = (TextView)itemView.findViewById(R.id.item_name);
            itemDescription = (TextView)itemView.findViewById(R.id.item_description);
            itemPhoto = (ImageView)itemView.findViewById(R.id.item_photo);
        }
    }

    List<Item> items;

    RVAdapter(List<Item> items){
        this.items = items;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        ItemViewHolder pvh = new ItemViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.itemName.setText(items.get(i).name);
        itemViewHolder.itemDescription.setText(items.get(i).description);
        itemViewHolder.itemPhoto.setImageResource(items.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
