package com.example.jiaweizheng.sbreusable;

/**
 * Created by nick- on 3/3/2018.
 */
import android.content.Intent;
import android.os.Parcelable;
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
        TextView itemUser;
        ImageView itemPhoto;

        public Item currentItem;

        ItemViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            itemName = (TextView)itemView.findViewById(R.id.item_name);
            itemDescription = (TextView)itemView.findViewById(R.id.item_description);
            itemUser = (TextView)itemView.findViewById(R.id.item_user);
            itemPhoto = (ImageView)itemView.findViewById(R.id.item_photo);
            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), viewItemActivity.class);
                    intent.putExtra("CURRENT_ITEM", currentItem);
                    v.getContext().startActivity(intent);
                }
            });
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
        itemViewHolder.itemUser.setText(items.get(i).user);
        itemViewHolder.itemPhoto.setImageResource(items.get(i).photoId);
        itemViewHolder.currentItem = items.get(i);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
