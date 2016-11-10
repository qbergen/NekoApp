package com.example.queenabergen.accessnow30;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by queenabergen on 10/31/16.
 */

public class AccessAdapter extends RecyclerView.Adapter<AccessAdapter.DataHolder> {
    private List<ListItem> listData;
    private LayoutInflater inflater;

    public AccessAdapter(List<ListItem> listData, Context c){
        inflater = LayoutInflater.from(c);
        this.listData = listData;
    }

    @Override
    public AccessAdapter.DataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.viewholder, parent, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(DataHolder holder, int position) {
        ListItem item = listData.get(position);
        holder.icon.setImageResource(item.getImageResId());
    }


    @Override
    public int getItemCount() {
        return listData.size();
    }

    class DataHolder extends RecyclerView.ViewHolder {
        private ImageView icon;


        public DataHolder(View itemView) {
            super(itemView);
            icon = (ImageView)itemView.findViewById(R.id.ImageView);
        }

    }
}
