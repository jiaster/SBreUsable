package com.example.jiaweizheng.sbreusable;
/**
 * Created by richie- on 3/3/2018.
 */
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MessageRVAdapter extends RecyclerView.Adapter<MessageRVAdapter.ItemViewHolder> {


    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView itemName;
        TextView itemDescription;
        TextView itemUser;
        ImageView itemPhoto;

        public Conversation currentConvo;

        ItemViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            itemName = itemView.findViewById(R.id.item_name);
            itemDescription = itemView.findViewById(R.id.item_description);
            itemUser = itemView.findViewById(R.id.item_user);
            itemPhoto = itemView.findViewById(R.id.item_photo);
            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), viewItemActivity.class);
                    intent.putExtra("CURRENT_ITEM", currentConvo);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    private List<Conversation> conversations;

    MessageRVAdapter(List<Conversation> conversations){

        this.conversations = conversations;
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
        itemViewHolder.itemName.setText(conversations.get(i).getName());
        itemViewHolder.itemUser.setText(conversations.get(i).getUser());
        itemViewHolder.itemPhoto.setImageDrawable(conversations.get(i).getReducedPhoto());
        itemViewHolder.currentConvo = conversations.get(i);
    }

    @Override
    public int getItemCount() {
        return conversations.size();
    }
}
